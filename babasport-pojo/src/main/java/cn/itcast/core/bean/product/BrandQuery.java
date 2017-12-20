package cn.itcast.core.bean.product;

import java.io.Serializable;

/**
 * 品牌
 * @author lx
 *
 */
public class BrandQuery implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long brandId;

	private String brandName;

	private String description;

	private String brandImgUrl;

	private String webSite;

	private Integer sort;

	private Byte isDisplay;

	@Override
	public String toString() {
		return "BrandQuery{" +
				"brandId=" + brandId +
				", brandName='" + brandName + '\'' +
				", description='" + description + '\'' +
				", brandImgUrl='" + brandImgUrl + '\'' +
				", webSite='" + webSite + '\'' +
				", sort=" + sort +
				", isDisplay=" + isDisplay +
				", pageNo=" + pageNo +
				", pageSize=" + pageSize +
				", startRow=" + startRow +
				'}';
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

	public Byte getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Byte isDisplay) {
		this.isDisplay = isDisplay;
	}

	//附加字段
	private Integer pageNo = 1;
	private Integer pageSize = 10;
	//开始行
	private Integer startRow;
	
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		//计算开始行
		this.startRow = (pageNo-1)*pageSize;
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		//计算开始行
		this.startRow = (pageNo-1)*pageSize;
		this.pageSize = pageSize;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}


	public BrandQuery() {
	}

	public BrandQuery(Long brandId, String brandName, String description, String brandImgUrl, String webSite, Integer sort, Byte isDisplay, Integer pageNo, Integer pageSize, Integer startRow) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.description = description;
		this.brandImgUrl = brandImgUrl;
		this.webSite = webSite;
		this.sort = sort;
		this.isDisplay = isDisplay;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.startRow = startRow;
	}
}
