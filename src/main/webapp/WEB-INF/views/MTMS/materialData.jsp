<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/" var="home" />
<c:set var="materialType" value="${material.materialType}"/>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal">
                <div class="col-sm-5">
                    <div class="form-group">
                        <label class="col-sm-6 control-label">Material Type :</label>
                        <div class="col-sm-6">
                            <p class="form-control-static">${materialType.typeName}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-6 control-label">Material Name :</label>
                        <div class="col-sm-6">
                            <p class="form-control-static">${material.materialName}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-6 control-label">UL Number :</label>
                        <div class="col-sm-6">
                            <p class="form-control-static">${material.ulNumber}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-6 control-label">Manufacturing :</label>
                        <div class="col-sm-6">
                            <p class="form-control-static">${material.manufacturing}</p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-7">
                    <c:if test="${not empty material.spec}">
                        <div class="form-group form-inline">
                            <label class="col-sm-5 control-label">Spec</label>
                            <div class="col-sm-7">
                                <p class="form-control-static">
                                    <a class="btn btn-info" href="${home}resources/filePDF${material.spec}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </p>
                                <p class="form-control-static">Expired Date <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.specEndDateTest}" /></p>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty material.msds}">
                        <div class="form-group form-inline">
                            <label class="col-sm-5 control-label">MSDS</label>
                            <div class="col-sm-7">
                                <p class="form-control-static">
                                    <a class="btn btn-info" href="${home}resources/filePDF${material.msds}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </p>
                                <p class="form-control-static">Expired Date <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.msdsEndDateTest}" /></p>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty material.rohs}">
                        <div class="form-group form-inline">
                            <label class="col-sm-5 control-label">RoHs</label>
                            <div class="col-sm-7">
                                <p class="form-control-static">
                                    <a class="btn btn-info" href="${home}resources/filePDF${material.rohs}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </p>
                                <p class="form-control-static">Expired Date <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.rohsEndDateTest}" /></p>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty material.halogen}">
                        <div class="form-group form-inline">
                            <label class="col-sm-5 control-label">Halogen Free</label>
                            <div class="col-sm-7">
                                <p class="form-control-static">
                                    <a class="btn btn-info" href="${home}resources/filePDF${material.halogen}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </p>
                                <p class="form-control-static">Expired Date <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.halogenEndDateTest}" /></p>
                            </div>
                        </div>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h3 class="panel-title">Code SAP</h3>
                </div>
                <div class="panel-body">
                    <ul class="list-group">
                        <c:forEach var="materialCode" items="${material.materialCodes}">
                            <c:choose>
                                <c:when test="${not empty name}">
                                    <li class="list-group-item">${materialCode.codeName}</li>
                                </c:when>
                                <c:otherwise>
                                    <li class="list-group-item">${materialCode.codeName}</li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
