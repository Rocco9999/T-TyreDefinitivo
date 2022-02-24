<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<%
	
	Integer quantita =(Integer)request.getAttribute("quantita");
	
	%>


<!DOCTYPE html>
<html lang="it">
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,beanAgenda.*,controlAccount.*,daoAccount.*"%>
<head>
  <title>SPARE PARTS</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
<script src="ricerca.js"></script>

</head>
<body>


    <div class="header">
      <div class="logo"><a href="./Home"><img src="src/logo.png" width=150px></a></div>
      <ul class="menu">
       
        <li><a href="">Home</a></li>
        
       <li><div class="dropdown1">
         <a class="dropbtn1" href="ProdottiControl">Prodotti</a>
             <div class="dropdown-content1">
              <a href="Categoria?action=get&categoria=accessori">Accessori</a>
              <a href="Categoria?action=get&categoria=auto">Pneumatici auto</a>
              <a href="Categoria?action=get&categoria=moto">Pneumatici moto</a>
  			</div>
			</div>
		</li>
		
        <li><a href="">Chi Siamo</a></li>
        
        
            <li>
                <form action="Ricerca" method="post">
                    <input type="text" name="ric" list="ricerca-datalist" placeholder="Ricerca" onkeyup="ricerca(this.value)" value="<c:out value="${param.ric}" />">
                    <datalist id="ricerca-datalist"></datalist>
                </form>
            </li>
        
      </ul>
      
      <% 
         	 String user = null;
			if(session.getAttribute("user")== null){%>
			
				<div class="cta"><div class="numCart"><%=0%></div></div>
			<%}
			
			else {%>
          <!-- MODIFICAREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE cart.totalNumCart() -->  
         		<div class="cta"><div class="numCart"><%=quantita%></div></div>
         <%}
			%>
      
      
      
      
      
      
      
      
      <div class="cta"><div style="padding-right: 10px; padding-top: 5px;"><a href="CartS"><img src="src/shopping-cart1.png" width="30px"></a></div></div>
     
   
      <%
	
	 user = null;
	if(session.getAttribute("user")== null){
%>
	<div class="cta">
        <a href="login.jsp" class="button">Accedi
        </a>
      </div>
<%	
	}else { %>
	 
	 <div class="cta">
		   <div class="dropdown">
            <button onclick="myFunction()" class="dropbtn"><img src="src/user.png" width="30px"></button>
                <div id="myDropdown" class="dropdown-content">
  	            <p>CIAO, ${user}</p>
                <a href="./OrdineUtente">I miei ordini</a>
                <a href="./UtenteForm">I miei dati</a>
                <% String tipo= (String)request.getAttribute("type");
                	
                	if(tipo.equals("adm")){ %>
                		
                	<a href="./admin-page.jsp">Amministratore</a>
                	
                	<% }%>
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
                </div>
           </div>
       
      </div>
      <%} %>
      
      
      
      <div class="hamburger">
          <span></span>
          <span></span>
          <span></span>
      </div>
    </div>


    <div class="hero">
          <div class="hero__content">
            <p class="intro-text">RICAMBI VEICOLI</p>
            <h1 class="big-text">AUTO E MOTO</h1>
            <a href="ProdottiControl" class="button">Vai a prodotti</a>
          </div>
    </div>
    
  <div class="second-grid">
    <div class="grid">
    <div class="col"><h3 class="intro-text">Accessori</h3>
    <p><a href="Categoria?action=get&categoria=accessori" class="button-1">Vai ai prodotti</a></p>
    </div>
    
    <div class="col"><h3 class="intro-text">Pneumatici auto</h3>
    <p><a href="Categoria?action=get&categoria=auto" class="button-2">Vai ai prodotti</a></p>
    </div>
    
    <div class="col"><h3 class="intro-text">Pneumatici moto</h3>
    <p><a href="Categoria?action=get&categoria=moto" class="button-3">Vai ai prodotti</a></p>
    </div>
    </div>
 </div>
 
 
 <div class="grid mt-3">
      <div class="col reveal">
      <h3 class="big-text marc">I nostri <br>marchi</h3>
      </div>
      <div class="col reveal">
          <p class="mt-2">Per i nostri clienti scegliamo e distribuiamo soltanto i ricambi migliori per far si che i veicoli performino al meglio.</p>
      </div>
      </div>
      <!-- MARCHI -->
      
      <div class="grid mt-3">
      
      
      
      <div class="col">
           <img src="src/brembo.png" width= "250px">
      </div>
      <div class="col">
           <img src="src/petronas.png" width= "250px">
      </div>
      <div class="col">
            <img src="src/repsol.png" width= "250px">
      </div>
      
      <div class="col">
            <img src="src/michelin.png" width= "250px">
      </div>
      
      </div>
    
    <div class="mt-3"></div>
 
 
 
<%@include file="/Footer.jsp" %>

    <!-- Jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script>
      $( document ).ready(function() {
        /* Open Panel */
        $( ".hamburger" ).on('click', function() {
          $(".menu").toggleClass("menu--open");
          
          
        });
      });
      
      
      
      /* When the user clicks on the button, 
      toggle between hiding and showing the dropdown content */
      function myFunction() {
        document.getElementById("myDropdown").classList.toggle("show");
      }

      // Close the dropdown if the user clicks outside of it
      window.onclick = function(event) {
        if (!event.target.matches('.dropbtn')) {
          var dropdowns = document.getElementsByClassName("dropdown-content");
          var i;
          for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
              openDropdown.classList.remove('show');
            }
          }
        }
      }
      
      
    </script>
    
</body>



</html>
