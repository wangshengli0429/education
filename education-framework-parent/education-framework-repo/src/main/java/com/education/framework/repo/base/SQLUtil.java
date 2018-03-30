package com.education.framework.repo.base;


/**
 * Created by Administrator on 2016/10/24.
 *
 * @author cyy
 */
public final class SQLUtil {

    /**
     * 私有构造
     */
    private SQLUtil() {
    }

    /**
     * 根据集合大小转出如例(?,?)
     *
     * @param size 集合大小
     * @return String
     */
    public static String sizeToUnknown(final int size) {
        if (size == 0) {
          //  throw new GaosiException("sql拼装条件in函数失败！");
            return null;
        }
        //静态方法局部变量无并发压力，使用StringBuilder具有更好的性能
        final StringBuilder stringBuilder = new StringBuilder("(");
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                stringBuilder.append("?");
            } else {
                stringBuilder.append(",?");
            }

        }
        stringBuilder.append(")");
        return stringBuilder.toString();

    }
}

