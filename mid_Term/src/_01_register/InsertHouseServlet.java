package _01_register;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inseRt")
public class InsertHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errorMessage = new HashMap<String, String>();
		request.setAttribute("ErrorMsg", errorMessage);
		request.setCharacterEncoding("UTF-8");
		HouseBean ben = new HouseBean();
		boolean bol=true;
		request.setAttribute("che", bol);
		String lAnd = request.getParameter("land");
		if (lAnd == null || lAnd.trim().length() == 0) {
			errorMessage.put("lA", "交易標的必須輸入");
		}else {
			ben.setLand(lAnd);
		}
		
		String aDdres = request.getParameter("addres");
		if (aDdres == null || aDdres.trim().length() == 0) {
			errorMessage.put("aD", "土地區段位置或建物區門牌必須輸入");
		}else {
			ben.setAddres(aDdres);
		}
		
		String hOuse_Area = request.getParameter("house_area");
		if (hOuse_Area == null || hOuse_Area.trim().length() == 0) {
			errorMessage.put("hOA", "土地移轉總面積必須輸入");
		} else {
			try {
				Double dou = Double.valueOf(hOuse_Area);
				ben.setHouse_area(dou);
			} catch (NumberFormatException e) {
				errorMessage.put("hOA", "格式錯誤");
				bol=false;
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				return;
			}
		}
		
		String cIty_District = request.getParameter("city_district");
		if (cIty_District == null || cIty_District.trim().length() == 0) {
			errorMessage.put("cI", "都市土地使用分區必須輸入");
		}else {
			ben.setCity_district(cIty_District);
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String bIild_Date = request.getParameter("build_date");
		if (bIild_Date == null || bIild_Date.trim().length() == 0) {
			errorMessage.put("bI", "交易年月必須輸入");
		}else {
			try {
				format.setLenient(false);
				Date theDate = format.parse(bIild_Date);
				ben.setBuild_date(theDate);
			} catch (ParseException e) {
				errorMessage.put("bI", "日期格式錯誤");
				bol=false;
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);    
				return;
			}
		}
		
		String hOuse_Floor = request.getParameter("house_floor");
		if (hOuse_Floor == null || hOuse_Floor.trim().length() == 0) {
			errorMessage.put("hOF", "總樓層數必須輸入");
		} else {
			try {
				Integer ing = Integer.valueOf(hOuse_Floor);
				ben.setHouse_floor(ing);
			} catch (NumberFormatException e) {
				errorMessage.put("hOF", "格式錯誤");
				bol=false;
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				return;
			}
		}
		
		String hOuse_Type = request.getParameter("house_type");
		if (hOuse_Type == null || hOuse_Type.trim().length() == 0) {
			errorMessage.put("hOT", "建物型態必須輸入");
		}else {
			ben.setHouse_type(hOuse_Type);
		}
		
		String hOuse_Bone = request.getParameter("house_bone");
		if (hOuse_Bone == null || hOuse_Bone.trim().length() == 0) {
			errorMessage.put("hOB", "主要建材必須輸入");
		}else {
			ben.setHouse_bone(hOuse_Bone);
		}
		
		String fInish_Date = request.getParameter("finish_date");
		if (fInish_Date == null || fInish_Date.trim().length() == 0) {
			errorMessage.put("fI", "建築完成年月必須輸入");
		} else {
			try {
				format.setLenient(false);
				Date theDate2 = format.parse(fInish_Date);
				ben.setFinish_date(theDate2);
			} catch (ParseException e) {
				errorMessage.put("fI", "日期格式錯誤");
				bol=false;
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				return;
			}
		}
		
		String hOuse_Number = request.getParameter("house_number");
		if (hOuse_Number == null || hOuse_Number.trim().length() == 0) {
			errorMessage.put("hON", "編號必須輸入");
		}else {
			ben.setHouse_number(hOuse_Number);
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			bol=false;
			return;
		}
		try {
			HouseDAO dao = new HouseDAO();
			request.setAttribute("housebean", ben);
			dao.insert(ben);
//			errorMessage = new HashMap<String, String>();
			bol=true;
			RequestDispatcher rd = request.getRequestDispatcher("/_01_register/InsertLandSuccess.jsp");
			rd.forward(request, response);
			return;
		} 
		catch (SQLException e) {
			if (e.getMessage().indexOf("重複的索引鍵") != -1) {
				errorMessage.put("lAnd", "帳號重複，請重新輸入帳號");
			} else {
				errorMessage.put("exception", "資料庫存取錯誤:" + e.getMessage());
			}
			bol=false;
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
