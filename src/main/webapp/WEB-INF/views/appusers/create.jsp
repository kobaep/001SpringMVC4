<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/" var="home" />
<%@page session="true"%>
<div class="container">
    <form class="form-horizontal" id="appUserId" action="" method="GET">
        <div class="form-group">
            <label for="inputUser" class="col-sm-2 control-label">Username</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputUser" placeholder="Username" required="required" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword" placeholder="Password" required="required" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputName" placeholder="Name" required="required" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputDepartment" class="col-sm-2 control-label">Department</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputDepartment" placeholder="Department" required="required" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputDepartmentCode" class="col-sm-2 control-label">Department Code</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputDepartmentCode" placeholder="Department Code" required="required" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="inputEmail" placeholder="Email" required="required" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputTelephoneNumber" class="col-sm-2 control-label">Telephone Number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputTelephoneNumber" placeholder="Telephone Number" required="required" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputRoleName" class="col-sm-2 control-label">Role Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputRoleName" placeholder="Role Name" required="required" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
    </form>
</div>
<spring:url value="/resources/core/jsCustom/appuser/create.js" var="create" />
<script src="${create}"></script>