package com.education.framework.common.util;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * @author zhoulin
 * @createTime 2017/6/15.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2017/6/15.
 * @note
 */
@Component
public class BaseMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
//        factory.classMap(Double.class,Double.class)//TODO
//                .mapNulls(true).mapNullsInReverse(true)
//                .byDefault()
//                .register();
    }
}
