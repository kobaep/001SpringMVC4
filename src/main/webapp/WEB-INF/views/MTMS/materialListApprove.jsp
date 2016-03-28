<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:url value="/" var="home" />
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="panel panel-info">
                <div class="panel-heading">Material Waiting Approve By QA</div>
                <div class="panel-body">
                    <div style="height: 500px;" class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr class="success">
                                    <th>#</th>
                                    <th>Material Type</th>
                                    <th>Material Name</th>
                                    <th>Spec</th>
                                    <th>MSDS</th>
                                    <th>RoHS</th>
                                    <th>Halogen Free</th>
                                    <th>Create By</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="material" items="${materials}" varStatus="loop">
                                    <c:set var="materialType" value="${material.materialType}"/>
                                    <c:set var="appuser" value="${material.createBy}"/>
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${materialType.typeName}</td>
                                        <td>${material.materialName}</td>
                                        <c:choose>
                                            <c:when test="${not empty material.spec}">
                                                <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${not empty material.msds}">
                                                <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${not empty material.rohs}">
                                                <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${not empty material.halogen}">
                                                <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td>${appuser.name}</td>
                                        <td>
                                            <a class="btn btn-primary btn-sm" href="${home}materialPrivate/${material.id}?approve" role="button">
                                                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>