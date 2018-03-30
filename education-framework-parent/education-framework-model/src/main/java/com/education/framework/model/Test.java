package com.education.framework.model;

import java.io.Serializable;

/**
 * Created by zhoulin on 2018/3/30.
 */
public class Test implements Serializable {

    private Integer id;

    private Integer name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }
}
