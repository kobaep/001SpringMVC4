<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/" var="home" />
<div class="container">
    <form class="form-horizontal" id="materialTypeFormId" action="" method="POST">
        <div class="form-group">
            <label for="inputLotNumber" class="col-sm-2 control-label">Lot Number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputLotNumber" placeholder="Lot Number" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputOrderNumber" class="col-sm-2 control-label">Order Number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputOrderNumber" placeholder="Order Number" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputQty" class="col-sm-2 control-label">Qty</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputQty" placeholder="Qty" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPartNumber" class="col-sm-2 control-label">Part Number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputPartNumber" placeholder="Part Number" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputRevision" class="col-sm-2 control-label">Revision</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputRevision" placeholder="Revision" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputRemark" class="col-sm-2 control-label">Remark</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputRemark" placeholder="Remark" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputIssueName" class="col-sm-2 control-label">Issue Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-lg" id="inputIssueName" placeholder="Issue Name" autocomplete="off" required>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
    </form>
</div>
<spring:url value="/resources/core/jsCustom/testJasper.js" var="create" />
<script src="${create}"></script>