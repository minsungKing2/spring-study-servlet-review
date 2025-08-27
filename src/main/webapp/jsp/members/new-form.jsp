<%--
  Created by IntelliJ IDEA.
  User: minpr
  Date: 2025-08-27
  Time: 오전 10:56
  To change this template use File | Settings | File Templates.
--%>
<%-- 회원 등록 폼 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- JSP 문서라는 뜻. JSP 문서는 이렇게 시작해야 한다. --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/jsp/members/save.jsp" method="post">
    username: <input type="text" name="username"/>
    age: <input type="text" name="age"/>
    <button type="submit">전송</button>
</form>
</body>
</html>
