<%@page import="br.com.DTO.UserDTO"%>
<%@page import="br.com.DAO.*;"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	try {
		UserDTO objUserDTO = new UserDTO();
		objUserDTO.setNome_user(request.getParameter("nome"));
		
		UserDAO objUserDAO = new UserDAO();
		objUserDAO.CadastrarUser(objUserDTO);
	} catch (Exception e) {
		
	}
	
%>)


 

</body>
</html>
