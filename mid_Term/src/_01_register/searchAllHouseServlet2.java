package _01_register;

import java.io.IOException;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/all")
public class searchAllHouseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		StringBuilder str=new StringBuilder();
//		HouseDAO dao = new HouseDAO();
		RequestDispatcher rdEro = request.getRequestDispatcher("/_01_register/searchLandError.jsp");
			try {
				HouseDAO daoCheck = new HouseDAO();
				HouseBean beanCheck = new HouseBean();
			    List<HouseBean> listAll= new ArrayList<HouseBean>();
			    listAll =daoCheck.getAll();
				if (beanCheck != null) {
					for (HouseBean house : listAll) {
						str.append(house.getNumber());
						str.append(house.getAddres());
						str.append(house.getCity_district());
						str.append(house.getHouse_area());
						str.append(house.getHouse_bone());
						str.append(house.getHouse_number());
						str.append(house.getHouse_type());
						str.append(house.getLand());
					}
					response.getWriter().print(str);
				
//					RequestDispatcher rd = request.getRequestDispatcher("/_01_register/searchLandSuccess.jsp");
//					rd.forward(request, response);
				}
				
			}  catch (SQLException e) {
				errorMessage.add("資料庫存取錯誤:" + e.getMessage());
				rdEro.forward(request, response);
			}
		
	}
}
