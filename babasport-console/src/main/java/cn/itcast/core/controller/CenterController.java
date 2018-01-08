package cn.itcast.core.controller;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.core.bean.TestTb;
import cn.itcast.core.service.TestTbService;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 后台管理
 * @author lx
 *
 */
@Controller
public class CenterController {


	@Autowired
	private TestTbService testTbService;
	
	//入口
	/**
	 * ModelAndView  : 跳转视图+数据     不用
	 * void  : 异步时 ajax    
	 * String  : 跳转视图      +  Model
	 */
	@RequestMapping(value = "/test/index.do")
	public String index(Model model, @RequestParam(required = false,value = "name")String name){
		TestTb testTb = new TestTb();
		testTb.setName("范冰冰11");
		testTbService.insertTestTb(testTb);
		return "index";
	}


	public static void main(String[] args) throws Exception {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("172.17.1.46");
		ftpClient.login("ftpuser", "123456");
		FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\14-1604291H30N55.jpg"));
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dir = format.format(new Date());
		String dir2 = dir.replaceAll("\\-", "");

		boolean flag = ftpClient.makeDirectory(dir2);
		if (flag) {
			System.out.println("make Directory " +dir +" succeed");

		} else {
			System.out.println("make Directory " +dir+ " false");
		}
		ftpClient.enterLocalPassiveMode();
		ftpClient.storeFile(dir2+"/21-1604291H30N55.jpg", inputStream);
		inputStream.close();
		ftpClient.logout();
	}

	public static String getUUID(){
		String s = UUID.randomUUID().toString();
//去掉"-"符号
		String s1 = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
		System.out.println(s1);
		return s1;
	}
}
