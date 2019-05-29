package _01_register; 


import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public interface IHouseDAO {
	public void getConnection() throws SQLException;
	public int insert(HouseBean house) throws SQLException;
	public int update(HouseBean house) throws SQLException;
	public int delete(Integer number) throws SQLException;
	public HouseBean findBynumber(int number) throws SQLException;
	public List<HouseBean> getAll() throws SQLException;
	public void Jsonwriter() throws SQLException, IOException;
	public void closeConn() throws SQLException;

} // end of class IHouseDAO