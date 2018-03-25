package cn.e3mall.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @description 商品搜索结果对象封装类
 * @author JiangBin
 * @date 2018年3月12日 下午10:27:01
 * @version 1.0.0 @
 */
public class SearchResult implements Serializable {
	/**
	 * 搜索商品结果
	 */
	private List<SearchItem> itemList;
	/**
	 * 总页数
	 */
	private int totalPages;
	/**
	 * 总记录数
	 */
	private int recourdCount;

	public List<SearchItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<SearchItem> itemList) {
		this.itemList = itemList;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getRecourdCount() {
		return recourdCount;
	}

	public void setRecourdCount(int recourdCount) {
		this.recourdCount = recourdCount;
	}

}
