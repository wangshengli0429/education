package com.education.framework.model.constant;

/**
 * @author zhoulin
 * @createTime 2018/7/19.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/19.
 * @note
 */
public class CommentEnum {

    public static enum status{

        /**
         * 游泳
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
