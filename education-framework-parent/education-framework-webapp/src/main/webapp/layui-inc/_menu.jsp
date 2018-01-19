  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="${path}/to/query/teacher">教师管理</a>
         <!--  <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="javascript:;">列表三</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl> -->
        </li>
        <li class="layui-nav-item">
          <a href="${path}/to/query/student">学生管理</a>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">订单管理</a>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">课程管理</a>
        </li>
        <li class="layui-nav-item"><a href="${path}/comment/toGetAllComment">评论管理</a></li>
        <li class="layui-nav-item"><a href="">留言管理</a></li>
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">系统设置</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">管理员</a></dd>
            <dd><a href="javascript:;">数据字典</a></dd>
            <dd><a href="javascript:;">角色管理</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>