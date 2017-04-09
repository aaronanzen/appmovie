package mx.com.geodriver.service.rest.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class DriverDTO implements Serializable {
private GeoAddressLocationDTO currentLocation;
public GeoAddressLocationDTO getCurrentLocation() {
	return currentLocation;
}
public void setCurrentLocation(GeoAddressLocationDTO currentLocation) {
	this.currentLocation = currentLocation;
}
private String user;
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
private String password;
private ArrayList< GeoAddressLocationDTO> routes=new ArrayList();
public ArrayList<GeoAddressLocationDTO> getRoutes() {
	return routes;
}
public void setRoutes(ArrayList<GeoAddressLocationDTO> routes) {
	this.routes = routes;
}



}
