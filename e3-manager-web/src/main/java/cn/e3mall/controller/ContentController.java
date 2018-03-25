package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;

/**   
 * @description  内容管理的controller
 * @author JiangBin   
 * @date 2018年3月1日 下午9:14:27 
 * @version 1.0.0  
 * @
 */
@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	/** 
	 * @description 新增内容
	 * @param content
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月5日 下午10:03:29
	 * @version 1.0.0
	 */
	@RequestMapping("/content/save")
	@ResponseBody
	public E3Result addContent(TbContent content) {
		E3Result e3Result = contentService.addContent(content);
		return e3Result;
	}
	
	
	/** 
	 * @description 获取列表信息
	 * @param content
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月5日 下午10:52:52
	 * @version 1.0.0
	 */
	@RequestMapping("/content/query/list")
	@ResponseBody
	public EasyUIDataGridResult listContent(Long categoryId,Integer page,Integer rows) {
		EasyUIDataGridResult contentList = contentService.getContentList(categoryId, page, rows);
		return contentList;
	}
	
	/** 
	 * @description 修改内容信息
	 * @param content
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月5日 下午10:58:56
	 * @version 1.0.0
	 */
	@RequestMapping("/rest/content/edit")
	@ResponseBody
	public E3Result updateContent(TbContent content) {
		E3Result e3Result = contentService.updateContent(content);
		return e3Result;
	}
	
	/** 
	 * @description 删除内容信息
	 * @param ids
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月5日 下午11:00:26
	 * @version 1.0.0
	 */
	@RequestMapping("/content/delete")
	@ResponseBody
	public E3Result deleteContent(String ids) {
		String[]  contentIds= ids.split(",");
		E3Result e3Result = contentService.deleteContent(contentIds);
		return e3Result;
	}
}
