package com.education.framework.common.base;
/**
 * StatusCode callback code
 * 
 * @author wangshengli
 * @date 2017/12/12 
 */
public enum ResultCode {

	MEF_CODE_00000(0, "成功");
	
	private int code;
	private String msg;
	private String showMsg;

	public int getCode() {
		return code;
	}

	public String getCodeString() {
		return String.valueOf(code);
	}

	public String getMsg() {
		return msg;
	}

	public String getShowMsg() {
		if (isBlank(showMsg))
			return getMsg();
		return showMsg;
	}

	ResultCode(int code, String msg, String... showMsg) {
		this.code = code;
		this.msg = msg;
		if (showMsg.length > 0)
			this.showMsg = showMsg[0];
	}

	public static ResultCode getByCode(int code) {

		for (ResultCode e : values()) {
			if (e.code == code) {
				return e;
			}
		}

		return null;
	}
	
	public static boolean isBlank(String str){
		int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
	}
	
}
