<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/" var="home" />
<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Material Public Access</h3>
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <c:forEach var="materialType" items="${materialTypes}">
                            <a href="${home}matterlo/mattype/${materialType.id}" class="list-group-item list-group-item-success">${materialType.typeName}</a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Material Private Access</h3>
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <c:forEach var="materialType" items="${materialTypes}">
                            <a href="${home}matter/mattype/${materialType.id}" class="list-group-item list-group-item-info">${materialType.typeName}</a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
