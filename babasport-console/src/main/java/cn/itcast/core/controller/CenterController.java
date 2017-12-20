package cn.itcast.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.core.bean.TestTb;
import cn.itcast.core.service.TestTbService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
	
	
}
