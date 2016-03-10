<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/" var="home" />
<%@page session="true"%>
<div class="container">
    <div class="row">
        <div class="col-sm-12 alert alert-dismissible alert-success">
            <div align="center">
                <h4><label>All User</label></h4>
                <div class="table-responsive" style="height: 500px;">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>USER</th>
                            <th>PASSWORD</th>
                            <th>NAME</th>
                            <th>DEPARTMENT</th>
                            <th>EMAIL</th>
                            <th>TELEPHONE</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="tableUser">
                            <jsp:text/>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<spring:url value="/resources/core/jsCustom/appuser/list.js" var="list" />
<script src="${list}"></script>
