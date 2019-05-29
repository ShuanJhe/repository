<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script>
function getQueryString(){
	var nUmber = document.getElementById("numberr").value;
	var land = document.getElementById("land").value;
	var addres = document.getElementById("addres").value;
	var house_area = document.getElementById("house_area").value;
	var city_district = document.getElementById("city_district").value;
	var build_date = document.getElementById("build_date").value;
	var house_floor = document.getElementById("house_floor").value;
	var house_type = document.getElementById("house_type").value;
	var house_bone = document.getElementById("house_bone").value;
	var finish_date = document.getElementById("finish_date").value;
	var house_number = document.getElementById("house_number").value;
	

	deleteString= "numberr="+nUmber;
	
	insertString = "land="+land+"&addres="+addres+"&house_area="+house_area+"&city_district="+city_district
	+"&build_date="+build_date+"&build_date="+build_date+"&house_floor="+house_floor+  "&house_type="+house_type
	+"&house_bone="+house_bone+"&finish_date="+finish_date+"&house_number="+house_number
	
	updateString="numberr="+nUmber+"&land="+land+"&addres="+addres+"&house_area="+house_area+"&city_district="+city_district
	+"&build_date="+build_date+"&build_date="+build_date+"&house_floor="+house_floor+  "&house_type="+house_type
	+"&house_bone="+house_bone+"&finish_date="+finish_date+"&house_number="+house_number
}



function search() {
 	getQueryString();
    var xhttpSearch = new XMLHttpRequest();
    xhttpSearch.onreadystatechange = function() {
	if (xhttpSearch.readyState == 4 && xhttpSearch.status == 200) {
		document.getElementById("demo").innerHTML = xhttpSearch.responseText;
            	}
		}
    xhttpSearch.open("POST", "searCh", true);
    xhttpSearch.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhttpSearch.send(deleteString);
}


function deletee() {
 	getQueryString();
    var xhttpDelete = new XMLHttpRequest();
    xhttpDelete.onreadystatechange = function() {
	if (xhttpDelete.readyState == 4 && xhttpDelete.status == 200) {
		document.getElementById("demo").innerHTML = "";
		document.getElementById("demo").innerHTML = xhttpDelete.responseText;
            	}
		}
 	xhttpDelete.open("POST", "deleTe", true);
 	xhttpDelete.setRequestHeader("Content-type","application/x-www-form-urlencoded");
 	xhttpDelete.send(deleteString);
}

function updateCheck(){
	var xhttpUpdateCheckk = new XMLHttpRequest();
	xhttpUpdateCheckk.onreadystatechange = function() {
		if (xhttpUpdateCheckk.readyState == 4 && xhttpUpdateCheckk.status == 200) {
			document.getElementById("check").innerHTML = xhttpUpdateCheckk.responseText;
		}
	}
	xhttpUpdateCheckk.open("GET", "/mid_Term/selectNumber.jsp", true);
	xhttpUpdateCheckk.send();
}
function insertt() {
	   getQueryString();
 	   var xhttpInsert = new XMLHttpRequest();
 	    xhttpInsert.onreadystatechange = function() {
 		if (xhttpInsert.readyState == 4 && xhttpInsert.status == 200) {
 				document.getElementById("fm").innerHTML = xhttpInsert.responseText;
 		}
 			}
 	 	xhttpInsert.open("POST", "inseRt", true);
 	 	xhttpInsert.setRequestHeader("Content-type","application/x-www-form-urlencoded");
 		document.getElementById("demo").innerHTML = "";
 	 	xhttpInsert.send(insertString);
}

function updatee(){
	getQueryString();
	  var xhttpUpdate = new XMLHttpRequest();
	  xhttpUpdate.onreadystatechange = function() {
		if (xhttpUpdate.readyState == 4 && xhttpUpdate.status == 200) {
			document.getElementById("fm").innerHTML = xhttpUpdate.responseText;
			document.getElementById("demo").innerHTML = "";
	            	}
			}
	  xhttpUpdate.open("POST", "upadte2", true);
	  xhttpUpdate.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	  xhttpUpdate.send(updateString);
}

</script>

<style>
    body{
          background-image:url("00.jpg");
    }
    .f1{
      float :left;
      padding: 10px 10px 10px 10px;
      margin: 6ch ;
      border: 1ch soild;
      background-color:#CCDDFF	;
       border-radius: 10px;
    }
    .d1{
    clear:right;
    padding: 10px 10px 300px 10px;
    margin: 10px 10px 100px 10px;
    font-family: 標楷體;
    }
  
.bt{
    border: 3px solid #003C9D;
    border-radius: 10px;
     height:5ch ;
     margin:15px ;
     font-size: 2ch;
   }
    .ta1{
    border-radius: auto;
    }
    td{width:6cm;
      border-bottom: 1px solid gray;
      padding: 15px;
       
    }
    .tdba{
    width:14cm;
    }
