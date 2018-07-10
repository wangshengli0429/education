package com.education.framework.model.constant;

/**
 * @author zhoulin
 * @createTime 2018/7/10.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/10.
 * @note
 */
public class IdcardEnum {

    public static enum status{

        /**
         * 待审核
         */
        check_wait(0),

        /**
         * 审核通过
         */
        check_pass(1),

        /**
         * 审核不通过
         */
        check_no_pass(2);

        private Integer value;

        status(Integer value){
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


