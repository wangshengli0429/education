package com.education.framework.common.response.constants;

/**
 * @author ChengZhu Liang
 * @CreateTime 16/10/19
 * @note 接口返回码定义, 请注释每个返回码定义.
 */
public class ApiRetCode {

    /**
     * 通用请求成功状态码
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 通用请求失败状态码
     */
    public static final int REQUEST_FAIL = 202;

    /**
     * 获取数据异常
     */
    public static final int FETCH_DATA_FAIL = 501;

    /**
     * 参数错误
     */
    public static final int PARAMETER_ERROR = 502;

    /**
     * 数据未修改
     */
    public static final int NOT_MODIFIED = 304;

    /**
     * 查询结果为空
     */
    public static final int EMPTY_RESULT = 500;

    public static final int REPEAT_RESULT = 505;

    /**
     * @author ChengZhu Liang
     * @note 题库相关返回码定义
     */
    public static final class Tiku {

        /**
         * 获取数据异常
         */
        public static final int FETCH_DATA_FAIL = 501;

        /**
         * 参数错误
         */
        public static final int PARAMETER_ERROR = 502;

        /**
         * 数据未修改
         */
        public static final int NOT_MODIFIED = 304;


        /**
         * 题库文件夹类型枚举
         */

        public enum DIRECTORY_TYPE {
            /**
             * 文件夹
             */
            DIRECTORY("dir"),

            /**
             * 机构（私有空间）
             */
            KNOWLEDGE("knowledge");

            private String name;

            private DIRECTORY_TYPE(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return this.name;
            }

        }

    }

}
