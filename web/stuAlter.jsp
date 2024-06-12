<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改学员信息</title>
</head>
<body>
<c:forEach var="stu" items="${stuList}" varStatus="s">
    <div>
        <h1>学员信息</h1>
        <form action="/student">
            <p><input hidden="hidden" type="text" value="${stu.sId}"></p>
            <p>学员姓名<input type="text" value="${stu.sName}"></p>
            <p>学员性别<input type="text" value="${stu.sGender}"></p>
            <p>学员年龄<input type="text" value="${stu.sAge}"></p>
            <p>家庭住址<input type="text" value="${stu.sAddress}"></p>
            <p>Email<input type="text" value="${stu.sEmail}"></p>
            <p><input type="submit" value="修改"></p>
        </form>
    </div>
</c:forEach>
</body>
</html>
