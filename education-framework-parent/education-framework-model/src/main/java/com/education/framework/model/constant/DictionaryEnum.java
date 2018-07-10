package com.education.framework.model.constant;

/**
 * @author zhoulin
 * @createTime 2018/7/10.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/10.
 * @note
 */
public class DictionaryEnum {

    public static enum status{

        /**
         * 禁用
         */
        DISABLE(0),

        /**
         * 启用
         */
        ENABLE(1);

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
