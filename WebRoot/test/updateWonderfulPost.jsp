<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>文件上传下载</title>  
</head>  
<body>  
    <form action="http://localhost:8080/updateWonderfulPost.do" method="post" >  
   		<input id="name" name="wonderfulPostId" value="2">     
   		<input id="name" name="postContent" value="java编程思想不怎么样">     
   		<input id="author" name="postBookName" value="java编程思想">     
   		<input id="pubHouse" name="postAuthor" value="蔡康华">     
        <input type="submit" value="添加精彩书评">  
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>  
</body>  
</html>  