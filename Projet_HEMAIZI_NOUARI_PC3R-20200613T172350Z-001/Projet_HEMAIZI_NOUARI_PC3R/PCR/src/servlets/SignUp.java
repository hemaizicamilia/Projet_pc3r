package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;

/*
 * inscription
 */
@SuppressWarnings("serial")
public class SignUp extends HttpServlet {
	
	
public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/signup.jsp" ).forward( request, response );

	}

public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		   String nom = request.getParameter("nom");
		   String prenom = request.getParameter("prenom");
		   String email = request.getParameter("email");
		   String mdps = request.getParameter("password");
		   String mdps2 = request.getParameter("password2");
		   String tel = request.getParameter("tel");
		   
		   Utilisateur user = new Utilisateur(nom , prenom , email , mdps , tel);
		   
		   if(verify(user) && mdps.equals(mdps2)) {
			   try {
				if(user.setUtilisateur()) {
					   request.setAttribute( "message", "ok" );
				   }else {
					   request.setAttribute( "message", "erreur bd" );
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			   this.getServletContext().getRequestDispatcher( "/WEB-INF/signup.jsp" ).forward( request, response );
		   }
		   else{
			   request.setAttribute( "message", "erreur dans la saisie" );
			   this.getServletContext().getRequestDispatcher( "/WEB-INF/signup.jsp" ).forward( request, response );
		   }
		   
		   
		}
			public boolean verify (Utilisateur u) {
				if(isValidEmail(u.getEmail()) && isValideTel(u.getTel())) {
					return true;
				} else return false;
			}
			private boolean isValideTel(String tel) {
				 if ( tel.matches( "([0-9]{10})" ) ) {return true;}
				return false;
			}
			public static boolean isValidEmail(String email) {
			
				 if ( email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {return true;}
				   return false;
				}
}