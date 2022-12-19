<%--
  Created by IntelliJ IDEA.
  User: Iulia
  Date: 12/4/2022
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
  <h1>Users</h1>

  <form method="POST" action="${pageContext.request.contextPath}/Users">
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddUser">Add User</a>
    <button class="btn btn-danger" type="submit">Delete Users</button>

  <div class="container text-center">
    <c:forEach var="user" items="${user}">
      <div class="row">
        <div class="col">
          <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
            <input type="checkbox" name="user_ids" value="${user.id}" />
          </c:if>
        </div>
        <div class="col">
            ${user.email}
        </div>
        <div class="col">
            ${user.username}
        </div>
      </div>
    </c:forEach>
  </div>
</t:pageTemplate>