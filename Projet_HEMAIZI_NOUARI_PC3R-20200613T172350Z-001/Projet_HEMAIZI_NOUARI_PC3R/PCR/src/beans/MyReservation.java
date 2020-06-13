package beans;

public class MyReservation {
	
	private String aeroport_depart ;
	private String aeroport_arr ;
	private String date_depart ;
	private String date_arr;
	private String company ;
	private int user ;
	
	
	public MyReservation() {
		super();
	}
	
	
	public MyReservation(String aeroport_depart, String aeroport_arr, String date_depart, String date_arr,
			String company, int user) {
		super();
		this.aeroport_depart = aeroport_depart;
		this.aeroport_arr = aeroport_arr;
		this.date_depart = date_depart;
		this.date_arr = date_arr;
		this.company = company;
		this.user = user;
	}



	public String getAeroport_depart() {
		return aeroport_depart;
	}



	public void setAeroport_depart(String aeroport_depart) {
		this.aeroport_depart = aeroport_depart;
	}



	public String getAeroport_arr() {
		return aeroport_arr;
	}



	public void setAeroport_arr(String aeroport_arr) {
		this.aeroport_arr = aeroport_arr;
	}



	public String getDate_depart() {
		return date_depart;
	}



	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}



	public String getDate_arr() {
		return date_arr;
	}



	public void setDate_arr(String date_arr) {
		this.date_arr = date_arr;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public int getUser() {
		return user;
	}



	public void setUser(int user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "MyResevation [aeroport_depart=" + aeroport_depart + ", aeroport_arr=" + aeroport_arr + ", date_depart="
				+ date_depart + ", date_arr=" + date_arr + ", company=" + company + ", user=" + user + "]";
	}

	
	
	
	


}
