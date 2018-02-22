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
	<title>DreamSpace - 场地短租平台</title>
	<link rel="shortcut icon" type="image/x-icon" href="images\www.ico.la_2e3d664ab1e4a4e178ff8a7ce076af00_128X128.ico" media="screen" />	
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/jquery-form.js"></script>
</head>

<body>
	<!-- <form action="space/sendPhoto.html" method="post" enctype="multipart/form-data" id="myform">	
		<input type="file" name="file" id="file">
		<input type="text" name="newFile">		
		<input type="hidden" name="spacePhoto" id="spacePhoto">
	</form>	 -->
	<form action="userInfo/sendUserImg.html" method="post" enctype="multipart/form-data" id="myform">	
		<input type="file" name="file" id="file">
		<input type="hidden" name="spacePhoto" id="spacePhoto">
	</form>	
	<script type="text/javascript">
		
		$("#file").change(function(){
			var image = $(this).val();
			if(image==""){
				alert("请选择图片");
			}else{
				//Ajax 上传图片，然后实时显示
				var options = {
		  			type:"POST",
		            dataType:"json", 
		            beforeSubmit : function() {  
		            },  
		            success:function (data) {
		            	$("#spacePhoto").val(data.fileName);
		            	alert($("#spacePhoto").val());
		            },  
		            error : function(result) { 
						alert("上传失败!");
		            } 
				}
				$("#myform").ajaxSubmit(options);
			}
		});
	</script>
</body>

</html>