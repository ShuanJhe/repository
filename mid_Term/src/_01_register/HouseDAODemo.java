package _01_register; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HouseDAODemo {
	public static void main(String[] args)  {
		HouseDAO dao = new HouseDAO();
		try {
			dao.getConnection();
			 //insert
			BufferedReader buf = new BufferedReader(new FileReader("F:\\Mid_term\\03.csv"));
			HouseBean hos1 = new HouseBean();
			String data;
			buf.readLine();
			while ((data = buf.readLine()) != null) {
				String[] count = data.split(",");
				hos1.setLand(count[0]);
				hos1.setAddres(count[1]);
				hos1.setHouse_area(Float.parseFloat(count[2]));
				hos1.setCity_district(count[3]);				
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                Date theDate=null;
                theDate = format.parse(count[4]);			
                hos1.setBuild_date(theDate);
				hos1.setHouse_floor(Integer.parseInt(count[5]));
				hos1.setHouse_type(count[6]);
				hos1.setHouse_bone(count[7]);	
				theDate=null;
				theDate = format.parse(count[8].trim());		
                hos1.setFinish_date(theDate);
				hos1.setHouse_number(count[9]);
				dao.insert(hos1);
				System.out.println("insert  no: "+hos1.getNumber()+"successful");
//				for(int i=0;i<10;i++) {
//					System.out.println(count[i]);
//				}
			}
			buf.close();
			System.out.println("---------------------------------");
//			// update
			HouseBean hos2 = new HouseBean();
			hos2.setLand("updae隨便一區地");
			hos2.setAddres("update隨便一區國");
			hos2.setHouse_area(99.999);
			hos2.setCity_district("update隨便一區");
			hos2.setBuild_date(java.sql.Date.valueOf("2019-04-10"));
			hos2.setHouse_floor(101);
			hos2.setHouse_type("update隨便一型");
			hos2.setHouse_bone("update隨便一骨");
			hos2.setFinish_date(java.sql.Date.valueOf("2019-04-11"));
			hos2.setHouse_number("ABCDERFGGGGG156GG");
			hos2.setNumber(2);
			int count2 = dao.update(hos2);
			System.out.println("update " + count2 + " rows");
			System.out.println("---------------------------------");
			
			// delete
			int count3 = dao.delete(103);
			System.out.println("delete " + count3 + " rows");
			System.out.println("delete successful");
			System.out.println("---------------------------------");
			// find by PrimaryKey
			HouseBean house3 = dao.findBynumber(1);
			System.out.println("number = " + house3.getNumber());
			System.out.println("house_land = " + house3.getLand());
			System.out.println("addres = " + house3.getAddres());
			System.out.println("house_area = " + house3.getHouse_area());
			System.out.println("city_district = " + house3.getCity_district());
			System.out.println("build_date = " + house3.getBuild_date());
			System.out.println("house_floor = " + house3.getHouse_floor());
			System.out.println("house_type = " + house3.getHouse_type());
			System.out.println("House_bone = " + house3.getHouse_bone());
			System.out.println("getFinish_date = " + house3.getFinish_date());
			System.out.println("getHouse_number = " + house3.getHouse_number());
			System.out.println("---------------------------------");

			dao.Jsonwriter();
			System.out.println("writeJson_sucessful");
			System.out.println("---------------------------------");


			// get all emp
//			java.util.List<HouseBean> housese = dao.getAll();
//			for (HouseBean house : housese) {
//				System.out.print(house.getNumber() + ", ");
//				System.out.print(house.getLand() + ", ");
//				System.out.print(house.getAddres() + ", ");
//				System.out.print(house.getHouse_area() + ", ");
//				System.out.print(house.getCity_district() + ", ");
//				System.out.print(house.getBuild_date() + ", ");
//				System.out.print(house.getHouse_floor() + ", ");
//				System.out.print(house.getHouse_type() + ", ");
//				System.out.print(house.getHouse_bone() + ", ");
//				System.out.print(house.getFinish_date() + ", ");
//				System.out.print(house.getHouse_number() + "\n");
//
//				System.out.println("---------------------------------");
//			}
		} catch (NumberFormatException e) {
			e.printStackTrace();}
		 catch (IOException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			try {
				dao.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
} // end of class EmpDAODemo