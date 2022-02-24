<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	UtenteBean Utente = (UtenteBean) request.getAttribute("Utente");

	String password = (String) request.getSession().getAttribute("password"); 
	
	
	
%>
	 
	
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,beanAccount.*,controlAccount.*,daoAccount.*,beanOrdine.*,beanProdotto.*"%>
<head>
  <title>I miei dati</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.min.css" integrity="sha512-BiFZ6oflftBIwm6lYCQtQ5DIRQ6tm02svznor2GYQOfAlT3pnVJ10xCrU3XuXnUrWQ4EG8GKxntXnYEdKY0Ugg==" crossorigin="anonymous" />

</head>

<jsp:include page="/Header.jsp">
	<jsp:param name="pageTitle" value="Registrazione utente"/>
</jsp:include>


	<section>
		<div class="grid"><h1 class="big-text">I miei dati</h1></div>
		<div class="grid"><h5 class="med-text">Riepilogo dati</h5></div>

		
		<div class="grid">
		<form name="registrazione" action="DatiUtente" method="post">
			
		
			<div class="leftal"><label>Nome </label>
			<input type="text" name="nome" required value="<%=Utente.getNome()%>" ></div>
			
			<div class="leftal"><label>Cognome</label>
			<input type="text" name="cognome" required value="<%=Utente.getCognome()%>" ></div>
			
			<div class="leftal"><label>Indirizzo</label>
			<input type="text" name="indirizzo" required value="<%=Utente.getIndirizzo()%>" ></div>
			
			<div class="leftal"><label>Telefono</label>
			<input type="text" name="telefono" required value="<%=Utente.getTelefono()%>" ></div>
			
			<div class="leftal"><label>Password </label>
			<input type="password" name="password" required value="<%=password%>" ></div>
			
			<div class="leftal"><label>Password (conferma)</label>
			<input type="password" name="passwordConferma" required value="<%=password%>" ></div>
			
			<div class="leftfull"><label>Email </label>
			<input type="text" name="email" required value="<%=Utente.getEmail()%>" ></div>
			
			<div class="leftfull"><label>Carta Di Credito</label>
			<input type="text" name="CartaCredito" required value="<%=Utente.getNumero_carta()%>" ></div>
			
			
			<input id="registrami" type="button" value="Modifica" onclick="modificaDati()">
		</form>
		</div>
	</section>
	
	<script>
		var borderOk = '2px solid #080';
		var borderNo = '2px solid #f00';
		
		var passwordOk = false;
		var nomeOk = false;
		var emailOk = false;
		var telefonoOk = false;
		var CartaCreditoOk = false;
		var indirizzoOk = false;
		var cognomeOk = false;
	
		function modificaDati(){
	
	
			var inputpw = document.forms['registrazione']['password'];
			var inputpwconf = document.forms['registrazione']['passwordConferma'];
			var password = inputpw.value;
			if (password.length >= 8 && password.toUpperCase() != password
					&& password.toLowerCase() != password && /[0-9]/.test(password)) {
				inputpw.style.border = borderOk;
	
				if (password == inputpwconf.value) {
					inputpwconf.style.border = borderOk;
					passwordOk = true;
				} else {
					inputpwconf.style.border = borderNo;
					passwordOk = false;
				}
			} else {
				inputpw.style.border = borderNo;
				inputpwconf.style.border = borderNo;
				passwordOk = false;
			}
			
		
	
	
			var input = document.forms['registrazione']['telefono'];
			if ( input.value.trim().length > 0 && input.value.match(/^\d{10}$/)) {
				input.style.border = borderOk;
				telefonoOk = true;
			} else {
				input.style.border = borderNo;
				telefonoOk = false;
			}
			
		
				
		
		
			var input = document.forms['registrazione']['nome'];
			if (input.value.trim().length > 0
					&& input.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {
				input.style.border = borderOk;
				nomeOk = true;
			} else {
				input.style.border = borderNo;
				nomeOk = false;
			}
			
		
	
			var input = document.forms['registrazione']['CartaCredito'];
			if ( input.value.match(/^\d{16}$/)) {
				input.style.border = borderOk;
				CartaCreditoOk = true;
			} else {
				input.style.border = borderNo;
				CartaCreditoOk = false;
			}
			
		
		
		
			var input = document.forms['registrazione']['indirizzo'];
			if (input.value.trim().length > 0
					&& input.value.match(/^[ 0-9a-zA-Z\u00C0-\u00ff]+$/)) {
				input.style.border = borderOk;
				indirizzoOk = true;
			} else {
				input.style.border = borderNo;
				indirizzoOk = false;
			}
			
		
		
	
			var input = document.forms['registrazione']['cognome'];
			if (input.value.trim().length > 0
					&& input.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {
				input.style.border = borderOk;
				cognomeOk = true;
			} else {
				input.style.border = borderNo;
				cognomeOk = false;
			}
			
		
	
		
			var input = document.forms['registrazione']['email'];
			if (input.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)) {
				input.style.border = borderOk;
				emailOk = true;
			} else {
				input.style.border = borderNo;
				emailOk = false;
			}
			
			
			
			if ( passwordOk && nomeOk && emailOk && cognomeOk && telefonoOk && indirizzoOk && CartaCreditoOk) {
				
				document.getElementById('registrami').type ='submit';
			}
			
		}
		

		
	</script>
	
<%@include file="/Footer.jsp"%>
