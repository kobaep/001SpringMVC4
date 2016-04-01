<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/" var="home" />
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="panel panel-warning">
                <div class="panel-heading">Request Document</div>
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
                                <th>Reason</th>
                                <th>Request By</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="materialCreate" items="${materialsDoc}" varStatus="loop">
                                <c:set var="materialCreateType" value="${materialCreate.materialType}"/>
                                <c:set var="appuserCreate" value="${materialCreate.updateBy}"/>
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
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> <font color="red"><fmt:formatDate pattern="dd/MM/yyyy"  value="${materialCreate.rohsEndDateTest}" /></font></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${not empty materialCreate.halogen}">
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> <font color="red"><fmt:formatDate pattern="dd/MM/yyyy"  value="${materialCreate.halogenEndDateTest}" /></font></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td>${materialCreate.reason}</td>
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
            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Document OK,
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> <font color="red">Need Document</font>
        </div>
    </div>
</div>