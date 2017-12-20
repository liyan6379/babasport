package com.itcast.core.pub;

public final class MessageCode {

	/**
	 * 系统常量------------------------------------------------------------------
	 */
	public final static int SUCCESS = 200;
	/**
	 * 系统未知异常
	 */
	public final static int SYSTEM_UNKNOWN_ERR = -1;
	/**
	 * 系统异常
	 */
	public final static int SYSTEM_ERR = 1;
	/**
	 * 操作失败
	 */
	public final static int SYSTEM_OPERATE_ERR = 2;
	/**
	 * 权限不够
	 */
	public final static int SYSTEM_AUTH_ERR = 3;
	/**
	 * 参数错误
	 */
	public final static int SYSTEM_PARAMETER_ERR = 4;
	
	/**
	 * 未找到请求的内容
	 */
	public final static int SYSTEM_NOTFOUND=5;

    /**
	 * 数据库异常
	 */
	public static int JDBC_Exception=501;

	//user
	public static int USER_NOT_EXIST=3001;
	public static int USER_IS_EXIST=3014;
	public static int WRONG_PASSWORD=3002;
	public static int WRONG_VERIFYCODE=3003;
	public static int DIFFRIENT_PASSWORD=3004;
	public static int PASSWORD_NULL=3005;
	public static int MOBILE_NULL=3006;
	public static int REMOTE_NULL=3007;
	public static int CLIENT_UUID_NULL=3008;
	public static int CLIENT_VERSION_NULL=3009;
	public static int CLIENT_OS_NULL=3010;

	public static int USER_LOGIN_FILED =3011;

	public static final int USER_LOGOUT_FILED = 3012;


    public static final int USER_CODE_TYPE_NOT_EXIST = 3013;

    public static final int USER_ALREADY_EXIST =3014;
	public static final int USER_NOT_LOGIN = 3015;
	public static final int USER_ALREADY_HAS_IDCARD = 3016;
    public static final int IDCARD_HAS_BEAN_USED = 3017;

	public static final int BEST_SIGN_FILED =4001;
	public static final int FAVORITES_NULL =4002;
	public static final int FAVORITES_EXIST =4003;
	public static final int REGIST_FILED =4004;
	public static final int FILED =4005;

	public static final int SENDCONTRACT_FILED =4006;
	public static final int NULL =4007;
}
