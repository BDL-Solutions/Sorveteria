<%@page import="br.com.DTO.UserDTO"%>
<%@page import="br.com.DAO.UserDAO"%>
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
    // Obtém os parâmetros do formulário
    String nomeUsuario = request.getParameter("nome");
    String emailUsuario = request.getParameter("email");

    // Cria um objeto UserDTO e configura o nome do usuário
    UserDTO objUserDTO = new UserDTO();
    objUserDTO.setNome_user(nomeUsuario);
    objUserDTO.setEmail_user(emailUsuario);

    // Cria um objeto UserDAO e cadastra o usuário
    UserDAO objUserDAO = new UserDAO();
    objUserDAO.CadastrarUser(objUserDTO);

    // Imprime uma mensagem de sucesso no console
    System.out.println("Sucesso: Usuário cadastrado com sucesso.");
} catch (Exception e) {
    // Trata a exceção, você pode imprimir ou logar a exceção para diagnóstico
    e.printStackTrace();
    // Também pode redirecionar para uma página de erro, se necessário
    // response.sendRedirect("paginaDeErro.jsp");
}
%>


 

</body>
</html>
