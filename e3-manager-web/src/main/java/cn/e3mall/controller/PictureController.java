package cn.e3mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;

/**   
 * @description  图片上传管理
 * @author JiangBin   
 * @date 2018年2月26日 下午10:27:11 
 * @version 1.0.0  
 * @
 */
@Controller
public class PictureController {

	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;

	/** 
	 * @description 上传图片到服务器
	 * @param uploadFile
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年2月26日 下午10:27:26
	 * @version 1.0.0
	 */
	@RequestMapping(value="/pic/upload", produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String fileUpload(MultipartFile uploadFile) {
		try {
			// 1.获取文件的扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			// 2.创建一个FastDFS的客服端
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			// 3.执行上传操作
			String path = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			// 4.拼接返回的URL和IP地址，拼接成完整的URL地址
			String url = IMAGE_SERVER_URL + path;
			// 5.返回map
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url", url);
		
			//转换成json数据
			String json = JsonUtils.objectToJson(result);
			return json;
		} catch (Exception e) {
			// 5.返回map
			Map result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "图片上传失败");
			//转换成json数据
			String json = JsonUtils.objectToJson(result);
			return json;
		}
	}
}
