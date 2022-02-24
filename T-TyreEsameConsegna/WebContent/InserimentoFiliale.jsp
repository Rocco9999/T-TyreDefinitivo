<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Inserirmento Filiale/Amministratore</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="admin/Adminstyle.css">
  <link rel="stylesheet" href="style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.min.css" integrity="sha512-BiFZ6oflftBIwm6lYCQtQ5DIRQ6tm02svznor2GYQOfAlT3pnVJ10xCrU3XuXnUrWQ4EG8GKxntXnYEdKY0Ugg==" crossorigin="anonymous" />
  <script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>
</head>
<body>

<jsp:useBean id="UtenteBean" class="beanAccount.UtenteBean" scope="session"/>
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
	
	
	    
	if(type.equals("adm")){%> 
	<%@include file="/HeaderAdmin.jsp" %>


<section>

	

	<div class="grid">
		<form name="registrazione" action="RegistrazioneFiliale" method="post">
	
		<!-- Inserimento Amministratore Filiale -->
		<div class="grid">
				<h6 class="big-text">Inseriemnto Dati Amministratore</h1>
			</div>
	
		<div class="grid">
			<h5 class="med-text">Riempire tutti i campi</h5>
		</div>
			
			<div class="leftal">
				<label>Nome </label> <input type="text" placeholder="Inserisci Nome"
					name="nome" oninput="validaNome()">
			</div>

			<div class="leftal">
				<label>Cognome</label> <input type="text"
					placeholder="Inserisci Cognome" name="cognome"
					oninput="validaCognome()">
			</div>
			
			<div class="leftfull">
				<label>Email <span style="font-size: 12px;">(Inserire
						email non registrata)</span></label> <input type="text"
					placeholder="Inserisci Email" name="email" oninput="validaEmail()">
			</div>
			
			<div class="leftal">
				<label>Password <span style="font-size: 12px;">
						(Inserire almeno 8 caratteri tra cui: una lettera maiuscola, una
						minuscola, un numero)</span></label> <input type="password"
					placeholder="Inserisci Password" name="password"
					oninput="validaPassword()">
			</div>

			<div class="leftal">
				<label>Password (conferma)</label> <input type="password"
					placeholder="Reinserisci Password" name="passwordConferma"
					oninput="validaPassword()">
			</div>
			
			
			
			
			<!-- Inserimento Filiale -->
			<div class="grid">
				<h1 class="big-text">Inseriemnto Filiale</h1>
			</div>
			
			<div class="leftal">
				<label>Indirizzo </label> <input type="text" placeholder="Inserire Indirizzo"
					name="indirizzo" oninput="validaIndirizzo()">
			</div>

			<div class="leftal">
				<label>Recapito Telefonico</label> <input type="text"
					placeholder="Inserire Telefono" name="telefono"
					oninput="validaTelefono()">
			</div>

			<div class="leftfull">
				<label>#Interventi Per ora(MAX 5)</label> <input type="text"
					placeholder="Inserire N° Interventi X Ora" name="interventiora"
					oninput="validaInterventiOra()">
			</div>

			<div class="leftfull">
				<label>Orario Apertura (Formato HH:00) </label> <input type="time"
					placeholder="Inserire Orario Apertura" name="orarioapertura" 
					
					oninput="validaOrarioApertura()">
			</div>
			
			
			<div class="leftfull" id="orarioOpen" style="display: none;" >
				<label>Orario Chiusura(Formato HH:00)</label> <input type="time"
				
					placeholder="Inserire Orario Chiusura" name="orariochiusura"
					oninput="validaOrarioChiusura()">
					
			</div>


		
			
			
			<input id="registrami" type="submit" value="Registra" disabled>
			
		</form>
	</div>
</section>

   <%} else response.sendRedirect("./admin/loginAdmin.jsp");%>
<%}%>


