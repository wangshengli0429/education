package com.education.framework.common.sql;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
/*
 * 因为使用的是"mybatis-spring-1.3.jar"这个版本是高版本就会有问题，
 * 原因是Mybatis3依赖的jar包"mybatis-spring-1.2.0.jar"这个版本以及以上的版本中，对SqlSessionDaoSupport类中的'sqlSessionFactory'或'sqlSessionTemplate'注入方式进行了调整。
 * 解决如下，创建一个Dao的基类EduSqlSessionDaoSupport，让这个基类继承SqlSessionDaoSupport，并通过set方法注入SqlSessionFactory属性即可：
 */
public class EduSqlSessionDaoSupport extends SqlSessionDaoSupport{
	
//	@Resource
//    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
//        super.setSqlSessionFactory(sqlSessionFactory);
//    }
}
