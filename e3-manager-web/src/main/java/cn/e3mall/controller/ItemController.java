package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

/**   
 * @description  商品管理Controller
 * @author JiangBin   
 * @date 2018年2月23日 下午9:58:44 
 * @version 1.0.0  
 * @
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService  itemService;
	
	/** 
	 * @description 根据商品id查询商品规格信息
	 * @param itemId
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年2月23日 下午10:02:11
	 * @version 1.0.0
	 */
	@RequestMapping("/rest/item/param/item/query/{itemId}")
	@ResponseBody
	private E3Result geTbItemById(@PathVariable Long itemId) {
		E3Result e3Result = itemService.getItemById(itemId);
		return e3Result;
	}
	
	/** 
	 * @description 根据商品id查询商品详情
	 * @param itemId
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年2月28日 下午8:28:17
	 * @version 1.0.0
	 */
	@RequestMapping("/rest/item/query/item/desc/{itemId}")
	@ResponseBody
	private E3Result geTbItemDescById(@PathVariable Long itemId) {
		E3Result e3Result = itemService.getItemDescById(itemId);
		return e3Result;
	}
	
	/** 
	 * @description 根据分页信息获取分页结果
	 * @param page
	 * @param rows
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年2月24日 下午8:55:05
	 * @version 1.0.0
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		EasyUIDataGridResult itemList = itemService.getItemList(page, rows);
		return itemList;
	}
	
	/** 
	 * @description 添加商品
	 * @param item
	 * @param desc
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年2月26日 下午11:48:06
	 * @version 1.0.0
	 */
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	public E3Result saveItem(TbItem item, String desc) {
		E3Result e3Result = itemService.addItem(item, desc);
		return e3Result;
	}
	
	/** 
	 * @description 批量删除商品
	 * @param items
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年2月27日 下午10:04:35
	 * @version 1.0.0
	 */
	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public E3Result deleteItem(String ids) {
		String[] itemIds = ids.split(",");	
		E3Result e3Result = itemService.deleteItem(itemIds);
		return e3Result;
	}
	
	/** 
	 * @description 修改商品
	 * @param item
	 * @param desc
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年2月28日 下午8:22:56
	 * @version 1.0.0
	 */
	@RequestMapping("/rest/item/update")
	@ResponseBody
	public E3Result updateItem(TbItem item, String desc) {
		E3Result e3Result = itemService.updateItem(item, desc);
		return e3Result;
	}
	
	/** 
	 * @description 批量下架商品
	 * @param ids
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年2月28日 下午8:26:51
	 * @version 1.0.0
	 */
	@RequestMapping("/rest/item/instock")
	@ResponseBody
	public E3Result putOffItem(String ids) {
		String[] itemIds = ids.split(",");	
		E3Result e3Result = itemService.putOffItem(itemIds);
		return e3Result;
	}
	
	/** 
	 * @description 批量下架商品
	 * @param params
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年2月28日 下午8:46:10
	 * @version 1.0.0
	 */
	@RequestMapping("/rest/item/reshelf")
	@ResponseBody
	public E3Result putUpItem(String ids) {
		String[] itemIds = ids.split(",");	
		E3Result e3Result = itemService.putUpItem(itemIds);
		return e3Result;
	}
}
