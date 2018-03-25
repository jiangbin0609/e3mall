package cn.e3mall.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @description 分页信息用于响应json数据
 * @author JiangBin
 * @date 2018年2月24日 下午8:26:14
 * @version 1.0.0 
 * @
 */
public class EasyUIDataGridResult implements Serializable {

	/**
	 * 总记录数
	 */
	private long total;
	
	/**
	 * 分页数据
	 */
	private List rows;

	public EasyUIDataGridResult() {
		super();
	}

	public EasyUIDataGridResult(long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
