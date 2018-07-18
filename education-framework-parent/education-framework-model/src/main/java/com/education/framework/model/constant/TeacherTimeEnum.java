package com.education.framework.model.constant;

/**
 * @author zhoulin
 * @createTime 2018/7/18.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/18.
 * @note
 */
public class TeacherTimeEnum {

    public static enum timeStatus{

        /**
         * 可预约
         */
        yes(0),

        /**
         * 已预约
         */
        no(1);

        private Integer value;

        timeStatus(Integer value){
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