</style>
</head>
<body>
<form class="f1" id="fm">
		<table  class="ta1" >
			<thead>
				<tr class="tr1">
					<th height="60" colspan="2" align="center">土地資料</th>
				</tr>
			</thead>
			<tbody>
				<tr >
					<td height="30">號碼:</td>
					<td class="tdba" height="30" align="left">
					<input id='numberr'style="text-align:"  type="text" size="30"    autocomplete="off" autofocus placeholder="00">
						<span  id="check"style="color:#FF0000; font-size:60%;"></span>
<!--                         autocomplete="off" autofocus placeholder="00" -->
                        <button type="button" onclick="updateCheck()">Select</button>
						<span style="color:#FF0000; font-size:60%;">${ErrorMsg.cW}</span>
					</td>
				</tr>
				<tr >
					<td  height="30">交易標的:</td>
					<td  height="30" align="left"><input id='land'
						style="text-align: left" name="land" value="房地(土地+建物)" type="text"
						size="30">
						<span style="color:#FF0000; font-size:60%;">${ErrorMsg.lA}</span>
						</td>
				</tr>
				
				<tr>
					<td  height="40">土地區段位置或建物區門牌 :</td>
					<td  height="30" align="left"><input id='addres'
						style="text-align: left" name="addres" type="text" size="30"
						value="新北市板橋區三民路二段35巷1~30號" >
						<span style="color:#FF0000; font-size:60%;">${ErrorMsg.aD}</span>
						</td>
				</tr>

				<tr >
					<td  height="40">土地移轉總面積平方公尺:</td>
					<td  height="30" align="left">
					<input id="house_area" name="house_area" type="text" size="30" placeholder="00.00">
					<font color='blue' size="-1">&nbsp;&nbsp;輸入含有小數點數字(平方公尺)</font>
					<span style="color:#FF0000; font-size:60%;">${ErrorMsg.hOA}</span>
					</td>
				</tr>
				<tr >
					 <td  height="40">都市土地使用分區:</td>
					<td  height="30" align="left"><input
						id="city_district" name="city_district" type="text" size="30" value="住">
						<span style="color:#FF0000; font-size:60%;">${ErrorMsg.cI}</span>
						</td>
				</tr>
				<tr>
					  <td  height="40">交易年月:</td>
					<td  height="30" align="left"><input
						id="build_date" name="build_date" type="text" size="30" placeholder="2019/05/22"  />
					<font color='blue' size="-1">&nbsp;&nbsp;格式為yyyy/MM/dd</font>
					<span style="color:#FF0000; font-size:60%;">${ErrorMsg.bI}</span>
					</td>
				</tr>
				<tr>
				   <td  height="40">總樓層數:</td>
					<td  height="30" align="left"><input
						id="house_floor" name="house_floor" type="text" size="30" value="21" />
					<font color='blue' size="-1">&nbsp;&nbsp;(輸入數字)</font>
					<span style="color:#FF0000; font-size:60%;">${ErrorMsg.hOF}</span>
					</td>
				</tr>
				<tr >
				 <td  height="40">建物型態:</td>
					<td  height="30" align="left"><input
						id="house_type" name="house_type" type="text" size="30" value="住宅大樓(11層含以上有電梯)" />
						<span style="color:#FF0000; font-size:60%;">${ErrorMsg.hOT}</span>
					</td>
				</tr>
				<tr >
					 <td  height="40">主要建材:</td>
					<td  height="30" align="left"><input
						id="house_bone" name="house_bone" type="text" size="30" value="鋼筋混凝土造" />
						<span style="color:#FF0000; font-size:60%;">${ErrorMsg.hOB}</span>
					</td>
				</tr>
				<tr >
					 <td  height="40">建築完成年月:</td>
					<td  height="30" align="left"><input
						id="finish_date" name="finish_date" type="text" size="30" value="2019/05/23">
					  <font color='blue' size="-1">&nbsp;&nbsp;格式為yyyy/MM/dd</font>
					  <span style="color:#FF0000; font-size:60%;">${ErrorMsg.fI}</span>
					  </td>
				</tr>
				<tr >
					<td  height="40">編號:</td>
					<td  height="30" align="left"><input
						id="house_number" type="text" size="30" value="RPQOMLNKKHOFFAF87CA">
						<span style="color:#FF0000; font-size:60%;">${ErrorMsg.hON}</span>
						</td>
				</tr>
				<tr >
					<td height="50" colspan="2" align="center">
						<button class="bt" type="button" onclick="search()">Search</button>
						<button class="bt" type="button" onclick="deletee()">Delete</button>
						<button class="bt" type="button" onclick="insertt()">Insert</button>
						<button class="bt" type="button" onclick="updatee()">Update</button>
						<button class="bt" type="button" onclick="searchAll()">SearchAll</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<div class="d1" id="demo"></div>
	<script>
	function searchAll() {
	 	getQueryString();
	    var xhttpSearchAll = new XMLHttpRequest();
	    xhttpSearchAll.onreadystatechange = function() {
		if (xhttpSearchAll.readyState == 4 && xhttpSearchAll.status == 200) {
			document.getElementById("demo").innerHTML = xhttpSearchAll.responseText;
	            	}
			}
	    xhttpSearchAll.open("GET", "all", true);
// 	    xhttpSearchAll.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xhttpSearchAll.send();
	}
	</script>
</body>
</html>