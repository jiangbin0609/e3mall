package cn.e3mall.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.e3mall.common.pojo.SearchResult;
import cn.e3mall.search.service.SearchService;

/**
 * @description 首页商品搜索
 * @author JiangBin
 * @date 2018年3月12日 下午11:08:38
 * @version 1.0.0 @
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@Value("${PAGE_ROWS}")
	private Integer PAGE_ROWS;

	/** 
	 * @description 首页搜索服务
	 * @param keyword
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月12日 下午11:15:26
	 * @version 1.0.0
	 */
	@RequestMapping("/search")
	public String search(String keyword, @RequestParam(defaultValue = "1") Integer page, Model model) throws Exception {
		// 转码
		keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
		// 获取查询结果
		SearchResult result = searchService.search(keyword, page, PAGE_ROWS);

		// 把结果传递给jsp页面
		model.addAttribute("query", keyword);
		model.addAttribute("totalPages", result.getTotalPages());
		model.addAttribute("recourdCount", result.getRecourdCount());
		model.addAttribute("page", page);
		model.addAttribute("itemList", result.getItemList());

		// 返回逻辑视图
		return "search";
	}

}
