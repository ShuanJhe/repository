<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新土地資料</title>
</head> 

<body onload="javascript:document.insertMemberFormA.mId.focus();" >
<center>  
<form name="insertMemberFormA" action="upadte2" method="POST">
<input type="hidden" name="sea" value="${searchNum}"/>
<table border="1" >
<thead>
<tr bgcolor='#99BBFF' ><th height="60" colspan="2" align="center">更新  土地號碼: ${searchNum}資料</th></tr>
</thead>
<tbody >

<tr bgcolor='#99BBFF' >
    <td width="220" height="40">房地號碼:</td>
    <td width="600" height="40" align="left" >
    <input id='num' style="text-align:left" name="land" value="${param.nubber}" type="text" size="14">
    <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.lA}</div>
    </td>
</tr>


<tr bgcolor='#99BBFF' >
    <td width="220" height="40">交易標的:</td>
    <td width="600" height="40" align="left" >
    <input id='num' style="text-align:left" name="land" value="${param.land}" type="text" size="14">
    <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.lA}</div>
    </td>
</tr>

<tr bgcolor='#99BBFF' >
    <td width="220" height="40">土地區段位置或建物區門牌 :</td>
    <td width="600" height="40" align="left" >
         <input id='num' style="text-align:left" name="addres" type="text" size="14" value="${param.addres}">
     <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.aD}</div>
    </td>
</tr>

<tr bgcolor='#99BBFF' >
    <td width="220" height="40">土地移轉總面積平方公尺:</td>
    <td width="600" height="40" align="left" >
         <input name="house_area" type="text" size="20" value="${param.house_area}">
         <font color='blue' size="-1">&nbsp;&nbsp;輸入含有小數點數字(平方公尺)</font>
         <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.hOA}</div>
    </td>
</tr>
<tr bgcolor='#99BBFF' >
    <td width="220" height="40">都市土地使用分區:</td>
    <td width="600" height="40" align="left" >
         <input name="city_district" type="text" size="20" value="${param.city_district}">
         <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.cI}</div>
    </td>
</tr>
<tr bgcolor='#99BBFF' >
    <td width="220" height="40">交易年月:</td>
    <td width="600" height="40" align="left" >
         <input name="build_date" type="text" size="14" value="${param.build_date}" >
         <font color='blue' size="-1">&nbsp;&nbsp;格式為yyyy/MM/dd</font>
         <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.bI}</div>
    </td>
</tr>
<tr bgcolor='#99BBFF' >
    <td width="220" height="40">總樓層數:</td>
    <td width="600" height="40" align="left" >
         <input name="house_floor" type="text" size="14" value="${param.house_floor}">
            <font color='blue' size="-1">&nbsp;&nbsp;(輸入數字)</font>
         <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.hOF}</div>
    </td>
</tr>
<tr bgcolor='#99BBFF' >
    <td width="220" height="40">建物型態:</td>
    <td width="600" height="40" align="left" >
         <input name="house_type" type="text" size="14" value="${param.house_type}">
         <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.hOT}</div>
    </td>
</tr>
<tr bgcolor='#99BBFF' >
    <td width="220" height="40">主要建材:</td>
    <td width="600" height="40" align="left" >
         <input name="house_bone" type="text" size="14" value="${param.house_bone}">
         <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.hOB}</div>
    </td>
</tr>
<tr bgcolor='#99BBFF' >
    <td width="220" height="40">建築完成年月:</td>
    <td width="600" height="40" align="left" >
         <input name="finish_date" type="text" size="14" value="${param.finish_date}">
         <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.fI}</div>
         <font color='blue' size="-1">&nbsp;&nbsp;格式為yyyy/MM/dd</font>
    </td>
</tr>
<tr bgcolor='#99BBFF' >
    <td width="220" height="40">編號:</td>
    <td width="600" height="40" align="left" >
         <input name="house_number" type="text" size="14" value="${param.house_number}">
         <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.hON}</div>
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