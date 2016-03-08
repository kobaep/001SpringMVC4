<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Wait For Engineer Review</h3>
                </div>
                <div class="panel-body">
                    <div style="height: 200px;" class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>FA No.</th>
                                    <th>Request Date</th>
                                    <th>Need Date</th>
                                    <th>Customer</th>
                                    <th>Part No.</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody id="waitEngReview">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h3 class="panel-title">Engineer Reject</h3>
                </div>
                <div class="panel-body">
                    <div style="height: 200px;" class="table-responsive">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Wait For Engineer Working</h3>
                </div>
                <div class="panel-body">
                    <div style="height: 200px;" class="table-responsive">

                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <h3 class="panel-title">Wait For Waiting</h3>
                </div>
                <div class="panel-body">
                    <div style="height: 200px;" class="table-responsive">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Wait For QA FA Inspector</h3>
                </div>
                <div class="panel-body">
                    <div style="height: 200px;" class="table-responsive">

                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h3 class="panel-title">QA Reject</h3>
                </div>
                <div class="panel-body">
                    <div style="height: 200px;" class="table-responsive">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Wait For Sale Co Send Item</h3>
                </div>
                <div class="panel-body">
                    <div style="height: 200px;" class="table-responsive">

                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <h3 class="panel-title">QA Wait</h3>
                </div>
                <div class="panel-body">
                    <div style="height: 200px;" class="table-responsive">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Wait For Sale Follow Up Customer</h3>
                </div>
                <div class="panel-body">
                    <div style="height: 200px;" class="table-responsive">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<spring:url value="/resources/core/jsCustom/frms-index.js" var="frmsIndex" />
<script src="${frmsIndex}"></script>