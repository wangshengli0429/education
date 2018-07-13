package com.education.framework.model.constant;

/**
 * @author zhoulin
 * @createTime 2018/7/11.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/11.
 * @note
 */
public class TeacherEnum {

    /**
     * 男
     */
    public static final Integer SEX_BOY = 1;

    /**
     * 女
     */
    public static final Integer SEX_GIRL = 2;

    public static enum authentication{

        /**
         * 没有认证
         */
        wait(0),

        /**
         * 已认证
         */
        pass(1),

        /**
         * 认证不通过
         */
        no_pass(2);

        private Integer value;

        authentication(Integer value){
            this.value=value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

}
