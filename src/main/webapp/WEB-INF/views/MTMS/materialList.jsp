<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:url value="/" var="home" />
<div class="container">
    <div class="row">
        <div class="col-sm-5">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Option ${materialType.typeName}</h3>
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <a href="${home}materialPrivate/${materialType.id}?form" class="list-group-item list-group-item-info">
                            Create Material
                        </a>
                        <a href="${home}materialSapPrivate/${materialType.id}?form" class="list-group-item list-group-item-info">
                            Create SAP Code
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h3 class="panel-title">${materialType.typeName} Name</h3>
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <c:forEach var="material" items="${materials}">
                            <c:choose>
                                <c:when test="${material.status eq 'CREATE'}">
                                    <a href="${home}material/${material.id}?list" class="list-group-item list-group-item-warning not-active">
                                        <span class="badge">${fn:length(material.materialCodes)}</span>
                                            ${material.materialName}
                                    </a>
                                </c:when>
                                <c:when test="${material.status eq 'REJECT'}">
                                    <a href="${home}material/${material.id}?list" class="list-group-item list-group-item-danger not-active">
                                        <span class="badge">${fn:length(material.materialCodes)}</span>
                                            ${material.materialName}
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${home}material/${material.id}?list" class="list-group-item list-group-item-success">
                                        <span class="badge">${fn:length(material.materialCodes)}</span>
                                            ${material.materialName}
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
