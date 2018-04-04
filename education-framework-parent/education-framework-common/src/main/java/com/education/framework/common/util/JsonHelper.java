package com.education.framework.common.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;


public class JsonHelper {
    private static final Logger logger = LoggerFactory.getLogger(JsonHelper.class.getSimpleName());
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String GetJsonResult(Object src) {
        StringWriter sw = new StringWriter();
        try {
            objectMapper.writeValue(sw, src);
            return sw.getBuffer().toString();
        } catch (Exception e) {
            logger.error("GetJsonResult err:",e);
        } finally {
            sw.flush();
            try {
                sw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static Object GetObjByJson(String json, Class type) throws Exception {
        try {
            Object result = objectMapper.readValue(json, type);
            return result;
        } catch (Exception e) {
            throw new Exception("JsonHelper.GetObjByJson Error:" + e.getMessage() + e.getStackTrace());
        }
    }

    public static void SaveJsonFile(Object src, String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath, false);
            objectMapper.writeValue(fw, src);
            //fw is closed by objectMapper
        } catch (Exception e) {
            throw new RuntimeException("JsonHelper.SaveJsonFile Error:" + e.getMessage() + e.getStackTrace(), e);
        }
    }

    public static Object ReadJsonFile(String filePath, Class type) {
        try {
            Object result = objectMapper.readValue(new File(filePath), type);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("JsonHelper.ReadJsonFile Error:" + e.getMessage() + e.getStackTrace(), e);
        }
    }
}
