<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/" var="home" />
<div class="container">
    <div class="row">
        <div class="col-lg-offset-3 col-sm-6">
            <div class="panel panel-primary">
                <div class="panel-heading">Search By Code SAP Or Material</div>
                <div class="panel-body">
                    <div class="col-sm-12">
                        <div class="row">
                            <form class="form-horizontal" id="formSubmit" role="search">
                                <div class="col-sm-12">
                                    <div class="input-group">
                                        <input type="text" id="inputSearch" class="form-control input-lg" placeholder="Search for..." required>
                                    <span class="input-group-btn">
                                        <button class="btn btn-default btn-lg" type="submit" id="btnSearch">Go!</button>
                                    </span>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div style="height: 300px;" class="table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                            <tr class="info">
                                                <th>Material Type</th>
                                                <th>Material Name</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody id="dataTable">
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<spring:url value="/resources/core/jsCustom/MTMS/search.js" var="createMatter" />
<script src="${createMatter}"></script>