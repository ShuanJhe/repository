package _01_register;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DateVa")
public class updateCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean passed=false;
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsgUPD1", errorMessage);
		request.setCharacterEncoding("UTF-8");
		HouseDAO dao = new HouseDAO();
//		RequestDispatcher rdSus = request.getRequestDispatcher("/_01_register/updateLandForm2.jsp");
		RequestDispatcher rdEro = request.getRequestDispatcher("/_01_register/updateLandError.jsp");
		String num = request.getParameter("numberr");
		if (num == null || num.trim().length() == 0) {
			errorMessage.add("必須輸入數字");
			rdEro.forward(request, response);
		} else {
			try {
				Integer ing = Integer.valueOf(num);
				HouseBean bean = dao.findBynumber(ing);
				if (bean != null) {	
//					request.setAttribute("searchNum", ing);
//					rdSus.forward(request, response);
					passed=true;
					response.getWriter().print(passed);
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
