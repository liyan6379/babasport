package cn.itcast.core.bean.product;

import java.io.Serializable;

public class Brand implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long brandId;

    private String brandName;

    private String description;

    private String brandImgUrl;

    private String webSite;

    private Integer sort;

    private Byte isDisplay;

    public Brand() {
    }

    public Brand(Long brandId, String brandName, String description, String brandImgUrl, String webSite, Integer sort, Byte isDisplay) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.description = description;
        this.brandImgUrl = brandImgUrl;
        this.webSite = webSite;
        this.sort = sort;
        this.isDisplay = isDisplay;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandImgUrl() {
        return brandImgUrl;
    }

    public void setBrandImgUrl(String brandImgUrl) {
        this.brandImgUrl = brandImgUrl;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public void setIsDisplay(Byte isDisplay) {
        this.isDisplay = isDisplay;
    }

    public Byte getIsDisplay() {
        return isDisplay;
    }
}