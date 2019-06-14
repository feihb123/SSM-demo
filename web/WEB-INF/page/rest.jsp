<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Rest</title>
    <script type="text/javascript" src="/web/js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript">
        /*将post method 改变为delete*/
        $(function(){
            $(".delete").click(function(){
                var href=$(this).attr("href");
                $("#formDelete").attr("action",href).submit();
                return false;
            })
        })
    </script>

</head>
<body>
<br><br>
<div style="width:500px;margin:0px auto;text-align:center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.uid}</td>
                <td>${c.uname}</td>
                <td><a href="user/${c.uid}">编辑</a></td>
                <td><a class="delete" href="/web/user/${c.uid}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.pageNum-1}">上一页</a>
        <a href="?start=${page.pageNum+1}">下一页</a>
        <a href="?start=${page.pages}">末  页</a>
    </div>
    <div style="text-align:center;margin-top:40px">
        <form method="POST" action="user">
            添加新用户： <input name="uname" value="" type="text"> <br><br>
            <input type="submit" value="添加用户">
        </form>
    </div>


</div>



<form id="formDelete" action="" method="POST" >
    <input type="hidden" name="_method" value="DELETE">
</form>

</body>
</html>
