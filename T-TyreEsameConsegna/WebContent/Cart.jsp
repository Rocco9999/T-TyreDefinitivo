<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%


	Collection<?> cartproducts = (Collection<?>) request.getAttribute("cartproducts");

	Collection<?> products = (Collection<?>) request.getAttribute("products");

%>
 
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,beanAccount.*,controlAccount.*,daoAccount.*,beanOrdine.*,beanProdotto.*"%>
<head>
  <meta charset="UTF-8">
 
  <title>Carrello</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.min.css" integrity="sha512-BiFZ6oflftBIwm6lYCQtQ5DIRQ6tm02svznor2GYQOfAlT3pnVJ10xCrU3XuXnUrWQ4EG8GKxntXnYEdKY0Ugg==" crossorigin="anonymous" />
</head>




<%@include file="/Header.jsp" %>

	
	
		<% 
			if (cartproducts != null  && cartproducts.size() != 0   ) {
				if(products != null  && products.size() != 0  ){
				%>
				<!-- VISUALIZZAZIONE DEI PRODOTTI -->
			<div class="grid"><h2 class="med-text">Carrello</h2> </div>
		
			<div class="grid"><table>
		
			 <tr>
		    <th></th>
			<th><p>Prodotto</p></th>
			<th><p>Costo unitario</p></th>
			<th><p>Costo totale</p></th>
			<th><p>Quantità</p></th>
			<th></th>
			</tr>
				<% 
				Iterator<?> it = cartproducts.iterator();
				Iterator<?> it1 = products.iterator();
				while (it.hasNext()) {
					
					CartBean beancart= (CartBean)it.next();
					ProductBean product1= (ProductBean)it1.next();

				
		%>
		
		
		    
		  
			
		
		<tr>
		
			<td>
			
			
			<%
				if(product1.getPhoto().equals("Giallo")){
		
		%>
		
		   <img src="src/accessori4.jpg" width="80px" id="immagine">
		   
		   <%} %>
		   
		   <%
				if(product1.getPhoto().equals("Rosso")){
		
		%>
		
		   <img src="src/accessori4.jpg" width="80px" id="immagine">
		   
		   <%} %>
		   
		   <%
				if(product1.getPhoto().equals("Verde")){
		
		%>
		
		   <img src="src/accessori4.jpg" width="80px" id="immagine">
		   
		   <%} %>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			</td>
			<td><%=product1.getName()%></td>
			<td><%=beancart.getPrezzo_unitario()%>0€</td>
			<td><%=beancart.getPrezzo_totale()%>0€</td>
			
			<td><%=beancart.getQuantita()%></td>
			<td> <a class="link" href="CartS?action=deleteC&id=<%=product1.getCode()%>">Cancella</a></td>
			
			
			<%} %>
		</tr>
			
		</table>
	</div>
	
	
	
	<div class="grid">
	<div class="col">
	<div class="button mt-2"><a href="./Prenotazione">Prenota Sostituzione </a></div>
	<div class="button mt-2"><a href="CartS?action=deleteAll">Svuota Carrello</a></div>
	</div>
	<div class="col">
	</div>
	</div>
	<%  } 
			}
			else{
	%>
	
		<div class="grid"><h2 class="med-text">Non ci sono prodotti nel carrello</h2> </div>
	
	<%
			}
	%>
			


<%@include file="/Footer.jsp" %>