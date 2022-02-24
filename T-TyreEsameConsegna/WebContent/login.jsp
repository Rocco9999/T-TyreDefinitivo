<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Collection<?> products = (Collection<?>) request.getAttribute("products");
	
	
	
	ProductBean product = (ProductBean) request.getAttribute("product");
%>
 

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,beanAccount.*,controlAccount.*,daoAccount.*,beanOrdine.*,beanProdotto.*"%>
<head>
  <title>Accedi</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="./admin/style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
<jsp:useBean id="UtenteBean" class="beanAccount.UtenteBean" scope="session"/>
</head>
<body>
    <div class="header">
      <div class="logo"><a href="index.jsp"><img src="./admin/logo.png" width=150px></a></div>
      <ul class="menu">
        <li><a href="${pageContext.request.contextPath}/Home">Home</a></li>
        
        <li><a href="${pageContext.request.contextPath}/ProdottiControl">Prodotti</a></li>
        <li><a href="">Chi Siamo</a></li>
      </ul>
      
      <div class="cta"><div style="padding-right: 10px; padding-top: 5px;"><a href="CartS"><img src="./admin/shopping-cart1.png" width="30px"></a></div></div>
      <%
	
	String user = null;
	if(session.getAttribute("user")== null){
%>
	
<%	
	}else { %><div class="cta">
        <h5 class="tred">CIAO, ${user}<%UtenteBean.getNome(); %><a class="logout"  href="${pageContext.request.contextPath}/logout">Logout</a></h5>
        
        
      </div>
      <%} %>
      <div class="hamburger">
          <span></span>
          <span></span>
          <span></span>
      </div>
    </div> 

	<div class="hero reveal">
			<div class="login">
				<h1 class="med-text tw">Accedi</h1>
				<form action="${pageContext.request.contextPath}/LLogin" method="POST" >
					<input type="text" name="username" placeholder="Inserisci user">
					<input type="password" name="password" placeholder="Inserisci password">
					<input type="submit" value="Entra">
				</form>
				
				<%if(session.getAttribute("user")== null){
					%> 
				<p style="color: #fff;">Non sei registrato? <a href="./RegistrazioneForm" style="color: #d31d40;">Registrati</a></p>
				
				
				<%
				}%>
				
			</div>
	</div>


</body>
</html>