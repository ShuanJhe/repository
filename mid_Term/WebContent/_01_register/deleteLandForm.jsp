<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lab04_02 新增土地</title>
</head> 

<body onload="javascript:document.insertMemberFormA.mId.focus();" >
<center>  
<form name="deletetMemberFormA" action="deleTe" method="POST">
<table border="1" >
<thead>
<tr bgcolor='#99BBFF' ><th height="60" colspan="2" align="center">刪除土地資料</th></tr>
</thead>
<tbody >
<tr bgcolor='#99BBFF' >
    <td width="220" height="40">土地號碼 :</td>
    <td width="600" height="40" align="left" >
         <input name="NUM" type="text" size="20" value="${param.NUM}">
         <font color='blue' size="-1">&nbsp;&nbsp;輸入數字</font>
    </td>
</tr>


<tr bgcolor='#99BBFF' >
    <td height="50" colspan="2" align="center">
       <input type="submit" value="送出" >
    </td>
</tr>

</tbody>
</table>
</form>
</center>
</body>
</html>