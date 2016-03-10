<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
		<div class="navbar-collapse collapse" id="navbar-main">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<span id="username"><jsp:text/></span>
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
						<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu" id="userCheck">
						<li><a href="${home}login">Login</a></li>
						<li><a href="${home}resources/j_spring_security_logout">Logout</a></li>
						<li><a href="${home}appuser?form">Create User</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>