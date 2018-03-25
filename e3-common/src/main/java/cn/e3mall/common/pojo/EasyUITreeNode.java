package cn.e3mall.common.pojo;

import java.io.Serializable;

/**   
 * @description  用于描述展示商品分类tree信息
 * @author JiangBin   
 * @date 2018年2月25日 下午8:20:53 
 * @version 1.0.0  
 * @
 */
public class EasyUITreeNode implements Serializable {

	/**
	 * 类别ID
	 */
	private long id;
	
	/**
	 * 类别信息 
	 */
	private String text;
	
	/**
	 * 节点状态（是否展开，closed关闭，open展开）
	 */
	private String state;

	public EasyUITreeNode() {
		super();
	}

	public EasyUITreeNode(long id, String text, String state) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
