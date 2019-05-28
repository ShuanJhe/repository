﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lab04_02</title>
</head>
<body>
	<H1>土地刪除失敗</H1>
	<!-- 如果識別字串 ErrorMsg 所對應的屬性物件不是空的 -->
	<c:if test="${not empty ErrorMsgUPD1}">
		<font color='red'>
		請修改下列錯誤:
			
				<!-- 將識別字串 ErrorMsg 所對應的屬性物件之內的物件『依序取出』， 放入變數 aMsg中 -->
				<c:forEach var="aMsg" items="${ErrorMsgUPD1}">
					<!-- 將變數 aMsg 的內含值顯示出來 -->
					<li>${aMsg}</li>
				</c:forEach>
			
		</font>
	</c:if>
</body>
</html>
