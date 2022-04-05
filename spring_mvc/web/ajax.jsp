<%--
  Created by IntelliJ IDEA.
  User: 高杰
  Date: 2022/4/4
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var kingList = new Array();
        kingList.push({name: "gaojie", age: 22})
        kingList.push({name: "zhangsan", age: 20})

        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/user/quick14",
            data: JSON.stringify(kingList),
            contentType: "application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
