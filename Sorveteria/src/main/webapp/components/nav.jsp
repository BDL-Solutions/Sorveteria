<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    if (session.getAttribute("name") == null) {
        //session.setAttribute("name", "");
        // You can also redirect to login.jsp if needed
        // response.sendRedirect("login.jsp");
    }
%>
   
 

    <div class="site-navbar bg-white py-2">

      <div class="search-wrap">
        <div class="container">
          <a href=".WEB-INF/index.jsp"" class="search-close js-search-close"><span class="icon-close2"></span></a>
          <form action="#" method="post">
            <input type="text" class="form-control" placeholder="Search keyword and hit enter...">
          </form>  
        </div>
      </div>

      <div class="container">
        <div class="d-flex align-items-center justify-content-between">
          <div class="logo">
            <div class="site-logo">
              <a href="index.jsp" class="js-logo-clone">Sorveteria BDL</a>
            </div>
          </div>
          <div class="main-nav d-none d-lg-block">
            <nav class="site-navigation text-right text-md-center" role="navigation">
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class="has-children active">
                
                
               
              </ul>
            </nav>
          </div>
          <div class="icons">          
          <a <% if (session.getAttribute("name") == null) { %>style="display: none;"<% } %> class=" py-3 px-0 px-lg-3 rounded" href="logout"><%= session.getAttribute("name") %></a>      
            <a href="login.jsp" class="icons-btn d-inline-block"><span class="icon-heart-o"></span></a>
            <a href="cart" class="icons-btn d-inline-block bag">
              <span class="icon-shopping-bag"></span>
              <span class="number quatntidade de coisas no carrinho">3</span> <!-- Colocar a quantidade de pedidos do BD -->
            </a>
          </div>
        </div>
      </div>
    </div>
    
    
    
    
    
    
    
    
    
    

    