package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;

/**   
 * @description 网站内容分类管理 
 * @author JiangBin   
 * @date 2018年3月1日 下午8:52:29 
 * @version 1.0.0  
 * @
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	/** 
	 * @description 获取网站类容分类信息
	 * @param parentId
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月1日 下午8:52:24
	 * @version 1.0.0
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCatList(@RequestParam(value="id",defaultValue="0") Long parentId){
		List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(parentId);
		return list;
	}
	
	/** 
	 * @description 添加分类节点
	 * @param parentId 父节点ID
	 * @param name 新增节点的名字
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月1日 下午9:07:22
	 * @version 1.0.0
	 */
	@RequestMapping("/create")
	@ResponseBody
	public E3Result createCategroy(Long parentId,String name) {
		E3Result e3Result = contentCategoryService.addContentCategory(parentId, name);
		return e3Result;
	}
	
	/** 
	 * @description 修改节点信息
	 * @param parentId
	 * @param name
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月4日 下午10:57:32
	 * @version 1.0.0
	 */
	@RequestMapping("/update")
	@ResponseBody
	public E3Result updateCategroy(Long id,String name) {
		E3Result e3Result = contentCategoryService.updateContentCategory(id, name);
		return e3Result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public E3Result deleteCategroy(Long id) {
		E3Result e3Result = contentCategoryService.deleteContentCategory(id);
		return e3Result;
	}
}
