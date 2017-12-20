package com.itcast.core.utils;

import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * <p></p>
 * @author Rylan 2015年7月25日 下午3:47:59
 * @ClassName PropertiesUtil
 * @Description 优化版配置文件读取。解决读取配置文件频繁io问题。使用读写锁解决HashMap的 put和get的线程安全问题。也可以换成ConcurrentHashMap
 * @version V1.0   
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: Rylan 2015年7月25日
 * @modify by reason:{方法名}:{原因}
 */
public class PropertiesUtil {
    	
	private static final Logger logger = Logger.getLogger(PropertiesUtil.class);
	
	private static Map<String,Properties> config=new HashMap<String,Properties>();
	
	//private static Lock lock=new ReentrantLock();
	private static ReadWriteLock rwLock=new ReentrantReadWriteLock();
	private static Lock rLock=rwLock.readLock();
	private static Lock wLock=rwLock.writeLock();
	
	
	/*配置文件直接在下面初始化*/
	static {		
//		initPropertie("/properties/message.properties");
//		initPropertie("/properties/alipay.properties");
//		initPropertie("/properties/wechat.properties");
	}
	
	private static  void  initPropertie(String fileName) {
		if(logger.isDebugEnabled()){
			logger.debug("begin initPropertie "+fileName);
		}		
		Properties props = new Properties();  
		try {
			props.load(PropertiesUtil.class.getResourceAsStream(fileName));
		} catch (IOException e) {
			logger.warn("PropertiesUtil initPropertie "+fileName+" failed.");
		}
		config.put(fileName, props);	
	}
	
    public static  void  clearProperties(){
    	wLock.lock();
    	try{
    			config.clear();  
    	}
    	finally {
    		wLock.unlock();
    	}  	
    	
    }	
	
    public static  void  clearProperties(String fileName){
    	wLock.lock();
    	try{
    		config.remove(fileName);    	
    	}
    	finally {
    		wLock.unlock();
    	}  	
    	
    }	
	/**
	 * @author Rylan 2015年6月4日 下午2:33:23
	 * @Method: getProperty 
	 * @Description: 读取配置文件，没取到线程同步 缓存进去
	 * @param propertiesFileName  根据配置文件propertiesFileName和key值获取value
	 * @param key
	 * @return 
	 * @throws
	 */
	 public static String getProperty(String proFileName, String key) {  		 
		 rLock.lock();
		 try{
			 if(config.get(proFileName) != null){
				 return (String)config.get(proFileName).get(key);
		     }
		 }finally{
			 rLock.unlock();
		 }
		 
		 
		wLock.lock();
		try {
			if (config.get(proFileName) == null) {
				Properties props = new Properties();
				props.load(PropertiesUtil.class.getResourceAsStream(proFileName));
				config.put(proFileName, props);
			}
		} catch (IOException e) {
			logger.error("getResourceAsStream has exception.", e);
		} finally {
			wLock.unlock();
		}			
		 return (String)config.get(proFileName).get(key); 	 
	 }
	 
	 /**
	  * @author Rylan 2015年6月4日 下午2:33:27
	  * @Method: setProperty 
	  * @Description:    根据配置文件propertiesFileName和key值value值
	  * @param propertiesFileName 
	  * @param key
	  * @param value 
	  * @throws
	  */
	public static void setProperty(String proFileName, String key,String value) {
		Properties props = new Properties();
		OutputStream os = null;
		try {
			String classRootPath = PropertiesUtil.class.getResource("/").toString();
			if ("Windows".indexOf(System.getProperty("os.name")) != -1)
				classRootPath = classRootPath.replace("file:/", "");
			else
				classRootPath = classRootPath.replace("file:", "");
			props.load(PropertiesUtil.class.getResourceAsStream( proFileName));
			os = new FileOutputStream(classRootPath + proFileName);
			props.put(key, value);
			props.store(os, "");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					logger.error("exception .",e);
				}
		}
	} 
		
}
