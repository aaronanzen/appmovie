package mx.com.geodriver.service.rest.dto;
import java.io.Serializable;


public class GeoAddressLocationDTO implements Serializable {

	private double latitude1From;
	private double longitud1From;
	private double latitude2To;
	
	
	public double getLatitude2To() {
		return latitude2To;
	}
	public void setLatitude2To(double latitude2To) {
		this.latitude2To = latitude2To;
	}
	public double getLongitud2To() {
		return longitud2To;
	}
	public void setLongitud2To(double longitud2To) {
		this.longitud2To = longitud2To;
	}
	private double longitud2To;
	public double getLatitude1From() {
		return latitude1From;
	}
	public void setLatitude1From(double latitude1From) {
		this.latitude1From = latitude1From;
	}
	public double getLongitud1From() {
		return longitud1From;
	}
	public void setLongitud1From(double longitud1From) {
		this.longitud1From = longitud1From;
	}
	
	
}
