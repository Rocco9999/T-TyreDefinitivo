<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	
	
	
	ProductBean product = (ProductBean) request.getAttribute("product");
	

 
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
		if (product != null) {
	%>
	
		<div class="grid">
		
		<div class="col" id="immagineScelta">
		   <img src="src/<%=product.getPhoto()%>" width="500px" id="immagine">
		</div>
		
		<div class="col">
			<div class="mt-1"></div>
			<h1 class="big-text"><%=product.getName()%></h1>
			<p class="small-text"><%=product.getDescription()%></p>
			
			<div class="quantity">
			<select class="quantity-option" id="quantity">
			 <option value="1">1</option>
			 <option value="2">2</option>
			 <option value="4">4</option>
			
			</select>
			</div>
			<p class="med-text">€ <%=product.getPrice()%>0</p>
			
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
			
			<form name="personalizzazione" action="Personalizzazione" method="post">
				<p>Vuoi Personalizzare il prodotto?</p>
			<div class="quantity">
				<select class="quantity-option" name=type id="tipo">
				<option value="">Inserisci La Categoria</option>
				 <option value="Invernale">Invernale</option>
			 	<option value="Estivo">Estivo</option>
			 	<option value="4 Stagioni">4 Stagioni</option>
			
				</select>
			</div>
			
			
			<div class="quantity">
				<select class="quantity-option" name=color id="colore">
					<option value="">Inserisci Il Colore</option>
			 		<option value="Giallo">Giallo</option>
			 		<option value="Rosso">Rosso</option>
			 		<option value="Verde">Verde</option>
				</select>
			</div>
			
		
			
			
			<input type="hidden" name="prezzo" required value="<%=product.getPrice()%>">
			<input type="hidden" name="nome" required value="<%=product.getName()%>">
			<input type="hidden" name="descrizione" required value="<%=product.getDescription()%>">
			
		

			
			<div id="prenota" style="display: none;">
			<input id="prenota" type="submit" value="Personalizza">
		</div>
			</form>
		
		<button class="bottone" id="disponibilita" onclick="validaCampi()">Verifica Campi</button>
			
			<p class="error" id="demo"></p>
			<p class="error"id="demo1"></p>
	
			
			</div>	
		</div>

	

	

	<%@include file="/Footer.jsp" %>
  <script type="text/javascript">
    function setQuant(){
    	var selectDaVerificare = document.getElementById("quantity");
    	var indiceSelezionato = selectDaVerificare.selectedIndex;
    	var valoreSelezionato = selectDaVerificare.options[indiceSelezionato];
    	
    	var valoreOpzione = valoreSelezionato.value;
    	
    	
    	var url = "CartS?action=addC&id=<%=product.getCode()%>&quantity=";
    	
    	var urlCompleto = url+valoreOpzione;
    	
    	
    	window.open(urlCompleto,'_self');
    	
    }
    
    
    function redirectUrl(){
    	
    	var url=request.getContextPath(); 
    	window.open(url+"/login.jsp",'_self');
    	
    }
    
    
function validaCampi() {
		
		var tipoCheck= false;
		var coloreCheck=false;
	
		
		var tipo = document.personalizzazione.type.value;
		var colore = document.personalizzazione.color.value;
	
		
		
		
		if (tipo != ""){
			document.getElementById("demo").innerHTML = "";
			document.getElementById("demo").style.display = "none";
			tipoCheck=true;
		}

		if (tipo == ''){
			document.getElementById("demo").innerHTML = "Inserisci Il tipo !";
			document.getElementById("demo").style.display = "block";
			tipoCheck=false;	
		}
		
		

		if (colore != ""){
			document.getElementById("demo1").innerHTML = "";
			coloreCheck=true;	
			document.getElementById("demo1").style.display = "none";
			
			if(colore=='Giallo'){
				
        		document.getElementById("immagine").src = "src/accessori8.jpg";
        	}
			else
				if(colore=='Rosso'){
					
	        		document.getElementById("immagine").src = "src/accessori8.jpg";
	        	}
				else
					if(colore=='Verde'){
					
		        		document.getElementById("immagine").src = "src/accessori8.jpg";
		        	}
			
			
			
			
			
		}
			
		else{
			document.getElementById("demo1").innerHTML = "Inserisci Il colore !";
			document.getElementById("demo1").style.display = "block";
			coloreCheck=false;
		}
		
		
		
		
		
		if(coloreCheck && tipoCheck)
		{
			document.getElementById("prenota").style.display = "block";
			document.getElementById("disponibilita").style.display = "none";
		}
		
		

		

	}

    </script>
		<%
		}
	%>

</body>

</html>
