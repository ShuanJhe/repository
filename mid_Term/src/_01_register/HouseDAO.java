package _01_register; 

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class HouseDAO implements IHouseDAO {
	private static final String INSERT_STMT = "INSERT INTO house VALUES (?,?, ?, ?, ?, ?, ?,?,?,?,?)";
	private static final String UPDATE_STMT = "UPDATE house SET  land=?, addres=?, house_area=?, city_district=?, "
	+ "build_date=? ,house_floor =? ,house_type =?,house_bone=? ,finish_date =? ,house_number=? WHERE number=?";
	private static final String DELETE_STMT = "DELETE FROM house WHERE number=?";
	private static final String GET_ONE_STMT = "SELECT * FROM house WHERE number=?";
	private static final String GET_ALL_STMT = "SELECT * FROM house ORDER BY number";
	private static final String OUTPUT_JSON = "SELECT * FROM  house";

	Connection conn = null;
	DataSource ds=null;
	public HouseDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	

	public void getConnection() throws SQLException {
		conn = ds.getConnection();	
	}
	
	@Override
	public int insert(HouseBean house) throws SQLException {
		int updateCount = 0;
		getConnection();
		PreparedStatement pstmt2 = conn.prepareStatement(OUTPUT_JSON);
		ResultSet rs = pstmt2.executeQuery();
		int times = 0;
		while (rs.next()) {
			times = rs.getInt("number");
		}
		house.setNumber(times + 1);
		System.out.println(house.getNumber());
		PreparedStatement pstmt = conn.prepareStatement(INSERT_STMT);
		pstmt.setInt(1, house.getNumber());
		pstmt.setString(2, house.getLand());
		pstmt.setString(3, house.getAddres());
		pstmt.setDouble(4, house.getHouse_area());
		pstmt.setString(5, house.getCity_district());
		pstmt.setDate(6, new java.sql.Date(house.getBuild_date().getTime()));
		pstmt.setInt(7, house.getHouse_floor());
		pstmt.setString(8, house.getHouse_type());
		pstmt.setString(9, house.getHouse_bone());
		pstmt.setDate(10, new java.sql.Date(house.getFinish_date().getTime()));
		pstmt.setString(11, house.getHouse_number());
		updateCount = pstmt.executeUpdate();
		rs.close();
		pstmt2.close();
		pstmt.close();
		closeConn();
		return updateCount;
	}

	@Override
	public int update(HouseBean house) throws SQLException {
		int updateCount = 0;
		getConnection();
		PreparedStatement pstmt = conn.prepareStatement(UPDATE_STMT);
		pstmt.setString(1, house.getLand());
		pstmt.setString(2, house.getAddres());
		pstmt.setDouble(3, house.getHouse_area());
		pstmt.setString(4, house.getCity_district());
		pstmt.setDate(5,new java.sql.Date(house.getBuild_date().getTime()));
		pstmt.setInt(6, house.getHouse_floor());
		pstmt.setString(7, house.getHouse_type());
		pstmt.setString(8, house.getHouse_bone());
		
		pstmt.setDate(9, new java.sql.Date(house.getFinish_date().getTime()));
		pstmt.setString(10, house.getHouse_number());
		pstmt.setInt(11, house.getNumber());
		updateCount = pstmt.executeUpdate();
		pstmt.close();
		closeConn();
		return updateCount;
	}

	@Override
	public int delete(Integer number) throws SQLException {
		int updateCount = 0;
		getConnection();
		PreparedStatement pstmt = conn.prepareStatement(DELETE_STMT);
		pstmt.setInt(1, number);
		updateCount = pstmt.executeUpdate();
		pstmt.close();
		closeConn();
		return updateCount;

	}

	@Override
	public HouseBean findBynumber(int number) throws SQLException {
		HouseBean house = null;
		getConnection();
		PreparedStatement pstmt = conn.prepareStatement(GET_ONE_STMT);
		pstmt.setInt(1, number);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			house = new HouseBean();
			house.setNumber(rs.getInt("number"));
			house.setLand(rs.getString("land"));
			house.setAddres(rs.getString("addres"));
			house.setHouse_area(rs.getDouble("house_area"));
			house.setCity_district(rs.getString("city_district"));
			house.setBuild_date(rs.getDate("build_date"));
			house.setHouse_floor(rs.getInt("house_floor"));
			house.setHouse_type(rs.getString("house_type"));
			house.setHouse_bone(rs.getString("house_bone"));
			house.setFinish_date(rs.getDate("finish_date"));
			house.setHouse_number(rs.getString("house_number"));
		}
		rs.close();
		pstmt.close();
		closeConn();
		return house;
	}

	@Override
	public List<HouseBean> getAll() throws SQLException {
		HouseBean hos = null;
		getConnection();
		List<HouseBean> hoses = new ArrayList<HouseBean>();
		PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STMT);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			hos = new HouseBean();
			hos.setNumber(rs.getInt("number"));
			hos.setLand(rs.getString("land"));
			hos.setAddres(rs.getString("addres"));
			hos.setHouse_area(rs.getDouble("house_area"));
			hos.setCity_district(rs.getString("city_district"));
			hos.setBuild_date(rs.getDate("build_date"));
			hos.setHouse_floor(rs.getInt("house_floor"));
			hos.setHouse_type(rs.getString("house_type"));
			hos.setHouse_bone(rs.getString("house_bone"));
			hos.setFinish_date(rs.getDate("finish_date"));
			hos.setHouse_number(rs.getString("house_number"));
			hoses.add(hos);
		}
		rs.close();
		pstmt.close();
		closeConn();
		return hoses;
	}

	@Override
	public void Jsonwriter() throws SQLException, IOException {
		PreparedStatement pstmt = conn.prepareStatement(OUTPUT_JSON);
		PreparedStatement pstmt2 = conn.prepareStatement(OUTPUT_JSON);
		ResultSet rs = pstmt.executeQuery();
		ResultSet rs2 = pstmt2.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		BufferedWriter buw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("F:\\Mid_term\\test.txt")));
		int count = rsmd.getColumnCount();
		String str[] = new String[count + 1];
		for (int i = 1; i <= count; i++) {
			str[i] = "\"" + rsmd.getColumnLabel(i) + "\"";
		}

		int times = 0;
		while (rs2.next()) {
			times++;
		}
		int times2 = 0;
		buw.write("[");
		while (rs.next()) {
			times2++;
			buw.write("{");
			buw.write(str[1] + ":" + "\"" + rs.getString("land") + "\"" + ",");
			buw.write(str[2] + ":" + "\"" + rs.getString("addres") + "\"" + ",");
			buw.write(str[3] + ":" + rs.getFloat("house_area") + ",");
			buw.write(str[4] + ":" + "\"" + rs.getString("city_district") + "\"" + ",");
			buw.write(str[5] + ":" + "\"" + rs.getString("build_date") + "\"" + ",");
			buw.write(str[6] + ":" + rs.getInt("house_floor") + ",");
			buw.write(str[7] + ":" + "\"" + rs.getString("house_type") + "\"" + ",");
			buw.write(str[8] + ":" + "\"" + rs.getString("house_bone") + "\"" + ",");
			buw.write(str[9] + ":" + "\"" + rs.getString("finish_date") + "\"" + ",");
			buw.write(str[10] + ":" + "\"" + rs.getString("house_number") + "\"");
			if (times2 < times)
				buw.write("},");
			else
				buw.write("}]");
			buw.write("\n");
		}
		System.out.println("DAOsuccessful !!");
		buw.close();
		rs2.close();
		rs.close();
		pstmt2.close();
		pstmt.close();
		closeConn();
	}

	public void closeConn() throws SQLException {
		if (conn != null)
			conn.close();
	}

} // end of class EmpDAO