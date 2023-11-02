<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1> fileupload.jsp </h1>
		<form action="./MemberUploadAction.com" method="post" enctype="multipart/form-data">

		파일 : <input type="file" name="file">

		<input type="submit" value="업로드"><br>
	</form>
		
</body>
</html>