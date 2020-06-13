package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import beans.JSONResponseHandler;
import beans.MyReservation;
import beans.Vol;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ListeVols extends HttpServlet {
	JSONResponseHandler json;
    InputStream is;
	public static final String URL = "http://api.aviationstack.com/v1/flights?access_key=a60a384bbabf6a2f875b4b4f94aeee47"; 

	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/listevols.jsp" ).forward( request, response );

	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		ArrayList<Vol> vols = new ArrayList<Vol>();
			   String aeroport_depart = request.getParameter("aeroport_depart");
			   String aeroport_arr = request.getParameter("aeroport_arr");
			   String date = request.getParameter("date");
			  

			// create URL
				URL url = new URL(URL);
				// Connecte to the url
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// define the method 
				is = conn.getInputStream();		
				
				json = new JSONResponseHandler();
		    try {
		        	
				vols =	json.readJsonStream(is, aeroport_depart, aeroport_arr,date);
				request.setAttribute("vols", vols);
				
				
					for(int i=0;i< vols.size(); i++) {
						System.out.println(vols.get(i).getCompany());
				
				}
					
			} catch (IOException e) {
					e.printStackTrace();
			} catch (ParseException e) {
					e.printStackTrace();
				}
		
		    this.getServletContext().getRequestDispatcher( "/WEB-INF/listevols.jsp" ).forward( request, response );

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
    		+ "','"+ res.getDate_arr()+"','"+ res.getCompany() +"','"+ res.getUser()+"');";

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