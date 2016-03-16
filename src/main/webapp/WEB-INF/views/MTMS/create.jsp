<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/" var="home" />
<div class="container">
    <form class="form-horizontal" id="materialTypeFormId" action="" method="POST">
        <div class="form-group">
            <label for="inputMaterialType" class="col-sm-2 control-label">Material Type</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputMaterialType" placeholder="Material Type" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
    </form>
</div>
<spring:url value="/resources/core/jsCustom/MTMS/create.js" var="create" />
<script src="${create}"></script>