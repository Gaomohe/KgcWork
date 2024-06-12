<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Information</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #FFAEC9;
        }
        tr:nth-child(odd) {
            background-color: #ffffff;
        }
    </style>
</head>
<script type="application/javascript" src="js/jquery-3.7.1.js"></script>
<script type="application/javascript">
    $(function (){
        $(".del").click(function (event){
            // var id = event.target.name;
            var id = $(this).data("id");
            $.ajax({
                url:"/student",
                data:{
                    action:"stuDel",
                    id:id
                },
                type:"GET",
                dataType:"json",
                success:function (data){
                    location.href = "/student?action=queryStu"
                }
            })
        })
    })
</script>
<body>
<h2>学员信息</h2>
<table border="1">
    <thead>
    <tr>
        <th>学员编号</th>
        <th>学员姓名</th>
        <th>学员性别</th>
        <th>学员年龄</th>
        <th>家庭住址</th>
        <th>Email</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="stu" items="${studentList}" varStatus="s">
        <tr>
            <td>${stu.sId}</td>
            <td><a href="stuAlter.jsp">${stu.sName}</a></td>
            <td>${stu.sGender}</td>
            <td>${stu.sAge}</td>
            <td>${stu.sAddress}</td>
            <td>${stu.sEmail}</td>
            <td><a class="del" name="${stu.sId}" href="javascript:void(0)">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Information</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #FFAEC9;
        }
        tr:nth-child(odd) {
            background-color: #ffffff;
        }
    </style>
</head>
<script type="application/javascript" src="js/jquery-3.7.1.js"></script>
<script type="application/javascript">
    $(function (){
        $(".del").click(function (event){
            var id = $(this).data("id");
            $.ajax({
                url: "/student",
                data: {
                    action: "stuDel",
                    id: id
                },
                type: "GET",
                dataType: "json",
                success: function (data){
                    location.href = "/student?action=queryStu";
                }
            });
        });

        // $(".stu").click(function (event){
        //     var id = $(this).data("id");
        //     $.ajax({
        //         url: "/student",
        //         data: {
        //             action: "findStu",
        //             id: id
        //         },
        //         type: "GET",
        //         dataType: "json",
        //         success: function (data){
        //             location.href = "/stuAlter.jsp";
        //         }
        //     });
        // });
    });
</script>
<body>
<h2>学员信息</h2>
<table border="1">
    <thead>
    <tr>
        <th>学员编号</th>
        <th>学员姓名</th>
        <th>学员性别</th>
        <th>学员年龄</th>
        <th>家庭住址</th>
        <th>Email</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="stu" items="${studentList}" varStatus="s">
        <tr>
            <td>${stu.sId}</td>
            <td><a href="/student?action=findStu&&id=${stu.sId}">${stu.sName}</a></td>
            <td>${stu.sGender}</td>
            <td>${stu.sAge}</td>
            <td>${stu.sAddress}</td>
            <td>${stu.sEmail}</td>
            <td><a class="del" data-id="${stu.sId}" href="javascript:void(0)">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
