<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*" pageEncoding="UTF-8"%>
<%
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=mid_term";
	Connection conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");

// 	String qryStmt = "SELECT ename FROM employee";
    String qryStmt = "SELECT number FROM house";
	PreparedStatement stmt = conn.prepareStatement(qryStmt);
	ResultSet rs = stmt.executeQuery();

	String str = "<select name='number'>";
	String number;
	while (rs.next()) {
		number = rs.getString("number");
		str += "<option value='" + number + "'>" + number;
	}
	str += "</select>";
	out.print(str);
	conn.close();
%>