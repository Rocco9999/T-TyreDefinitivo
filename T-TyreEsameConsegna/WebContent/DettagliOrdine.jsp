<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	Collection<?> products = (Collection<?>) request.getAttribute("products");
	Collection<?> products1 = (Collection<?>) request.getAttribute("products1");
	
	Collection<?> appuntamento = (Collection<?>) request.getAttribute("appuntamento");
	
	String esito = (String) request.getAttribute("esito");
	
%>
 
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,beanAccount.*,controlAccount.*,daoAccount.*,beanOrdine.*,beanProdotto.*"%>
<head>
  <title>Riepilogo ordine</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.min.css" integrity="sha512-BiFZ6oflftBIwm6lYCQtQ5DIRQ6tm02svznor2GYQOfAlT3pnVJ10xCrU3XuXnUrWQ4EG8GKxntXnYEdKY0Ugg==" crossorigin="anonymous" />
</head>


<%@include file="/Header.jsp" %>
     
    <div class="grid"> <h2 class="med-text">Dettagli Ordine</h2></div>
     
    <div class="grid"><table >
    
		<tr>
		
			<th>	<h5>Immagine</h5>	</th>
			<th>	<h5>Prodotto</h5>	</th>
			<th>	<h5>Prezzo</h5>		</th>
			<th>	<h5>Quantita</h5>	</th>
			<th>	<h5>Totale</h5>		</th>
			<th>	<h5>Esito</h5>		</th>  
			
			
		</tr>
		
		
		
		<!-- VISUALIZZAZIONE DEI PRODOTTI -->
		<% float somma=0;
			if (products != null  && products.size() != 0   ) {
				if (products1 != null  && products1.size() != 0   ) {
				Iterator<?> it = products.iterator();
				Iterator<?> it1 = products1.iterator();
				
				while (it.hasNext()) {
					ProductBean beanProdotto = (ProductBean) it.next();
					ComposizioneBean beanOrdine = (ComposizioneBean) it1.next();
					somma+=beanOrdine.getPrezzo_totale();
				
		%>
		
		<tr>
			<td><img src="src/<%=beanProdotto.getPhoto()%>" width="100px"></td>
			<td><%=beanProdotto.getName()%></td>
			<td><%=beanOrdine.getPrezzo_unitario()%>0€</td>
			<td><%=beanOrdine.getQuantita()%></td>
			<td><%=beanOrdine.getPrezzo_totale()%>0€</td>
			
			
			<td><%=esito%></td>
			<td></td>
		</tr>
			
			
		<tr>
			<td colspan="5"></td>
			<td><p>Totale <span><%=somma%>0 €</span></p></td>
		</tr>
	</table></div>
	<%
				}
				
			} 
				}
		
		%>
	
	<!-- Appuntamento -->
	<div class="grid"> <h2 class="med-text">Dettagli Appuntamento</h2></div>
     
	 <div class="grid"><table >
	
		<tr>
			<th>	<h5>Indirizzo</h5>	</th>
			<th>	<h5>Data</h5>	</th>
			<th>	<h5>Ora</h5>		</th>
		</tr>
		
		<!-- VISUALIZZAZIONE DEI PRODOTTI -->
		<% 
			if (appuntamento != null  && appuntamento.size() != 0  ) {
			 	Iterator<?> it2 = appuntamento.iterator();
				while (it2.hasNext()) {
					AppuntamentoBean beanapp= (AppuntamentoBean) it2.next();
			
		%>
		
		<tr>
			
			<td><%=beanapp.getIndirizzo()%></td>
			<td><%=beanapp.getData()%></td>
			<td><%=beanapp.getOra()%></td>
		</tr>
	
		</table></div>
	
	
	
		<%
			}
		} 
		else {
		
		%>
		<table>
		<tr>
			<td colspan="6">No Order available</td>
		</tr>
		</table>
		<%
			}	
		%>
		    
<%@include file="/Footer.jsp" %>

