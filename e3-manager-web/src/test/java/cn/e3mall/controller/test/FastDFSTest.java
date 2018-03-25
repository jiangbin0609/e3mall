package cn.e3mall.controller.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

public class FastDFSTest {

	@Test
	public void testFileUpload() throws FileNotFoundException, IOException, MyException {
		// 1.加载配置文件，配置文件的内容就是Tracker服务地址
		ClientGlobal.init("D:\\Java\\git\\e3-manager-web\\src\\main\\resources\\conf\\client.conf");
		// 2.创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		// 3.使用TrackerClient对象创建连接，获取一个trackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		// 4.创建一个storageServer的引用，值为null；
		StorageServer storageServer = null;
		// 5.创建一个storageclient对象，需要两个参数TrackerServer，storageServer的引用
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 6.使用storageClient对象上传图片
		String[] strings = storageClient.upload_file("E:\\图片\\702ceb5dfa52fbcb02fa012fdbb9f477.jpg", "jpg", null);
		// 7.返回数组，包含组名和图片的路径
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testFastDfsClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient("D:\\Java\\git\\e3-manager-web\\src\\main\\resources\\conf\\client.conf");
		String file = fastDFSClient.uploadFile("E:\\图片\\a1ae93be901153d30a554aee65847a07.jpg");
		System.out.println(file);
	}
}
