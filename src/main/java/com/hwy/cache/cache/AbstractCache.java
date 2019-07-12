package com.hwy.cache.cache;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 21:56
 */
public abstract class AbstractCache<T, V extends Cache.Entry> implements Cache<T, V>{


    AbstractCache(String cacheName) {
        this.cacheName = cacheName;
    }

    private static final Integer INITIAL_CAPACITY = 1 <<7;

    private static final Integer LOAD_DATA_NUMBER = 1;

    private static final Integer LOADER_NUMBER = 1;

    private static final Integer WAIT_TIME = 10;

    private String cacheName;


    private volatile ConcurrentHashMap<String, V> cache = new ConcurrentHashMap<>(INITIAL_CAPACITY);


    private final ExecutorService loadDataExecutor = Executors.newFixedThreadPool(LOAD_DATA_NUMBER, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.setName(String.format("%s-data-load-data", cacheName));
            return thread;
        }
    });

    /**
     * The executor for loading data
     */
    private final ScheduledExecutorService loaderExecutor = Executors.newScheduledThreadPool(LOADER_NUMBER, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.setName(String.format("%s-loader", cacheName));
            return thread;
        }
    });

    private final ScheduledExecutorService singleDataProcessor = Executors.newScheduledThreadPool(LOADER_NUMBER, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.setName(String.format("%s-data process", cacheName));
            return thread;
        }
    });

    private final Runnable loadRunner = new Runnable() {
        @Override
        public void run() {
            List<T> dataList = null;

            try {
                try {
                    Future<List<T>> future = loadDataExecutor.submit(new DataLoaderTask());
                    dataList = future.get(WAIT_TIME, TimeUnit.SECONDS);
                } catch (InterruptedException | ExecutionException | TimeoutException e) {
                    e.printStackTrace();
                }
                process(dataList);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public void process(List<T> dataList) {
        if(dataList != null) {
            ConcurrentHashMap<String, T> newCache = new ConcurrentHashMap<>();
            CountDownLatch countDownLatch = new CountDownLatch(dataList.size());
            for(T data : dataList) {
                try{
                    handle(data, newCache, countDownLatch);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void handle(T data, ConcurrentHashMap newCache, CountDownLatch countDownLatch) {
        singleDataProcessor.execute(new Runnable() {
            @Override
            public void run() {
                if(data != null) {
                    V newData = convertData(data);
                    V oldData =  cache.get(newData.getCacheKey());
                    String cacheKey = getCacheKey(data);
                    if(newData.equals(oldData)) {
                        newCache.put(cacheKey, data);
                    }

                    newCache.put(cacheKey, data);
                }
            }
        });

    }

    @Override
    public V get(String cacheKey) {
        return cache.get(cacheKey);
    }

    @Override
    public V get(String cacheKey, boolean needUpdate) {
        return cache.get(cacheKey);
    }

    @Override
    public Collection<V> getAll() {
        if(!cache.isEmpty())
            return cache.values();
        return null;
    }

    @Override
    public void init(AbstractCache cache) {
        loaderExecutor.execute(loadRunner);

    }

    private class DataLoaderTask implements Callable {
        @Override
        public List<T> call() throws Exception {
            return load();
        }


    }

     abstract List<T> load();

     abstract V convertData(T t);

     abstract boolean needUpdate(V previous, V current);

     abstract String getCacheKey(T data);

}
