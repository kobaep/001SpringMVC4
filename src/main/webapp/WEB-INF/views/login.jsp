<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/" var="home" />
<%@page session="true"%>
<div class="container">

    <form class="form-signin" action="${home}resources/j_spring_security_check" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
        <label for="j_username" class="sr-only">Username</label>
        <input type="text" id="j_username" name="username" class="form-control" placeholder="Username" required autofocus>
        <label for="j_password" class="sr-only">Password</label>
        <input type="password" id="j_password" name="password" class="form-control" placeholder="Password" required>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div>
