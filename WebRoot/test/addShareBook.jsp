<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>文件上传下载</title>  
</head>  
<body>  
    <form action="http://47.93.190.186:8080/addShareBook.do" method="post" enctype="multipart/form-data">  
   		<input id="name" name="name" value="helloWorld">     
   		<input id="author" name="author" value="yawei">     
   		<input id="pubHouse" name="pubHouse" value="szu">     
   		<input id="isbn" name="isbn" value="34567">     
   		<input id="shareId" name="shareId" value="350">     
        选择文件:<input type="file" name="image" width="120px">  
        <input type="submit" value="上传">  
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>  
</body>  
</html>  