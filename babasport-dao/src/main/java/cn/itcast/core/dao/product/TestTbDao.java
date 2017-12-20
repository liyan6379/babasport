package cn.itcast.core.dao.product;

import cn.itcast.core.bean.TestTb;

import java.util.List;

/**
 * 测试
 * @author lx
 *
 */
public interface TestTbDao {

	
	//保存
	 void insertTestTb(TestTb testTb);

	List<TestTb> selectTestTb(String name);
}
