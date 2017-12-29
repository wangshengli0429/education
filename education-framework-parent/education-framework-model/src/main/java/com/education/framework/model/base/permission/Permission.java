package com.education.framework.model.base.permission;

import java.io.Serializable;

/**
 * 权限
 */

public class Permission implements Serializable {

    /** */
    private static final long serialVersionUID = 1L;
    /** ID */
    private Integer id;
    /** 权限名 */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Permission [id=" + id + ", name=" + name + "]";
    }

}
