<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Inscription</title>

	<link rel="shortcut icon" href="assets/images/gt_favicon.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="assets/css/main.css">

	
</head>

<body>
	<!-- Fixed navbar -->
	<%@ include file="navbar.jsp" %>
	
	<!-- /.navbar -->

	<header id="head" class="secondary"></header>

<%
  			String msg = (String)request.getAttribute( "message" );
            if(msg != null){
            	if(msg.equals("ok")){ %>
            		 <div class="alert alert-success">
   					 <strong> Inscription validée </strong>
				     </div>
            	<%}else
            	{%>
            		<div class="alert alert-danger">
    				<strong> Erreur de saisie !</strong> 
 					</div>
            	<%}
            	
            }
  %>	


	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="index.html">Home</a></li>
			<li class="active">Inscription</li>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Inscription</h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">créez un nouveau compte !</h3>
							<p class="text-center text-muted">Vous avez déja un compte ? <a href="signin">Login</a> ! </p>
							<hr>

							<form  method="post" action="signup">
								<div class="top-margin">
									<label>Nom</label>
									<input type="text" name="nom" class="form-control" required>
								</div>
								<div class="top-margin">
									<label>Prénom</label>
									<input type="text" name="prenom" class="form-control" required>
								</div>
								
								<div class="top-margin">
									<label>Téléphonne</label>
									<input type="tel" name="tel" class="form-control" required>
								</div>
								
								<div class="top-margin">
									<label>Adresse email <span class="text-danger">*</span></label>
									<input type="email" name="email"  class="form-control"required>
								</div>

								<div class="row top-margin">
									<div class="col-sm-6">
										<label>mot de passe <span class="text-danger">*</span></label>
										<input type="password" name="password" required class="form-control" required>
									</div>
									<div class="col-sm-6">
										<label>Confirmer le mot de passe <span class="text-danger">*</span></label>
										<input type="password" name="password2" class="form-control">
									</div>
								</div>

								<hr>

								<div class="row">
								
									<div class="col-lg-4 text-right">
										<button class="btn btn-action" type="submit">S'enregistrer </button>
									</div>
								</div>
							</form>
						</div>
					</div>

				</div>
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->
	

	<footer id="footer" class="top-space">

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
</body>
</html>