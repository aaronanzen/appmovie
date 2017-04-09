package mx.com.geodriver.service.rest.impl;

import java.util.ArrayList;

import mx.com.geodriver.service.rest.dto.DriverDTO;
import mx.com.geodriver.service.rest.dto.GeoAddressLocationDTO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoAddressProvider {

	private ArrayList<DriverDTO> driversDB = new ArrayList<DriverDTO>();

	public GeoAddressProvider() {
		// TODO Auto-generated constructor stub

		GeoAddressLocationDTO[] address = new GeoAddressLocationDTO[3];
		address[0] = new GeoAddressLocationDTO();
		address[1] = new GeoAddressLocationDTO();
		address[2] = new GeoAddressLocationDTO();

		address[2].setLatitude1From(19.274370840212917);
		address[2].setLongitud1From(-99.22736026346684);

		address[2].setLongitud2To(-99.22764658927917);
		address[2].setLatitude2To(19.384956748994565);

		DriverDTO[] drivers = new DriverDTO[3];
		drivers[0] = new DriverDTO();
		drivers[0].setUser("jariz");
		drivers[0].setPassword("123456");
		
		drivers[1] = new DriverDTO();
		drivers[1].setUser("victor");
		drivers[1].setPassword("123456");
	

		drivers[2] = new DriverDTO();
		drivers[2].setUser("marlene");
		drivers[2].setPassword("123456");
		drivers[2].getRoutes().add(address[2]);

		driversDB.add(drivers[0]);
		driversDB.add(drivers[1]);
		driversDB.add(drivers[2]);

	}

	@RequestMapping("/geoaddressproviderStoreDriverLocation")
	public String saveDriverLocationn(@RequestParam(value = "user") String user,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "pointOLat") String pointOLat,
			@RequestParam(value = "pointOLong") String pointOLong,
			@RequestParam(value = "pointDLat") String pointDLat,
			@RequestParam(value = "pointDLong") String pointDLong
			) {

		for (int i = 0; i < driversDB.size(); i++) {
			DriverDTO driverDTO = driversDB.get(i);

			if (driverDTO.getUser().equals(user)
					&& driverDTO.getPassword().equals(password)) {

				
				GeoAddressLocationDTO address = new GeoAddressLocationDTO();
				address.setLatitude1From(Double.parseDouble(pointOLat));
				address.setLongitud1From(Double.parseDouble(pointOLong));

				address.setLatitude2To(Double.parseDouble(pointDLat));
				address.setLongitud2To(Double.parseDouble(pointDLong));

				driverDTO.setCurrentLocation(address);
				return "ok ";
			}
		}

		return "Driver not found or password wrong!";
	}
	
	@RequestMapping("/geoaddressproviderStore")
	public String sendAddr(@RequestParam(value = "user") String user,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "pointOLat") String pointOLat,
			@RequestParam(value = "pointOLong") String pointOLong,
			@RequestParam(value = "pointDLat") String pointDLat,
			@RequestParam(value = "pointDLong") String pointDLong
			) {

		for (int i = 0; i < driversDB.size(); i++) {
			DriverDTO driverDTO = driversDB.get(i);

			if (driverDTO.getUser().equals(user)
					&& driverDTO.getPassword().equals(password)) {

				driverDTO.getRoutes().clear();
				GeoAddressLocationDTO address = new GeoAddressLocationDTO();
				address.setLatitude1From(Double.parseDouble(pointOLat));
				address.setLongitud1From(Double.parseDouble(pointOLong));

				address.setLatitude2To(Double.parseDouble(pointDLat));
				address.setLongitud2To(Double.parseDouble(pointDLong));

				driverDTO.getRoutes().add(address);
				return "Ruta asignada a "+user;
			}
		}

		return "Driver not found or password wrong!";
	}

	@RequestMapping("/geoaddressprovider")
	public GeoAddressLocationDTO getAvailableAddr(
			@RequestParam(value = "user") String user,
			@RequestParam(value = "password") String password) {

		

		for (int i = 0; i < driversDB.size(); i++) {
			DriverDTO driverDTO = driversDB.get(i);
			if (driverDTO.getUser().equals(user)
					&& driverDTO.getPassword().equals(password)) {

				return driverDTO.getRoutes().get(0);
			}
		}
		

		return null;

	}
	@RequestMapping("/geoaddressproviderDriverLocation")
	public GeoAddressLocationDTO getCurrentDriverLocation(
			@RequestParam(value = "user") String user) {

		

		for (int i = 0; i < driversDB.size(); i++) {
			DriverDTO driverDTO = driversDB.get(i);
			if (driverDTO.getUser().equals(user)) {

				return driverDTO.getCurrentLocation();
			}
		}
		

		return null;

	}

}
