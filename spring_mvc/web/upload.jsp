<%--
  Created by IntelliJ IDEA.
  User: 高杰
  Date: 2022/4/9
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br>
    文件<input type="file" name="uploadFile"><br>
    文件<input type="file" name="uploadFile"><br>
    文件<input type="file" name="uploadFile"><br>
    <input type="submit" value="提交">
</form>

<form action="${pageContext.request.contextPath}/user/quick21" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br>
    文件<input type="file" name="uploadFile"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
