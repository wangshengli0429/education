package com.education.framework.common.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;

/**
 * Created by wangshengli - 20180123.
 * 系统使用的jacksonBean
 */
public class JacksonBean implements FactoryBean<Object>, InitializingBean, DisposableBean {

    private ObjectMapper mapper = new ObjectMapper();


    public JacksonBean() {
        super();
        // 空值处理为空串
        mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
                jg.writeString("");
            }
        });
    }
    
    @Override
    public Object getObject() throws Exception {
        return mapper;
    }

    @Override
    public Class<?> getObjectType() {
        return mapper.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);     // 序列化取出null值
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);  // 范序列化过滤多余字段
    }

    @Override
    public void destroy() throws Exception {
        //
    }
}
