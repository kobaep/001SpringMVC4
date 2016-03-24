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
                <div class="panel-heading">Material Waiting Follow</div>
                <div class="panel-body">
                    <div style="height: 350px;">
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
                            <c:forEach var="materialCreate" items="${materialsCreate}" varStatus="loop">
                                <c:set var="materialCreateType" value="${materialCreate.materialType}"/>
                                <c:set var="appuserCreate" value="${materialCreate.createBy}"/>
                                <tr>
                                    <td>${loop.index + 1}</td>
                                    <td>${materialCreateType.typeName}</td>
                                    <td>${materialCreate.materialName}</td>
                                    <c:choose>
                                        <c:when test="${not empty materialCreate.spec}">
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${not empty materialCreate.msds}">
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${not empty materialCreate.rohs}">
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${not empty materialCreate.halogen}">
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td>${appuserCreate.name}</td>
                                    <td>
                                        <a class="btn btn-primary btn-sm" href="${home}materialPrivate/${materialCreate.id}?update" role="button">
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
    <div class="row">
        <div class="col-sm-12">
            <div class="panel panel-primary">
                <div class="panel-heading">Reject By QA</div>
                <div class="panel-body">
                    <div style="height: 350px;">
                        <table class="table table-hover">
                            <thead>
                            <tr class="danger">
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
                            <c:forEach var="materialReject" items="${materialsReject}" varStatus="loop">
                                <c:set var="materialRejectType" value="${materialReject.materialType}"/>
                                <c:set var="appuserCreate" value="${materialReject.createBy}"/>
                                <tr>
                                    <td>${loop.index + 1}</td>
                                    <td>${materialRejectType.typeName}</td>
                                    <td>${materialReject.materialName}</td>
                                    <c:choose>
                                        <c:when test="${not empty materialReject.spec}">
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${not empty materialReject.msds}">
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${not empty materialReject.rohs}">
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${not empty materialReject.halogen}">
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td>${appuserCreate.name}</td>
                                    <td>
                                        <a class="btn btn-primary btn-sm" href="${home}materialPrivate/${materialReject.id}?update" role="button">
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