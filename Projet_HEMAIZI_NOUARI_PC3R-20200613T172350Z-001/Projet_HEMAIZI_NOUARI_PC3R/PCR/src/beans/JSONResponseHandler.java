package beans;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Parsing json response
 */

public class JSONResponseHandler {

    
    public ArrayList<Vol> readJsonStream(InputStream response, String aeroportD, String aeroportA, String date) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new InputStreamReader(response, "UTF-8")); 
		String aeroport_depart = null;
		String aeroport_arr = null;
		String date_depart = null ;
		String date_arr = null;
		String company = null;
        Vol v = null ;
      
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
       
        
        ArrayList<Vol> vols = new ArrayList<Vol>();
        
        // object principale 
        JSONObject jo = (JSONObject) obj; 
        
        // JsonArray of all the data flights
        JSONArray data = (JSONArray) jo.get("data"); 
                  

        
        // iterate on all the flights 
        Iterator itr2 = data.iterator(); 
        while (itr2.hasNext())  
        { 
        	
        	JSONObject info = (JSONObject) itr2.next();
        

        	if(info.get("flight_date").equals(simpleDateFormat1.format(calendar.getTime()))){
        		
        		Map departure = (Map) info.get("departure");
        		Map arrival = (Map) info.get("arrival");
        		Map airline = (Map) info.get("airline");
        		
        	
        		
        		Iterator<Map.Entry> itr1 = departure.entrySet().iterator(); 
                while (itr1.hasNext()) { 
                    Map.Entry pair = itr1.next(); 
                    if(pair.getKey().equals("airport")) {
                    	aeroport_depart = (String) pair.getValue();
                    }
                    
                    if(pair.getKey().equals("scheduled")) {
                    	date_depart = (String) pair.getValue();
                    }
                } 
                
                
               itr1 = arrival.entrySet().iterator(); 
                while (itr1.hasNext()) { 
                    Map.Entry pair = itr1.next(); 
                    if(pair.getKey().equals("airport")) {
                    	aeroport_arr = (String) pair.getValue();
                    }
                    
                    if(pair.getKey().equals("scheduled")) {
                    	date_arr = (String) pair.getValue();
                    }
                } 
                
                
                itr1 = airline.entrySet().iterator(); 
                while (itr1.hasNext()) { 
                    Map.Entry pair = itr1.next(); 
                    if(pair.getKey().equals("name")) {
                    	company = (String) pair.getValue();
                    }
                 
                } 
        		//System.out.println("labels: "+aeroportD+ " , "+ aeroportA );

        		//System.out.println("json : "+aeroport_arr+ " , "+ aeroport_depart + " , "+ company );
                if(aeroport_depart != null && aeroport_arr != null && company != null) {

        			if(aeroport_depart.equalsIgnoreCase(aeroportD) && aeroport_arr.equalsIgnoreCase(aeroportA)) {
        				System.out.println("trouvé: "+aeroport_depart+ " , "+ aeroport_arr );
        				v = new Vol(aeroport_depart,aeroport_arr,date_depart,date_arr,company);
                		vols.add(v);
            		}
                }
    		
        	}
        		
        }
    return vols;
    }

}



