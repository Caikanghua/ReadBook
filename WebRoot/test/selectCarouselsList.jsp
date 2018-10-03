<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head> 
<script src="http://www.w3school.com.cn/jquery/jquery.js" type="text/javascript"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>文件上传下载</title>  
</head>  
<body>  
 <!--    <form action="http://localhost:8080/selectCarousels.do" method="post">  
   		<input id="name" type="text" name="carouselsList[0]" value="2">     
   		<input id="jj" type="text" name="carouselsList[1]" value="3">     
        <input type="submit" value="selectCarousel">  
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>   -->
 	<script type="text/javascript">
 			   var deleteNum= [];//定义要传递的数组
				deleteNum.push("1");
				deleteNum.push("2");
				deleteNum.push("3");//向数组中添加元素
				$.ajax({
				    type:"post",
				    url:"http://localhost:8080/selectCarousels.do",
				    data:{carouselsList:deleteNum},
				    traditional: true,//必须指定为true
				    success:function(data){
				        alert(data.message);
				    }
				});
 	</script>
</body>  
</html>  