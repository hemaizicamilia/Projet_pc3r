<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="beans.Utilisateur"%> 

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Mon profil</title>

	<link rel="shortcut icon" href="assets/images/gt_favicon.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="assets/css/main.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>

<body>
	<!-- Fixed navbar -->
	<%@ include file="navbar.jsp" %>
	
	<!-- /.navbar -->

	
	
	<header id="head" class="secondary"></header>
<c:if test="${!empty sessionScope.email}">

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">Mon profil</li>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Mon profil</h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							
							<hr>
							
			<%
					Utilisateur user = (Utilisateur)request.getAttribute( "user" );
			   		session.setAttribute("id", user.getId());
			                                   
			  %>	
							<form  >
								<div class="top-margin">
									<label>Adresse Email <i class="fa fa-envelope"></i></label>
									<input type="email" name="email" class="form-control" value = "<% out.print(user.getEmail()); %>" readonly="readonly" >
								</div>
								<div class="top-margin">
									<label>Nom <i class="fa fa-address-book"></i></label>
									<input type="text" name="nom" class="form-control" value = "<% out.print(user.getNom()); %>" readonly="readonly">
								</div>
								
								<div class="top-margin">
									<label>Prénom <i class="fa fa-address-book"></i></label>
									<input type="text" name="prenom" class="form-control" value = "<% out.print(user.getPrenom()); %>" readonly="readonly">
								</div>
								
								<div class="top-margin">
									<label>Téléphonne <i class="fa fa-mobile"></i></label>
									<input type="tel" name="tel" class="form-control" value = "<% out.print(user.getTel()); %>" readonly="readonly" >
								</div>
								<hr>

								
							</form>
						</div>
					</div>

				</div>
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->
	</c:if>	


	<c:if test="${empty sessionScope.email}">
	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li>  </li>
	
		</ol>
		<ol class="breadcrumb">
			<li>  </li>
	
		</ol>
		<ol class="breadcrumb">
			<li>  </li>
	
		</ol>
		
		<ol class="breadcrumb">
			<li>  </li>
	
		</ol>
		<ol class="breadcrumb">
			<li>  </li>
	
		</ol>
		

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
			
			<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center"> Vous n'etes pas connecté <a href="signin"> se connecter</a></h3>
							<p class="text-center text-muted">  </p>
						</div>
					</div>
			</div>
			

			</article>
			<!-- /Article -->
			
		

		</div>
	</div>	<!-- /container -->
	</c:if>	

	<footer id="footer">

		<div class="footer1">
			<div class="container">
				<div class="row">
					
					<div class="col-md-3 widget">
						<h3 class="widget-title">Contact</h3>
						<div class="widget-body">
						
						</div>
					</div>

					<div class="col-md-3 widget">
						<h3 class="widget-title">Follow me</h3>
						<div class="widget-body">
							<p class="follow-me-icons clearfix">
								<a href=""><i class="fa fa-twitter fa-2"></i></a>
								<a href=""><i class="fa fa-dribbble fa-2"></i></a>
								<a href=""><i class="fa fa-github fa-2"></i></a>
								<a href=""><i class="fa fa-facebook fa-2"></i></a>
							</p>	
						</div>
					</div>

					<div class="col-md-6 widget">
						<h3 class="widget-title">Text widget</h3>
						
					</div>

				</div> <!-- /row of widgets -->
			</div>
		</div>

		
	</footer>	
		




	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>
	
	<!-- Google Maps -->
	<script src="https://maps.googleapis.com/maps/api/js?key=&amp;sensor=false&amp;extension=.js"></script> 
	<script src="assets/js/google-map.js"></script>
	

</body>
</html>