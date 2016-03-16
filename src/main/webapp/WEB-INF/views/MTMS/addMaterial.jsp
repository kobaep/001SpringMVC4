<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/" var="home" />
<div class="container">
    <form class="form-horizontal" id="materialFormId" action="" method="POST">
        <div class="form-group">
            <label class="col-sm-2 control-label">Material Type</label>
            <div class="col-sm-10">
                <p class="form-control-static">${materialType.typeName}</p>
            </div>
        </div>
        <div class="form-group">
            <label for="inputMaterialName" class="col-sm-2 control-label">Material Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputMaterialName" placeholder="Material Name" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputUlNumber" class="col-sm-2 control-label">UL Number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputUlNumber" placeholder="UL Number" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputStartDate" class="col-sm-2 control-label">Start Date</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputStartDate" placeholder="Start Date" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputSpec" class="col-sm-2 control-label">Spec</label>
            <div class="col-sm-10">
                <span class="btn btn-file"><input type="file" id="inputSpec" required></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputRoHs" class="col-sm-2 control-label">RoHs</label>
            <div class="col-sm-10">
                <span class="btn btn-file"><input type="file" id="inputRoHs" required></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputMSDS" class="col-sm-2 control-label">MSDS</label>
            <div class="col-sm-10">
                <span class="btn btn-file"><input type="file" id="inputMSDS" required></span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputHalogen" class="col-sm-2 control-label">Halogen Free</label>
            <div class="col-sm-10">
                <span class="btn btn-file"><input type="file" id="inputHalogen" required></span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" id="kkk" class="btn btn-default">Submit</button>
            </div>
        </div>
        <input type="text" class="form-control hidden" id="inputId" value="${materialType.id}">
    </form>
</div>
<spring:url value="/resources/core/jsCustom/MTMS/createMatter.js" var="createMatter" />
<script src="${createMatter}"></script>
