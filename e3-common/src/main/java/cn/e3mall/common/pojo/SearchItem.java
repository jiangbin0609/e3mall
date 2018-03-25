package cn.e3mall.common.pojo;

import java.io.Serializable;

/**
 * @description solr工程item搜索数据封装对象
 * @author JiangBin
 * @date 2018年3月11日 下午8:28:02
 * @version 1.0.0 @
 */
public class SearchItem implements Serializable{
	/**
	 * 商品ID
	 */
	private String id;
	/**
	 * 商品名
	 */
	private String title;
	/**
	 * 商品卖点
	 */
	private String sell_ponit;
	/**
	 * 商品价格
	 */
	private Long price;
	/**
	 * 商品图片地址
	 */
	private String image;
	/**
	 * 商品类别名
	 */
	private String categroy_name;

	public SearchItem() {

	}

	public SearchItem(String id, String title, String sell_ponit, Long price, String image, String categroy_name) {
		super();
		this.id = id;
		this.title = title;
		this.sell_ponit = sell_ponit;
		this.price = price;
		this.image = image;
		this.categroy_name = categroy_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSell_ponit() {
		return sell_ponit;
	}

	public void setSell_ponit(String sell_ponit) {
		this.sell_ponit = sell_ponit;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategroy_name() {
		return categroy_name;
	}

	public void setCategroy_name(String categroy_name) {
		this.categroy_name = categroy_name;
	}

	@Override
	public String toString() {
		return "SearchItem [id=" + id + ", title=" + title + ", sell_ponit=" + sell_ponit + ", price=" + price
				+ ", image=" + image + ", categroy_name=" + categroy_name + "]";
	}

}
