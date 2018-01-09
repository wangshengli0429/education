package com.education.framework.common.base;

import com.education.framework.common.util.JsonUtil;




/**
 * StatusCode callback code
 * 
 * @author kayson Yang
 * @date 2016/6/19 0017
 */
public enum StatusCode {
 
	EDU_CODE_000(0, "成功"), //
	EDU_CODE_001(1, "失败","失败"), //
	EDU_CODE_002(2, "新增数据失败","新增数据失败"),
	EDU_CODE_003(3, "新增数据成功","新增数据成功"),
	EDU_CODE_004(4, "修改数据失败","修改数据失败"),
	EDU_CODE_005(5, "修改数据成功","修改数据成功"),
	EDU_CODE_006(6, "删除数据失败","删除数据失败"),
	EDU_CODE_007(7, "删除数据成功","删除数据成功"),
	EDU_CODE_008(8, "查询数据失败","查询数据失败"),
	EDU_CODE_009(9, "查询数据成功","查询数据成功"),
	
	EDU_CODE_010(10,"缺少必填参数","缺少必填参数"),
	
	
	
	
	
	; //
	
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

	StatusCode(int code, String msg, String... showMsg) {
		this.code = code;
		this.msg = msg;
		if (showMsg.length > 0)
			this.showMsg = showMsg[0];
	}

	public static StatusCode getByCode(int code) {

		for (StatusCode e : values()) {
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
	

	/**
	 * 重载toString方法，打印自定义字段
	 */
	@Override
	public String toString() {
		return super.toString() + ">>" + JsonUtil.json2String(this);
	}
}
