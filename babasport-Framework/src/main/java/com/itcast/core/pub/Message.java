package com.itcast.core.pub;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.itcast.core.utils.PropertiesUtil;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * @author Rylan 2015年7月22日 下午7:42:59
 * @version V1.0
 * @ClassName Message
 * @Description
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: Rylan 2015年7月22日
 * @modify by reason:{方法名}:{原因}
 */
public class Message implements Serializable {

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 4307622177764710638L;

    public final static int SUCCESS = 200;

    private final static String CONFIG_URL = "/properties/message.properties";

    private int code = 200;

    private String msg = "";

    private Map<String, Object> data = new LinkedHashMap<String, Object>();

    private Exception exception;

    public Message() {
    }

    public Message(String type) {
        this.msg = PropertiesUtil.getProperty(CONFIG_URL, type + "");
    }

    public Message(int code, Map<String, Object> args) {
        this.msg = PropertiesUtil.getProperty(CONFIG_URL, code + "");
        this.code = code;
        this.data = args;
    }

    public Message(int code, String message, Map<String, Object> args) {
        this.code = code;
        this.msg = message;
        this.data = args;
    }

    public Message(int code, Exception exception) {
        this.code = code;
        this.exception = exception;
    }

    public static Message success() {
        return new Message(200, new LinkedHashMap<String, Object>());
    }

    public static Message warn(int code) {
        return new Message(code, new LinkedHashMap<String, Object>());
    }

    public static Message error(int code) {
        return new Message(code, new LinkedHashMap<String, Object>());
    }

    public static Message error(int code, String content) {
        return new Message(code, content, new LinkedHashMap<String, Object>());
    }

    public static Message error(Exception exception) {
        if (exception instanceof ServiceException) {
            return Message.error(((ServiceException) exception).getCode());
        } else {
            exception.printStackTrace();
            return new Message(MessageCode.SYSTEM_ERR, exception);
        }
    }

    public static Message error(int code, Object params[]) {
        String msg = MessageFormat.format(PropertiesUtil.getProperty(CONFIG_URL, code + ""), params);
        return new Message(code, msg, new LinkedHashMap<String, Object>());
    }

    public static Message success(Map<String, Object> args) {
        return new Message(200, args);
    }


    public static ServiceException exception(int type) throws ServiceException {
        throw new ServiceException(type);
    }

    public static ServiceException exception(int type, String message) throws ServiceException {
        throw new ServiceException(type, message);
    }

    public static Message warn(int type, Map<String, Object> args) {
        return new Message(type, args);
    }

    public static Message error(int type, Map<String, Object> args) {
        return new Message(type, args);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void addData(String key, Object arg) {
        if (this.data == null) {
            data = new LinkedHashMap<String, Object>();
        }
        data.put(key, arg);
    }


    public void removeData(String key) {
        if (StringUtils.isNotEmpty(key)) {
            data.remove(key);
        }
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }


}
