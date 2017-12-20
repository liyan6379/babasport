package com.itcast.core.pub;

import java.io.Serializable;
import java.util.List;
/**
 * Created by liyan on 2017/8/2.
 */
public class Page<T> implements Serializable{
	private static final long serialVersionUID = 4307622177764710638L;

	private List<T> list;
	private int pageSize = 10;
	private int pageNo;
	private int totalRecordNo;
	private int totalPageNo;
	
	public Page(String pageNoStr, int totalRecordNo) {
		
		//1.计算总页数
		//①给totalRecordNo赋值
		this.totalRecordNo = totalRecordNo;
		
		//②执行计算
		//如果能够整除则不加1，整除加1
		this.totalPageNo = (totalRecordNo / pageSize) + ((totalRecordNo % pageSize == 0) ? 0 : 1);
		
		//2.修正pageNo
		//①给pageNo设置默认值
		this.pageNo = 1;
		
		//②类型转换
		try {
			this.pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {/*如果类型转换失败，则保持默认值*/}
		
		//③在1~totalPageNo之间进行修正
		if(pageNo > totalPageNo) {
			pageNo = totalPageNo;
		}
		
		if(pageNo < 1) {
			pageNo = 1;
		}
		
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getTotalRecordNo() {
		return totalRecordNo;
	}

	public int getTotalPageNo() {
		return totalPageNo;
	}
	
	//${page.hasPrev}
	public boolean isHasPrev() {
		return pageNo > 1;
	}
	
	public boolean isHasNext() {
		return pageNo < totalPageNo;
	}
	
	public int getPrev() {
		return pageNo - 1;
	}
	
	public int getNext() {
		return pageNo + 1;
	}
	
	public int getIndex() {
		return (pageNo - 1)*pageSize;
	}

}
