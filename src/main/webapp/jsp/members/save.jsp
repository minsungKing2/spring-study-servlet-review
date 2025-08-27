<%--
  Created by IntelliJ IDEA.
  User: minpr
  Date: 2025-08-27
  Time: 오전 11:00
  To change this template use File | Settings | File Templates.
--%>
<%-- 회원 저장 JSP --%>
<%-- <% %> 이 부분에는 자바 코드를 입력할 수 있다. --%>
<%-- <%= %> 이 부분에는 자바 코드를 출력할 수 있다. --%>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);
%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%>
    </li>
    <li>username=<%=member.getUsername()%>
    </li>
    <li>age=<%=member.getAge()%>
    </li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
