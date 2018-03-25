package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.search.service.SearchItemService;

/**   
 * @description  商品solr服务管理
 * @author JiangBin   
 * @date 2018年3月12日 下午10:21:25 
 * @version 1.0.0  
 * @
 */
@Controller
public class SearchItemController {

	@Autowired
	private SearchItemService searchItemService;
	
	/** 
	 * @description 将商品信息导入索引库
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月12日 下午10:25:38
	 * @version 1.0.0
	 */
	@RequestMapping("/index/item/import")
	@ResponseBody
	public E3Result importItemIndex() {
		E3Result e3Result = searchItemService.importItems();
		return e3Result;
	}
}
