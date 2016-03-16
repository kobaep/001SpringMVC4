<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/" var="home" />
<div class="container">
    <form class="form-horizontal" id="materialSapFormId" action="" method="POST">
        <div class="form-group">
            <label class="col-sm-2 control-label">Material Type</label>
            <div class="col-sm-10">
                <p class="form-control-static">${materialType.typeName}</p>
            </div>
        </div>
        <div class="form-group">
            <label for="inputMaterialName" class="col-sm-2 control-label">Material Name</label>
            <div class="col-sm-10">
                <select class="form-control input-lg" id="inputMaterialName">
                    <c:forEach var="material" items="${materialType.matters}">
                        <option value="${material.id}">${material.materialName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="inputSapCode" class="col-sm-2 control-label">SAP Code</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputSapCode" placeholder="SAP Code" autocomplete="off" required>
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
<spring:url value="/resources/core/jsCustom/MTMS/addMaterialSap.js" var="create" />
<script src="${create}"></script>
