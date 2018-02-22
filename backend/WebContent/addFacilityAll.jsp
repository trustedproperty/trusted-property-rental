<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>DreamSpace - 场地短租平台(批量添加设施)</title>
	<link rel="shortcut icon" type="image/x-icon" href="images\www.ico.la_2e3d664ab1e4a4e178ff8a7ce076af00_128X128.ico" media="screen" />	
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/jquery-form.js"></script>
</head>

<body>
	<form action="" method="post"  id="myform">
		设施名称：<input type="text" name="facilityName" id="facilityName">	
		<input type="button" value="添加" id="add">	
	</form>	
	<script type="text/javascript">
		
		$("#add").click(function(){
			$.ajax({
				url:"facilityInfo/insertFacility.html",
				data:$("#myform").serialize(),
				type:"POST",
	            dataType:"json", 
	            success:function (data) {
	            	if(data.message==true){
	            		$("#facilityName").val("");
	            		alert("添加成功");
	            	}else{
	            		alert("添加失败");
	            	}
	            }
			});
		});
	</script>
</body>

</html>