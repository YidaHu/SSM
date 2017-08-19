<%--
  Created by IntelliJ IDEA.
  User: huyd
  Date: 2017/8/16
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<h2>学生信息</h2>
<form:form method="POST" action="/SpringMVCHello/student/addStudent">
    <table>
        <tr>
            <td><form:label path="name">姓名</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="age">年龄：</form:label></td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td><form:label path="id">编号：</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交学生信息"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
