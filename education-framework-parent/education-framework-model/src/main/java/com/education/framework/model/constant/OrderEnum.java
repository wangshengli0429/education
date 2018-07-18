package com.education.framework.model.constant;

/**
 * @author zhoulin
 * @createTime 2018/7/18.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/18.
 * @note
 */
public class OrderEnum {

    public static enum orderStatus{

        /**
         * 未支付
         */
        pay_wait(0),

        /**
         * 已支付
         */
        pay_do(1),

        /**
         * 已完成
         */
        pay_complete(1),

        /**
         * 已评价
         */
        pay_evaluate(1);

        private Integer value;

        orderStatus(Integer value){
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
