<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gradle + Spring MVC</title>
    <spring:url value="/resources/core/css/hello.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
</head>
<body>
    <tiles:insertAttribute name="header" />
    <div class="jumbotron">
        <div class="container">
            <tiles:insertAttribute name="body"/>
        </div>
    </div>
    <div class="container">
        <tiles:insertAttribute name="footer"/>
    </div>
    <spring:url value="/resources/core/js/hello.js" var="coreJs" />
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
    <spring:url value="/resources/core/js/jquery.min.js" var="jqueryJs" />
    <script src="${coreJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${jqueryJs}"></script>
</body>
</html>