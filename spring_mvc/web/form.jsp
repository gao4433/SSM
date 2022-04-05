<%--
  Created by IntelliJ IDEA.
  User: 高杰
  Date: 2022/4/4
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick13" method="post">
        <%--表明是第几个King对象的第几个name和age--%>
       king1的name：<input type="text" name="kingList[0].name"><br>
       king1的age：<input type="text" name="kingList[0].age"><br>
       king2的name：<input type="text" name="kingList[1].name"><br>
       king2的age：<input type="text" name="kingList[1].age"><br>
       king3的name：<input type="text" name="kingList[2].name"><br>
       king3的age：<input type="text" name="kingList[2].age"><br>

        <input type="submit" value="提交">
    </form>
</body>
</html>
