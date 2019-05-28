<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lab04_02</title>
<style>
 .f1{
      float :left;
      padding: 10px 10px 30px 10px;
      margin: 6ch ;
      border: 1ch soild;
      background-color:#CCDDFF	;
       border-radius: 10px;

    }
    th{
     color: black;
       font-size: 3ch;
    }

     td{
       color: #9900FF;
       font-size: 2ch;
     }
</style>
</head>
<body> 
<%-- <H1>土地 ${housebean.number} 的資料新增成功</H1> --%>
<%-- 號碼: ${housebean.number }<BR> --%>
<%-- 土地: ${housebean.land }<BR> --%>
<%-- 地址: ${housebean.addres}<BR> --%>
<%-- 空間: ${housebean.house_area }<BR> --%>
<%-- 區四: ${housebean.city_district}<BR> --%>
<%-- 建造日期:${housebean.build_date}<BR> --%>
<%-- 樓層: ${housebean.house_floor}<BR> --%>
<%-- 樓型: ${housebean.house_type}<BR> --%>
<%-- 骨架: ${housebean.house_bone}<BR> --%>
<%-- 完工日期:${housebean.finish_date}<BR> --%>
<%-- 編號: ${housebean.house_number}<BR> --%>
<table class="f1" >
<tr><th>土地 ${housebean.number}新增成功</th></tr>
<tr><td>號碼: ${housebean.number }</td></tr>
<tr><td>土地: ${housebean.land }</td></tr>
<tr><td>地址: ${housebean.addres}</td></tr>
<tr><td>空間: ${housebean.house_area }</td></tr>
<tr><td>區四: ${housebean.city_district}<BR>
<tr><td>建造日期:${housebean.build_date}<BR>
<tr><td>樓層: ${housebean.house_floor}<BR>
<tr><td>樓型: ${housebean.house_type}<BR>
<tr><td>骨架: ${housebean.house_bone}<BR>
<tr><td>完工日期:${housebean.finish_date}<BR>
<tr><td>編號: ${housebean.house_number}<BR>
</table>
</body>
</html>