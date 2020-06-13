package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;

@SuppressWarnings("serial")
public class Profil extends HttpServlet {
	
	public final static  String VUE = "/WEB-INF/profil.jsp";
	
public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		String email =  (String) session.getAttribute("email");
		
		
		Utilisateur user = this.getInformations(email);
		
		request.setAttribute("user", user);

		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	}

		   
		public Utilisateur getInformations(String email) {
			
			Utilisateur user= null;
			
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
		
			    String q = "select * from User where email = '"+email+"';";
			    
			   resultat = statement.executeQuery( q );
			   
					   if(resultat.next()) {
						   user = new Utilisateur(resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("email"), resultat.getString("mdps"), resultat.getString("tel"));	
						   user.setId(resultat.getInt("id"));
					   }   
				}
			   catch ( SQLException e ) {
				System.out.println(e);
			   } finally {
			    if ( connexion != null )
			        try {
			           
			            connexion.close();
			        } catch ( SQLException ignore ) {
			            url = url +"";
			        }
			}
			return user;
		}
		

}