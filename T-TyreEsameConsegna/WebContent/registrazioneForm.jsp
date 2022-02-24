<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>


<head>

<title>Registrazione</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"
	integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw=="
	crossorigin="anonymous" />
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.min.css"
	integrity="sha512-BiFZ6oflftBIwm6lYCQtQ5DIRQ6tm02svznor2GYQOfAlT3pnVJ10xCrU3XuXnUrWQ4EG8GKxntXnYEdKY0Ugg=="
	crossorigin="anonymous" />
</head>

<jsp:include page="/Header.jsp">
	<jsp:param name="pageTitle" value="Registrazione utente" />
</jsp:include>

<section>
	<div class="grid">
		<h1 class="big-text">Registrazione utente</h1>
	</div>
	<div class="grid">
		<h5 class="med-text">Riempire tutti i campi</h5>
	</div>

	<div class="grid">
		<form name="registrazione" action="Registrazione" method="post">

			<div class="leftal">
				<label>Nome </label> <input type="text" placeholder="Inserisci Nome"
					name="nome" oninput="validaNome()">
			</div>

			<div class="leftal">
				<label>Cognome</label> <input type="text"
					placeholder="Inserisci Cognome" name="cognome"
					oninput="validaCognome()">
			</div>

			<div class="leftal">
				<label>Indirizzo</label> <input type="text"
					placeholder="Inserisci Via e Numero civico" name="indirizzo"
					oninput="validaIndirizzo()">
			</div>

			<div class="leftal">
				<label>Telefono</label> <input type="text"
					placeholder="Inserisci Numero di Telefono" name="telefono"
					oninput="validaTelefono()">
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

			

			<div class="leftfull">
				<label>Carta Di Credito</label> <input type="text"
					placeholder="Inserisci Carta di Credito" name="CartaCredito"
					oninput="validaCartaCredito()">
			</div>


			<input id="registrami" type="submit" value="Registrami" disabled>
		</form>
	</div>
</section>
<script>
	var borderOk = '2px solid #080';
	var borderNo = '2px solid #f00';

	var emailOk = false;
	var passwordOk = false;
	var nomeOk = false;
	var telefonoOk = false;
	var CartaCreditoOk = false;
	var indirizzoOk = false;
	var cognomeOk = false;

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

	function validaCartaCredito() {
		var input = document.forms['registrazione']['CartaCredito'];
		if (input.value.match(/^\d{16}$/)) {
			input.style.border = borderOk;
			CartaCreditoOk = true;
		} else {
			input.style.border = borderNo;
			CartaCreditoOk = false;
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

	function cambiaStatoRegistrami() {
		if (emailOk && passwordOk && nomeOk && cognomeOk && telefonoOk
				&& indirizzoOk && CartaCreditoOk) {
			document.getElementById('registrami').disabled = false;
		} else {
			document.getElementById('registrami').disabled = true;
		}
	}
</script>
<%@include file="/Footer.jsp"%>
