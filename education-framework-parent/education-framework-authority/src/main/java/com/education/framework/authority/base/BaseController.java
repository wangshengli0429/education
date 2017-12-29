package com.education.framework.authority.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
public abstract class BaseController {

    /** 变量容器 */
    protected Map<String, Object> valueMap = new HashMap<String, Object>();

    protected void jsonResponse(String jsonStr, HttpServletResponse response) {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonStr);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
