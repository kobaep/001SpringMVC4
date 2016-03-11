<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/" var="home" />
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a href="${home}" class="navbar-brand">FOAMTEC</a>
			<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">MTMS<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<c:if test="${roleName eq 'qa'}">
							<li><a href="${home}matter?form">Create Material Type</a></li>
						</c:if>
						<li><a href="${home}matterlo/listmattype">Material</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<span id="username">
							<c:if test="${not empty name}" >
								${name}
							</c:if>
						</span>
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<c:if test="${not empty login}">
							<li id="login"><a href="${home}login">Login</a></li>
						</c:if>
						<c:if test="${not empty createUser}">
							<li id="create"><a href="${home}appuser?form">Create User</a></li>
						</c:if>
						<c:if test="${not empty logout}">
							<li id="logout"><a href="${home}resources/j_spring_security_logout">Logout</a></li>
						</c:if>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>