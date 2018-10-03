<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>文件上传下载</title>  
</head>  
<body>  
    <form action="http://localhost:8080/updateVoteBook.do" method="post" enctype="multipart/form-data">  
   		<input id="name" name="bookName" value="重构改善既有代码的设计">     
   		<input id="author" name="author" value="lunus">     
   		<input id="pubHouse" name="pubHouse" value="机械出版社">     
   		<input id="pubHouse" name="voteBookId" value="1">     
   		<input id="pubHouse" name="votes" value="0">     
   		<input id="voteReason" name="voteReason" value="这本书通俗易懂，很好">     
        选择文件:<input type="file" name="image" width="120px">  
        <input type="submit" value="上传">  
    </form>  
    <hr>  
    <form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">  
        <input type="submit" value="下载">  
    </form>  
</body>  
</html>  