package _01_register;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searCh")
public class searchHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);
		request.setCharacterEncoding("UTF-8");
//		HouseDAO dao = new HouseDAO();
		RequestDispatcher rdEro = request.getRequestDispatcher("/_01_register/searchLandError.jsp");
		String num = request.getParameter("numberr");
		if (num == null || num.trim().length() == 0) {
			errorMessage.add("必須輸入數字");
			rdEro.forward(request, response);
		} else {
			try {
				Integer ing = Integer.valueOf(num);
				HouseDAO daoCheck = new HouseDAO();
				HouseBean beanCheck = daoCheck.findBynumber(ing);
				if (beanCheck != null) {
					request.setAttribute("housebean", beanCheck);
					RequestDispatcher rd = request.getRequestDispatcher("/_01_register/searchLandSuccess.jsp");
					rd.forward(request, response);
				}
				else {
					errorMessage.add("查無此資料");
					rdEro.forward(request, response);
					return;
				}
			} catch (NumberFormatException e) {
				errorMessage.add("格式錯誤");
				rdEro.forward(request, response);
				return;
			} catch (SQLException e) {
				errorMessage.add("資料庫存取錯誤:" + e.getMessage());
				rdEro.forward(request, response);
			}
		}
	}
}
