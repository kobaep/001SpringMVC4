<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/" var="home" />
<script>
  window.open("${home}resources/fileOutPutPDF/${urlPdf}");
</script>
