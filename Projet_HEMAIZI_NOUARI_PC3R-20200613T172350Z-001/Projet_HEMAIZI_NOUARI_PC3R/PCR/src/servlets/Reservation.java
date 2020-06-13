package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MyReservation;
import beans.Vol;

@SuppressWarnings("serial")
public class Reservation extends HttpServlet {
	
	
public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
			request.setAttribute( "message", "ok" );
			 /* Création ou récupération de la session */
			   HttpSession session = request.getSession();
			   
			   /* Mise en session d'une chaîne de caractères */
			   String email = (String) session.getAttribute("email");
			   
			   // get reservations 
			   try {
				ArrayList<MyReservation> res =   this.getReservation(email);
				System.out.println(res.size());
				
				request.setAttribute("res", res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
		this.getServletContext().getRequestDispatcher( "/WEB-INF/reservation.jsp" ).forward( request, response );

	}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			
			request.setAttribute( "message", "ok" );
			 /* Création ou récupération de la session */
			   HttpSession session = request.getSession();
			   
			   /* Mise en session d'une chaîne de caractères */
			   String email = (String) session.getAttribute("email");
			   
			   // get reservations 
			   try {
				ArrayList<MyReservation> res =   this.getReservation(email);
				System.out.println(res.size());
				
				request.setAttribute("res", res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
			   
			   
			   /************************************/
			MyReservation reservation = null;

			 ArrayList<Vol> vols = (ArrayList<Vol>) session.getAttribute("vols");
			 for(int i=0;i < vols.size(); i++) {
				 String btn =  request.getParameter("btn"+i);
				 if (btn != null) {
					 reservation = new MyReservation();
					 reservation.setAeroport_depart(vols.get(i).getAeroport_depart());
					 reservation.setAeroport_arr(vols.get(i).getAeroport_arrive());
					 reservation.setDate_depart(vols.get(i).getDate_depart());
					 reservation.setDate_arr(vols.get(i).getDate_arrive());
					 reservation.setCompany(vols.get(i).getCompany());
					 reservation.setUser((int)session.getAttribute("id"));
					 

				 }
			 }
			 
			  try {
				if(this.Reserver(reservation)) {
					request.setAttribute( "message", "ok" );
				}else {
					request.setAttribute( "message", "erreur" );
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
			
			this.getServletContext().getRequestDispatcher( "/WEB-INF/reservation.jsp" ).forward( request, response );

		}

		  
		public ArrayList<MyReservation> getReservation(String email) throws SQLException 
		{
			
			MyReservation res =null ;
			ArrayList<MyReservation> reservations = new ArrayList<MyReservation>();

			
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
				
					    String q = "select * from Reservation, User  where Reservation.utilisateur = User.id and User.email = '"+email+"';";
					    
					   resultat = statement.executeQuery( q );
					   
					   while(resultat.next()) {
						   res = new MyReservation(resultat.getString("aeroport_depart"), resultat.getString("aeroport_arr"), resultat.getString("date_depart"), resultat.getString("date_arr"), resultat.getString("company"), resultat.getInt("utilisateur"));
					   		reservations.add(res);
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
					return reservations;					 
		} 
		
				
		public boolean Reserver(MyReservation res ) throws SQLException {
			
			try {
			    Class.forName( "com.mysql.jdbc.Driver" );
			} catch ( ClassNotFoundException e ) {
			    System.out.println(e);
			}
		    String url = "jdbc:mysql://localhost:3306/bd_pcr?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String utilisateur = "java";
			String motDePasse = "123";
			Connection connexion = null;
			int statut ;
			try {
			    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
			    Statement statement = connexion.createStatement();
			    
			    String q = "INSERT INTO Reservation (aeroport_depart, aeroport_arr, date_depart, date_arr, company,utilisateur) VALUES ('"+ 
			    res.getAeroport_depart()+"','"+res.getAeroport_arr()+"','"+ res.getDate_depart()
	    		+ "','"+ res.getDate_arr()+"','"+ res.getCompany() +"',"+ res.getUser()+");";
	
			   statut = statement.executeUpdate(q);
			
			   
			    if(statut == 1) {
			    	return true ;
			    }else {
			    	return false ;
			    }
			    
			    
			} catch ( SQLException e ) {
			    return false ;
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