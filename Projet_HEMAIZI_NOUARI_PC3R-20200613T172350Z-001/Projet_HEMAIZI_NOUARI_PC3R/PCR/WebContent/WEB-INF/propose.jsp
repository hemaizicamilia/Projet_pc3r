<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Reservation</title>

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

<c:if test="${!empty sessionScope.email}">

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="index">Home</a></li>
			<li class="active">Réservation de vol</li>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Réservation de vol</h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center"> Reserver votre vol ici !</h3>
							<p class="text-center text-muted">  </p>
							<hr>

							<form method = "post" action="listevols" >
								<div class="top-margin">
									<label>Aéroport de départ <span class="text-danger">*</span></label>
									<input list="aeroports" name= "aeroport_depart" class="form-control" required>
									  <datalist id="aeroports"> 
									    <option value="La plata">
									    <option value="Bert Mooney Airport"> 
									    <option value="Karewa">	  
									    <option value="Sky Harbor International">	  
									    <option value="Denver International">
									    <option value="Christchurch International">
									   
									    <option value="San Francisco International">
	
									    
									  </datalist>
								</div>
								<div class="top-margin">
									<label>Aéroport de d'arrivée <span class="text-danger">*</span></label>
									<input list="aeroports_ar" name= "aeroport_arr"  class="form-control" required >
									  <datalist id="aeroports_ar">
									    <option value="La plata">
									    <option value="Sky Harbor International">
									    <option value="Bert Mooney Airport"> 
									    <option value="Salt Lake City International">		  								    <option value="La plata">
									    <option value="Denver International">
									    <option value="Seattle-Tacoma International">
									    <option value="San Francisco International">
									    <option value="Roatan">
									    <option value="Auckland International">
									   
									    <option value="Albuquerque International">									    
									  </datalist>
								</div>
								<div class="top-margin">
									<label> date de départ <span class="text-danger">*</span></label>
									<input type="date" name= "date" class="form-control" required >
								</div>


								<hr>

								<div class="row">
								
									<div class="col-lg-4 text-right">
										<button class="btn btn-action" type="submit">Recherche </button>
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
	
			

	<footer id="footer" class="top-space">

		<div class="footer1">
			<div class="container">
				<div class="row">
					
					<div class="col-md-3 widget">
						<h3 class="widget-title">Contact</h3>
						
					</div>

					<div class="col-md-3 widget">
						<h3 class="widget-title">Follow me</h3>
						<div class="widget-body">
							<p class="follow-me-icons">
								<a href=""><i class="fa fa-twitter fa-2"></i></a>
								<a href=""><i class="fa fa-dribbble fa-2"></i></a>
								<a href=""><i class="fa fa-github fa-2"></i></a>
								<a href=""><i class="fa fa-facebook fa-2"></i></a>
							</p>	
						</div>
					</div>

					<div class="col-md-6 widget">
						<h3 class="widget-title"></h3>
					
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