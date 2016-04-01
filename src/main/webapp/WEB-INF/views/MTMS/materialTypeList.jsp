<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:url value="/" var="home" />
<div class="container">
    <div class="row">
        <div class="col-sm-7">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Material Type</h3>
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <c:forEach var="materialType" items="${materialTypes}">
                            <a href="${home}materialType/${materialType.id}?list" class="list-group-item list-group-item-success">
                                <span class="badge">${fn:length(materialType.matters)}</span>
                                ${materialType.typeName}
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Option Menu</h3>
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <c:if test="${not empty name and roleName eq 'qa'}" >
                            <a href="${home}materialTypePrivate?form" class="list-group-item list-group-item-info">
                                Create Material Type
                            </a>
                        </c:if>
                        <c:if test="${not empty name and roleName eq 'qa'}" >
                            <a href="${home}materialPrivate?approve" class="list-group-item list-group-item-info">
                                <span class="badge">${fn:length(materials)}</span>
                                Approve
                            </a>
                        </c:if>
                        <c:if test="${not empty name}" >
                            <a href="${home}materialPrivate?listOfRequest" class="list-group-item list-group-item-info">
                                List All Material Of Request
                            </a>
                        </c:if>
                        <a href="${home}mtms/search" class="list-group-item list-group-item-info">
                            Search
                        </a>
                        <a href="${home}material/request?list" class="list-group-item list-group-item-info">
                            <span class="badge">${fn:length(materialsDoc)}</span>
                            Request Document
                        </a>
                        <a href="${home}mtms/expired?list" class="list-group-item list-group-item-info">
                            <span class="badge">${fn:length(materialExpired)}</span>
                            Material Expired
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
