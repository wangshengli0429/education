package com.education.framework.model.constant;

public class AttentionEnum {

    public static enum status{

        /**
         * 有用
         */
        status_true(1),

        /**
         * 无用
         */
        status_false(0);

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
