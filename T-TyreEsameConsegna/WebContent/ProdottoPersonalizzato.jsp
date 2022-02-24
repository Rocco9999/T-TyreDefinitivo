<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	
	
	
	ProductBean codice_prodotto = (ProductBean) request.getAttribute("codice_prodotto");
	
	ProductBean bean = (ProductBean) request.getAttribute("product");


%>

<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,beanAccount.*,controlAccount.*,daoAccount.*,beanOrdine.*,beanProdotto.*"%>
<head>
  
  <title>Prodotto Personalizzato</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.min.css" integrity="sha512-BiFZ6oflftBIwm6lYCQtQ5DIRQ6tm02svznor2GYQOfAlT3pnVJ10xCrU3XuXnUrWQ4EG8GKxntXnYEdKY0Ugg==" crossorigin="anonymous" />
 	
  
 
</head>
<body>




      <%@include file="/Header.jsp" %>
	
	
     

	
		
	
	<%
		if (bean != null) {
	%>
	
		<div class="grid">
		
		<div class="col" id="immagineScelta">
		<h2>Questo è il tuo prodotto personalizzato</h2>
		<%
				if(bean.getPhoto().equals("Giallo")){
		
		%>
		
		   <img src="src/accessori4.jpg" width="500px" id="immagine">
		   
		   <%} %>
		   
		   <%
				if(bean.getPhoto().equals("Rosso")){
		
		%>
		
		   <img src="src/accessori4.jpg" width="500px" id="immagine">
		   
		   <%} %>
		   
		   <%
				if(bean.getPhoto().equals("Verde")){
		
		%>
		
		   <img src="src/accessori4.jpg" width="500px" id="immagine">
		   
		   <%} %>
		</div>
		
		<div class="col">
			<div class="mt-1"></div>
			<h1 class="big-text"><%=bean.getName()%></h1>
			<p class="small-text"><%=bean.getDescription()%></p>
			
			<div class="quantity">
			<select class="quantity-option" id="quantity">
			 <option value="1">1</option>
			 <option value="2">2</option>
			 <option value="4">4</option>
			
			</select>
			</div>
			<p class="med-text">€ <%=bean.getPrice()%>0</p>
			
			<% if(session.getAttribute("user")== null)
				{
			%>	
				<button class="button" onclick="redirectUrl()">Aggiungi al carrello</button>
			
			<%
				}else {
			%>
			
			<button class="button" onclick="setQuant()">Aggiungi al carrello</button>
		<% 
			}%>
			
			
	
			
			</div>	
		</div>

	

	

	<%@include file="/Footer.jsp" %>
  <script type="text/javascript">
    function setQuant(){
    	var selectDaVerificare = document.getElementById("quantity");
    	var indiceSelezionato = selectDaVerificare.selectedIndex;
    	var valoreSelezionato = selectDaVerificare.options[indiceSelezionato];
    	
    	var valoreOpzione = valoreSelezionato.value;
    	
    	
    	var url = "CartS?action=addC&id=<%=codice_prodotto.getCode()%>&quantity=";
    	
    	var urlCompleto = url+valoreOpzione;
    	
    	
    	window.open(urlCompleto,'_self');
    	
    }
    
    
    function redirectUrl(){
    	
    	var url=request.getContextPath(); 
    	window.open(url+"/login.jsp",'_self');
    	
    }
    
 

    </script>
		<%
		}
	%>

</body>

</html>
