<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/" var="home" />
<script>
  window.open("${home}", "", "width=10000, height=10000");
</script>
