<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:url value="/" var="home" />
<div class="container">
    <form class="form-horizontal" id="materialFormId" action="" method="POST">
        <div class="form-group">
            <label class="col-sm-2 control-label">Material Type</label>
            <div class="col-sm-10">
                <c:set var="materialType" value="${material.materialType}"/>
                <p class="form-control-static">${materialType.typeName}</p>
            </div>
        </div>
        <div class="form-group">
            <label for="inputMaterialName" class="col-sm-2 control-label">Material Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputMaterialName" placeholder="Material Name" value="${material.materialName}" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputUlNumber" class="col-sm-2 control-label">UL Number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputUlNumber" placeholder="UL Number" value="${material.ulNumber}" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputManufacturing" class="col-sm-2 control-label">Manufacturing</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputManufacturing" placeholder="Manufacturing Locations" value="${material.manufacturing}" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputSpec" class="col-sm-2 control-label"><font color="red">Spec</font></label>
            <div class="col-sm-10 form-inline">
                <span class="btn btn-file"><input type="file" id="inputSpec"></span>
                <input type="text" class="form-control input-lg" id="inputDateSpec" placeholder="Start Test Date" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputRoHs" class="col-sm-2 control-label"><font color="red">RoHs</font></label>
            <div class="col-sm-10 form-inline">
                <span class="btn btn-file"><input type="file" id="inputRoHs"></span>
                <input type="text" class="form-control input-lg" id="inputDateRoHs" placeholder="Start Test Date" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputMSDS" class="col-sm-2 control-label"><font color="red">MSDS</font></label>
            <div class="col-sm-10 form-inline">
                <span class="btn btn-file"><input type="file" id="inputMSDS"></span>
                <input type="text" class="form-control input-lg" id="inputDateMSDS" placeholder="Start Test Date" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputHalogen" class="col-sm-2 control-label"><font color="red">Halogen Free</font></label>
            <div class="col-sm-10 form-inline">
                <span class="btn btn-file"><input type="file" id="inputHalogen"></span>
                <input type="text" class="form-control input-lg" id="inputDateHF" placeholder="Start Test Date" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" id="submit" class="btn btn-primary btn-lg">Update</button>
            </div>
        </div>
        <input type="text" class="form-control hidden" id="inputId" value="${materialType.id}">
    </form>
</div>
<%--<spring:url value="/resources/core/jsCustom/MTMS/createMatter.js" var="createMatter" />--%>
<%--<script src="${createMatter}"></script>--%>
