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
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">Material Type :</label>
                <div class="col-sm-10">
                    <p class="form-control-static">${materialType.typeName}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Material Name :</label>
                <div class="col-sm-10">
                    <p class="form-control-static">${material.materialName}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">UL Number :</label>
                <div class="col-sm-10">
                    <p class="form-control-static">${material.ulNumber}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Manufacturing :</label>
                <div class="col-sm-10">
                    <p class="form-control-static">${material.manufacturing}</p>
                </div>
            </div>
            <c:if test="${not empty material.spec}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Spec :</label>
                    <div class="col-sm-10 form-inline">
                        <a href="${home}resources/filePDF${material.spec}" target="_blank" role="button"><p class="form-control-static">Spec PDF File</p></a> &nbsp; &nbsp; &nbsp;
                        <p class="form-control-static">Test Date <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.specDateTest}" /></p>
                    </div>
                </div>
            </c:if>
            <c:if test="${not empty material.rohs}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">RoHS :</label>
                    <div class="col-sm-10 form-inline">
                        <a href="${home}resources/filePDF${material.rohs}" target="_blank" role="button"><p class="form-control-static">RoHS PDF File</p></a> &nbsp; &nbsp; &nbsp;
                        <p class="form-control-static">Test Date <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.rohsDateTest}" /></p>
                    </div>
                </div>
            </c:if>
            <c:if test="${not empty material.msds}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">MSDS :</label>
                    <div class="col-sm-10 form-inline">
                        <a href="${home}resources/filePDF${material.msds}" target="_blank" role="button"><p class="form-control-static">MSDS PDF File</p></a> &nbsp; &nbsp; &nbsp;
                        <p class="form-control-static">Test Date <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.msdsDateTest}" /></p>
                    </div>
                </div>
            </c:if>
            <c:if test="${not empty material.halogen}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Halogen Free :</label>
                    <div class="col-sm-10 form-inline">
                        <a href="${home}resources/filePDF${material.halogen}" target="_blank" role="button"><p class="form-control-static">Halogen Free PDF File</p></a> &nbsp; &nbsp; &nbsp;
                        <p class="form-control-static">Test Date <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.halogenDateTest}" /></p>
                    </div>
                </div>
            </c:if>
            <input type="text" class="hidden" id="inputId" value="${material.id}">
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" id="btnReject" class="btn btn-danger btn-lg">Reject</button>
                    <button type="button" id="btnApprove" class="col-sm-offset-1 btn btn-success btn-lg">Approve</button>
                </div>
            </div>
        </form>
    </div>
</div>
<spring:url value="/resources/core/jsCustom/MTMS/materialApprove.js" var="create" />
<script src="${create}"></script>