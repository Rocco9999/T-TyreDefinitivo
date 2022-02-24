<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
    	Collection<?> appuntamentoUtente = (Collection<?>) request.getAttribute("dettagliappuntamentoUtente");

    	Collection<?> appuntamentoComposizione = (Collection<?>) request.getAttribute("dettagliappuntamentoComposizione");
    	
    	Collection<?> appuntamentoProduct = (Collection<?>) request.getAttribute("dettagliappuntamentoProduct");

    	int cod_ordine = (int) request.getAttribute("cod_ordine");
    %>

<html >
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,beanAccount.*,controlAccount.*,daoAccount.*,beanOrdine.*,beanProdotto.*"%>
<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="admin/Adminstyle.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.min.css" integrity="sha512-BiFZ6oflftBIwm6lYCQtQ5DIRQ6tm02svznor2GYQOfAlT3pnVJ10xCrU3XuXnUrWQ4EG8GKxntXnYEdKY0Ugg==" crossorigin="anonymous" />
  <script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>
  
  <style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
 
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
  
  
  
</head>
<body>
<jsp:useBean id="UtenteBean" class=" beanAccount.UtenteBean" scope="session"/>
<%
	
	String user = null;
	String type = null;
	if(session.getAttribute("user")== null){
		String redirectedPage = "/Home";
		response.sendRedirect(request.getContextPath() + redirectedPage);
%>
	
<%	
	
	}
	else {
	type = (String)session.getAttribute("type");
	
	
	    
	if(type.equals("ADMFILIALE")){%> 
		<%@include file="/HeaderAdminFiliale.jsp" %>

		<h2 class="med-text">Elenco Appuntamenti, Lavora !</h2>

<table>

	<% 
			if (appuntamentoUtente != null  && appuntamentoUtente.size() != 0   ) {
				if (appuntamentoComposizione != null  && appuntamentoComposizione.size() != 0   ) {
					if (appuntamentoProduct != null  && appuntamentoProduct.size() != 0   ) {
				%>
		


  <tr>
    <th>Nome</th>
    <th>Cognome</th>
    
    
    <th>Foto</th>
    <th>Nome</th>
    <th>Categoria</th>
    <th>Descrizione</th>
    
    
    <th>Prezzo Unitario</th>
     <th>Quantita</th>
      <th>Prezzo Totale</th>
    
  </tr>
   
  	<% 
				Iterator<?> it = appuntamentoUtente.iterator();
				Iterator<?> it1 = appuntamentoComposizione.iterator();
				Iterator<?> it2 = appuntamentoProduct.iterator();
				
				while (it.hasNext()) {
					UtenteBean app= (UtenteBean)it.next();
					ComposizioneBean app1= (ComposizioneBean) it1.next();
					ProductBean app2= (ProductBean) it2.next();
					
		%>
  
  
  <tr>
    <td><%=app.getNome()%></td>
    <td><%=app.getCognome()%></td>
    
    
    
     <td><div  id="Immagine"><%if(app2.getPhoto()!=null) {
				String img =app2.getPhoto(); %>
			<img src="src/<%=img %>" height="100px" />
			<%}  else { %>
			<img src="<%=request.getContextPath()%>/images/unnamed1.jpg" height="300px"/>
			<%} %>
			
        </div></td>
     
     
     
     
     <td><%=app2.getName()%></td>
     <td><%=app2.getCategory()%></td>
     <td><%=app2.getDescription()%></td>
    
    
   
   <td><%=app1.getPrezzo_unitario()%></td>
   <td><%=app1.getQuantita()%></td>
   <td><%=app1.getPrezzo_totale()%></td>
    
    <%} %>
  </tr>
  
</table>


<form name="esito" action="DettagliOrdine" method="post">
<p>Inserisci Esito Della Sostituzione</p>
		
  		<label><input type="radio" name="sesso" value="Sostituzione riuscita"/>Sostituzione Effettuata</label>
		<label><input type="radio" name="sesso" value="Sostituzione Non riuscita"/>Sostituzione Non Effettuata</label>
		
		<input type="text" style="display: none;" name="sessi" value=<%=cod_ordine%>>
		
		
			<div id="prenota" style="display: none;">
			<input id="scelta" type="submit" value="Invia" >
			</div>
</form>
		
		
		
<p id="demo3"></p>

<div id="disponibilita" >
<button onclick="validaCampi()">Invia</button>
</div>






<%  } }
			}
			else{
	%>
	
		<div class="grid"><h2 class="med-text">Non ci sono appuntamenti</h2> </div>
	
	<%
			}
	%>

	
      <!--  <h1>Non sei un amministratore!</h1>-->
     <%} else response.sendRedirect("./login.jsp");%>
<%}%>



</body>
</html>
<script>
	
	function validaCampi() {
		
		
		var payCheck=false;
		
		

		var sesso = document.esito.sesso.value;
		
		
		
		
		
		if(sesso !=''){
			
			document.getElementById("demo3").innerHTML = "";
			payCheck=true;	
		}
		else
			document.getElementById("demo3").innerHTML = "Inserisci l'esito !";
			
		
		
		if(payCheck)
		{
			document.getElementById("prenota").style.display = "block";
			document.getElementById("disponibilita").style.display = "none";
		}
		

	}


	
</script>