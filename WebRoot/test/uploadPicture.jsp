<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>上传图片</title>  
</head>  
<body>  
    <form action="http://47.93.190.186:8080/uploadPicutre.do" method="post" enctype="multipart/form-data">  
        选择文件:<input type="file" name="image" width="120px">  
        <input type="submit" value="上传">  
    </form>  
    <hr>  
</body>  
</html>  