package com.education.framework.model.constant;

/**
 * @author zhoulin
 * @createTime 2018/7/10.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/10.
 * @note
 */
public class SubjectEnum {

    public static final String DEPARTMENT_TYPE = "department";

    public static enum departmentCode{

        /**
         * 小学
         */
        xiaoxue("0"),

        /**
         * 初中
         */
        chuzhong("1"),

        /**
         * 高中
         */
        gaozhong("2"),

        /**
         * 其他
         */
        qita("3");

        private String value;

        departmentCode(String value){
            this.value=value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
