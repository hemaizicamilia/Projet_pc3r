package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

	/**
	 * connexion
	 */
@SuppressWarnings("serial")
public class SignIn extends HttpServlet {
	
	public static final String VUE  = "/WEB-INF/signin.jsp";
	public static final String HOME  = "/WEB-INF/index.jsp";

	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		   
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
				int id;
			   String email = request.getParameter("email");
			   String mdps = request.getParameter("password");
			   
				 
				  		   
			    try {
			    	 id = isMember(email,mdps) ;
					    if(email != null  && mdps != null && id != 0) {
					    	
								request.setAttribute( "message", "ok" );
								
								 /* Création ou récupération de la session */
								   HttpSession session = request.getSession();
								   
								   /* Mise en session d'une chaîne de caractères */
								   session.setAttribute("email", email );
								   session.setAttribute("id", id);

								 this.getServletContext().getRequestDispatcher(HOME ).forward( request, response );

						}else {
							
								request.setAttribute( "message", "erreur" );
								
								 this.getServletContext().getRequestDispatcher(VUE ).forward( request, response );

						}				    			
					} 
			    catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			  
				   
  }
			   
	
	
	
	
		public int isMember(String email , String mdps) throws SQLException 
		{
				    try {
						Class.forName( "com.mysql.cj.jdbc.Driver" );
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				    String url = "jdbc:mysql://localhost:3306/bd_pcr?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
					String utilisateur = "java";
					String motDePasse = "123";
					Connection connexion = null;
					ResultSet resultat = null  ;
					try {
					    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
					    Statement statement = connexion.createStatement();
				
					    String q = "select * from User where "+"email = '"+email+"' AND mdps ='"+mdps+"';";
					    
					   resultat = statement.executeQuery( q );

					   if(resultat.next()) 
					    	return resultat.getInt("id") ;
					   	else 
					   		return 0 ; 
					}
					   catch ( SQLException e ) {
						System.out.println(e);
					    return 0 ;
					} finally {
					    if ( connexion != null )
					        try {
					           
					            connexion.close();
					        } catch ( SQLException ignore ) {
					            url = url +"";
					        }
					}					 
		}  	
	

}	   


			
