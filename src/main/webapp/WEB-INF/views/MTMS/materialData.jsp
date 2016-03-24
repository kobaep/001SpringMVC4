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
                    <h3 class="panel-title">${material.materialName}</h3>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal">
                        <c:if test="${not empty material.spec}">
                            <div class="form-group">
                                <label class="col-sm-6 control-label">Spec</label>
                                <div class="col-sm-6">
                                    <p class="form-control-static">
                                        <a class="btn btn-info" href="${home}resources/filePDF${material.spec}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                    </p>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${not empty material.msds}">
                            <div class="form-group">
                                <label class="col-sm-6 control-label">MSDS</label>
                                <div class="col-sm-6">
                                    <p class="form-control-static">
                                        <a class="btn btn-info" href="${home}resources/filePDF${material.msds}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                    </p>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${not empty material.rohs}">
                            <div class="form-group">
                                <label class="col-sm-6 control-label">RoHs</label>
                                <div class="col-sm-6">
                                    <p class="form-control-static">
                                        <a class="btn btn-info" href="${home}resources/filePDF${material.rohs}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                    </p>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${not empty material.halogen}">
                            <div class="form-group">
                                <label class="col-sm-6 control-label">Halogen Free</label>
                                <div class="col-sm-6">
                                    <p class="form-control-static">
                                        <a class="btn btn-info" href="${home}resources/filePDF${material.halogen}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                    </p>
                                </div>
                            </div>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h3 class="panel-title">Code SAP</h3>
                </div>
                <div class="panel-body">
                    <ul class="list-group">
                        <c:forEach var="materialCode" items="${material.materialCodes}">
                            <li class="list-group-item">${materialCode.codeName}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
