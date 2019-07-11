package com.hwy.cache.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;

public class TData implements Serializable {
    /**
    * 数据id，自增主键
    */
    @NotNull
    private Integer dataId;

    /**
    * t_app_key的id，外键
    */
    @NotNull
    private Integer appKeyId;

    /**
    * key的id
    */
    private Integer keyId;

    /**
    * 市场id，外键
    */
    private Integer siteId;

    /**
    * 组id
    */
    private Integer groupId;

    /**
    * region id
    */
    private Integer regionId;

    /**
    * 语种id，外键
    */
    private Integer localeId;

    /**
    * 币种id，外键
    */
    private Integer currencyId;

    /**
    * 产线id，外键
    */
    private Integer channelId;

    /**
    * 来源id，外键
    */
    private Integer sourceId;

    /**
    * 适配版本范围（APP端）
    */
    private String appVersion;

    /**
    * 其它条件
    */
    private String other;

    /**
    * 配置所属的应用AppId
    */
    @NotNull
    private String appId;

    /**
    * 排序字段
    */
    @NotNull
    private Integer orderNum;

    /**
    * 状态（默认值为1，1表示纯文本，2表示json格式的数据，3表示表达式）
    */
    @NotNull
    private Integer type;

    /**
    * 数据key描述信息
    */
    private String description;

    /**
    * 需要灰度的ip标识
    */
    private String ipToken;

    /**
    * 使用中的已发布数据（0表示未使用，1表示使用中）
    */
    @NotNull
    private Short useTag;

    /**
    * 状态（高位0生效，高位1删除；低两位的1新建/待发布、2灰度、0已发布）
    */
    @NotNull
    private Short status;

    /**
    * 版本号（默认为1）
    */
    @NotNull
    private Integer version;

    /**
    * 创建时的操作人
    */
    @NotNull
    private String createOperator;

    /**
    * 最后一次更新的操作人
    */
    @NotNull
    private String updateOperator;

    /**
    * 创建时间
    */
    @NotNull
    private Date createTime;

    /**
    * 更新时间
    */
    @NotNull
    private Date datachangeLasttime;

    /**
    * 数据的值
    */
    @NotNull
    private String value;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getAppKeyId() {
        return appKeyId;
    }

    public void setAppKeyId(Integer appKeyId) {
        this.appKeyId = appKeyId;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getLocaleId() {
        return localeId;
    }

    public void setLocaleId(Integer localeId) {
        this.localeId = localeId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion == null ? null : appVersion.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIpToken() {
        return ipToken;
    }

    public void setIpToken(String ipToken) {
        this.ipToken = ipToken == null ? null : ipToken.trim();
    }

    public Short getUseTag() {
        return useTag;
    }

    public void setUseTag(Short useTag) {
        this.useTag = useTag;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateOperator() {
        return createOperator;
    }

    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator == null ? null : createOperator.trim();
    }

    public String getUpdateOperator() {
        return updateOperator;
    }

    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDatachangeLasttime() {
        return datachangeLasttime;
    }

    public void setDatachangeLasttime(Date datachangeLasttime) {
        this.datachangeLasttime = datachangeLasttime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

}