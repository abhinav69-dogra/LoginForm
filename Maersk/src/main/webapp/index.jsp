<% 
 if(session.getAttribute("name")==null){
	 response.sendRedirect("login.jsp"); }
%>

<!DOCTYPE html>
<html lang="en">
<head>
<style>
h1 {
  text-align: center;
}

</style>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Homepage</title>
</head>
<body>
 <h1>This is Homepage</h1>


</body>
</html>