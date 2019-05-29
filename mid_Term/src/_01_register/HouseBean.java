package _01_register; 

import java.util.Date;

public class HouseBean {
	private Integer number;
	private String land;
	private String addres;
	private Double house_area;
	private String city_district;
	private Date build_date;
	private Integer house_floor;
	private String house_type;
	private String house_bone;
	private Date finish_date;
	private String house_number;
	public HouseBean () {
		
	}
	
	public HouseBean(String land, String addres, double house_area, String city_district,
			Date build_date, Integer house_floor, String house_type, String house_bone, Date finish_date,
			String house_number) {
		super();
		this.land = land;
		this.addres = addres;
		this.house_area = house_area;
		this.city_district = city_district;
		this.build_date = build_date;
		this.house_floor = house_floor;
		this.house_type = house_type;
		this.house_bone = house_bone;
		this.finish_date = finish_date;
		this.house_number = house_number;
	}
	public void setNumber(Integer number) {
		this.number = number;}
	public int getNumber() {
		return number;}
	public String getLand() {
		return land;}
	public void setLand(String land) {
		this.land = land;}
	public String getAddres() {
		return addres;}
	public void setAddres(String addres) {
		this.addres = addres;}
	public double getHouse_area() {
		return house_area;}

	public void setHouse_area(double house_area) {
		this.house_area = house_area;
	}

	public String getCity_district() {
		return city_district;
	}

	public void setCity_district(String city_district) {
		this.city_district = city_district;
	}

	public Date getBuild_date() {
		return build_date;
	}

	public void setBuild_date(Date build_date) {
		this.build_date = build_date;
	}

	public Integer getHouse_floor() {
		return house_floor;
	}

	public void setHouse_floor(Integer house_floor) {
		this.house_floor = house_floor;
	}

	public String getHouse_type() {
		return house_type;
	}

	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}

	public void setHouse_bone(String house_bone) {
		this.house_bone = house_bone;
	}

	public String getHouse_bone() {
		return house_bone;
	}

	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

} // end of class EmpVO