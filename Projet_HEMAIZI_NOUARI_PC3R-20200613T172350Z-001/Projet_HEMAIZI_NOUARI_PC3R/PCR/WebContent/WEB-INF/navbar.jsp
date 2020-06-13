<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<a class="navbar-brand" href="index"><img src="assets/images/logo.jpeg" width="120" height="80" alt=""></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
				
				
					<li class="active"><a href="index">Acceuil</a></li>	
					 <c:if test="${!empty sessionScope.email}">
					 
					 
					<li><a href="propose">Reserver un vol</a></li>	
					</c:if>			
					
					<li><a href="contact">Contact</a></li>
					 <c:if test="${empty sessionScope.email}">
					<li><a class="btn" href="signin">S'inscrire / Se connecter</a></li>
					</c:if>
					
					
					 <c:if test="${!empty sessionScope.email}">
					  <li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"> Mon compte  <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="profil">Mes informations</a></li>
							<li><a href="reservation">Mes réservations</a></li>
						</ul>
					</li>
					  </c:if>
					  
					  
					<c:if test="${!empty sessionScope.email}">
					<li><a class="btn" href="deconnexion"> Se deconnecter</a></li>
					</c:if>
					
					
				</ul>
			</div><!--/.nav-collapse -->
			
		</div>
	</div> 
	<!-- /.navbar -->
	
	