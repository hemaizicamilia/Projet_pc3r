package beans;

public class Vol {
	
	private String aeroport_depart;
	private String aeroport_arrive;
	private String date_depart ;
	private String date_arrive ;
	private String company;
	
	
	public Vol(String aeroport_depart, String aeroport_arrive, String date_depart, String date_arrive, String company) {
		super();
		this.aeroport_depart = aeroport_depart;
		this.aeroport_arrive = aeroport_arrive;
		this.date_depart = date_depart;
		this.date_arrive = date_arrive;
		this.company = company;
	}


	public String getAeroport_depart() {
		return aeroport_depart;
	}


	public void setAeroport_depart(String aeroport_depart) {
		this.aeroport_depart = aeroport_depart;
	}


	public String getAeroport_arrive() {
		return aeroport_arrive;
	}


	public void setAeroport_arrive(String aeroport_arrive) {
		this.aeroport_arrive = aeroport_arrive;
	}


	public String getDate_depart() {
		return date_depart;
	}


	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}


	public String getDate_arrive() {
		return date_arrive;
	}


	public void setDate_arrive(String date_arrive) {
		this.date_arrive = date_arrive;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	
	

}
