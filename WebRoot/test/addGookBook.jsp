<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>文件上传下载</title>  
</head>  
<body>  
    <form action="http://localhost:8080/addGoodBook.do" method="post" enctype="multipart/form-data">  
   		<input id="description" name="title" value="描述第一次">     
   		<input id="pubHouse" name="pubHouse" value="http://www.baidu.com">     
   		<input id="pubHouse" name="description" value="这个百度同学出的一本书">     
        选择文件:<input type="file" name="image" width="120px">  
        <input type="submit" value="上传">  
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>  
</body>  
</html>  