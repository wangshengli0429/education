package com.education.framework.model.base.resource;

import java.io.Serializable;

public class Resource implements Serializable {

    /***/
    private static final long serialVersionUID = 1L;
    /** id */
    private Integer id;
    /** 资源URL */
    private String resourceUrl;
    /** 资源名 */
    private String resourceName;
    /** 项目名 */
    private String projName;

    public Resource() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    @Override
    public String toString() {
        return "Resource [id=" + id + ", resourceUrl=" + resourceUrl + ", resourceName=" + resourceName + ", projName="
                + projName + "]";
    }

}