<script>
	var borderOk = '2px solid #080';
	var borderNo = '2px solid #f00';

	//Inserimento Amministratore Filiale
	var emailOk = false;
	var passwordOk = false;
	var nomeOk = false;
	var cognomeOk = false;
	
	
	//Inserimento Filiale
	var telefonoOk = false;
	var indirizzoOk = false;
	var interventioraOK=false;
	var orarioChiusuraOK=false;
	var orarioAperturaOK=false;


	function validaEmail() {

		var input = document.forms['registrazione']['email'];

		if (input.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)) {

			var xmlHttpReq = new XMLHttpRequest();
			xmlHttpReq.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200
						&& this.responseText == '<ok/>') {
					emailOk = true;
					input.style.border = borderOk;
				} else {
					input.style.border = borderNo;
					emailOk = false;
				}
				cambiaStatoRegistrami();
			}

			xmlHttpReq.open("GET", "VerificaEmail?email="
					+ encodeURIComponent(input.value), true);
			xmlHttpReq.send();
		} else {
			input.style.border = borderNo;
			emailOk = false;
			cambiaStatoRegistrami();
		}
	}

	function validaPassword() {
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
		cambiaStatoRegistrami();
	}
	

	function validaNome() {
		var input = document.forms['registrazione']['nome'];
		if (input.value.trim().length > 0
				&& input.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {
			input.style.border = borderOk;
			nomeOk = true;
		} else {
			input.style.border = borderNo;
			nomeOk = false;
		}
		cambiaStatoRegistrami();
	}

	function validaCognome() {
		var input = document.forms['registrazione']['cognome'];
		if (input.value.trim().length > 0
				&& input.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {
			input.style.border = borderOk;
			cognomeOk = true;
		} else {
			input.style.border = borderNo;
			cognomeOk = false;
		}
		cambiaStatoRegistrami();
	}


	function validaTelefono() {
		var input = document.forms['registrazione']['telefono'];
		if (input.value.trim().length > 0 && input.value.match(/^\d{10}$/)) {
			input.style.border = borderOk;
			telefonoOk = true;
		} else {
			input.style.border = borderNo;
			telefonoOk = false;
		}
		cambiaStatoRegistrami();
	}

	
	function validaIndirizzo() {
		var input = document.forms['registrazione']['indirizzo'];
		if (input.value.trim().length > 0
				&& input.value.match(/^[ 0-9a-zA-Z\u00C0-\u00ff]+$/)) {
			input.style.border = borderOk;
			indirizzoOk = true;
		} else {
			input.style.border = borderNo;
			indirizzoOk = false;
		}
		cambiaStatoRegistrami();
	}
	
	
	function validaInterventiOra() {
		var input = document.forms['registrazione']['interventiora'];
		if (input.value.match(	/^([1-5])$/	)) {
			input.style.border = borderOk;
			interventioraOK = true;
		} else {
			input.style.border = borderNo;
			interventioraOK = false;
		}
		cambiaStatoRegistrami();
	}

	function validaOrarioChiusura() {
		var input = document.forms['registrazione']['orariochiusura'];
		console.log(input)
		
		var orarioOpen = document.registrazione.orarioapertura.value;
		var orarioOpen=orarioOpen.substr(0,2);
		
		var orarioClose = document.registrazione.orariochiusura.value;
		var orarioClose=orarioClose.substr(0,2);
		
		
		
		if (input.value.match(/^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-0][0-0]$/) &&
				orarioOpen < orarioClose && orarioClose>=9 && orarioClose<=19) {
			input.style.border = borderOk;
			orarioChiusuraOK = true;
		} else {
			input.style.border = borderNo;
			orarioChiusuraOK = false;
		}
		cambiaStatoRegistrami();
	}

	

	function validaOrarioApertura() {
		var input = document.forms['registrazione']['orarioapertura'];
		
		var orarioOpen = document.registrazione.orarioapertura.value;
		var orarioOpen=orarioOpen.substr(0,2);
		
		
		if ( input.value.match(/^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-0][0-0]$/) &&
				orarioOpen>=9 && orarioOpen<=19) {
			document.getElementById("orarioOpen").style.display = "block";
			input.style.border = borderOk;
			orarioAperturaOK = true;
			
		} else {
			input.style.border = borderNo;
			orarioAperturaOK= false;
		}
		cambiaStatoRegistrami();
	}

	function cambiaStatoRegistrami() {
		if (telefonoOk && indirizzoOk && interventioraOK && orarioChiusuraOK && orarioAperturaOK && 
				emailOk && passwordOk && nomeOk && cognomeOk) {
			document.getElementById('registrami').disabled = false;
		} else {
			document.getElementById('registrami').disabled = true;
		}
	}
</script>
</body>
</html>
