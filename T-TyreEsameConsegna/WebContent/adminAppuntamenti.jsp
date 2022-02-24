
    
<%
    	Collection<?> appuntamento = (Collection<?>) request.getAttribute("appuntamento");
    %>

<html >
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,beanAgenda.*,controlAccount.*,daoAccount.*"%>
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

	
	<h2 class="med-text">Filtra Per Data !</h2>
	
	<form id="filtra" name="prenotazione" action="AdminAppuntamenti" method="post">
		
		
		<input type="date" name="myDate" >
		
		
	
		<div id="prenota" style="display: none;">

			<input id="prenota" type="submit" value="Filtra">

	</div>
				
	
		
	</form>
	
	
	<div id="bottone" >
		<button onclick="formatoDataCorretto()">Verifica Data</button>
</div>
	<p id="demo"></p>

	

<table>

	<% 
			if (appuntamento != null  && appuntamento.size() != 0   ) {
				
				%>

  <tr>
    <th>Data</th>
    <th>Ora</th>
    <th></th>
  </tr>
  
  	<% 
				Iterator<?> it = appuntamento.iterator();
				while (it.hasNext()) {
					AppuntamentoBean app= (AppuntamentoBean)it.next();
				
		%>
  
  
  <tr>
    <td><%=app.getData() %></td>
    <td><%=app.getOra() %></td>
    <td> <a class="link" href="AdminDettagliAppuntamenti?action=get&id=<%=app.getId()%>">Dettagli Appuntamento</a>	</td>
    
    <%} %>
  </tr>
  
</table>

<%  } 
			
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
	
	function formatoDataCorretto() {
		
		var dataCheck= false;
		
		var data = document.prenotazione.myDate.value;
		

		//Data Inserita
		var giorno = data.substr(8, 2);
		var mese = data.substr(5, 2);
		var anno = data.substr(0, 4);

		var dataInserita = new Date(anno + '/' + mese + '/' + giorno);
	
		
		
		               
		
		var espressione = new RegExp(
				/^(?:(?=[02468][048]00|[13579][26]00|\d{2}0[48]|\d{2}[2468][048]|\d{2}[13579][26])\d{4})-(?:(?:01|03|05|07|08|10|12)-(?:[0-2]\d|3[0-1])|(?:04|06|09|11)-(?:[0-2]\d|30)|02-[0-2]\d)|(?:(?![02468][048]00|[13579][26]00|\d{2}0[48]|\d{2}[2468][048]|\d{2}[13579][26])\d{4})-(?:(?:01|03|05|07|08|10|12)-(?:[0-2]\d|3[0-1])|(?:04|06|09|11)-(?:[0-2]\d|30)|02-(?:[0-1]\d|2[0-8]))$/);
		
		
		if (data != ""){
			document.getElementById("demo").innerHTML = "";
			dataCheck=true;
		}

		if (data == ''){
			document.getElementById("demo").innerHTML = "Inserisci la Data !";
			dataCheck=false;	
			
			
		}
		else if ( espressione.test(data) == false ) {
			document.getElementById("demo").innerHTML = "Formato Data Non Corretto!";
			dataCheck=false;
		}
		
		if(dataCheck ){
			
			document.getElementById("prenota").style.display = "block";
			
			document.getElementById("bottone").style.display = "none";
			
		}

		

	}

	
	
</script>
