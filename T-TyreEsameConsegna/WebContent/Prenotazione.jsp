<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	Collection<?> indirizzi = (Collection<?>) request.getAttribute("indirizzi");
%>


<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,beanAgenda.*,controlAccount.*,daoAccount.*"%>
<head>

<title>T-Tyre</title>
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



<%@include file="/Header.jsp"%>

<div class="grid">
 <div class="col">

<form name="prenotazione" action="PrenotazioneServlet" method="post">

	<!-- Scelta della Data -->
	<p>Inserire Data</p>
		<input type="date" name="myDate" onClick="cancellaCampi()">

		<!-- Scelta della Filiale -->
	<p style="margin-top: 15px;">Inserire Filiale</p>
	
		<input list="filiale" placeholder="Scegli Citta" name=filiale
			id="sceltaFiliale" onclick="cancellaCampi()"
			onchange="ricercaOrari(this.value)"  />
		<datalist id=filiale>
			<%
				if (indirizzi != null && indirizzi.size() != 0) {
				Iterator<?> it = indirizzi.iterator();
				while (it.hasNext()) {
					FilialeBean bean = (FilialeBean) it.next();
			%>



			<option value=<%=bean.getIndirizzo()%>>
				<%
					}
				}
				%>
			
		</datalist>

		<!-- Scelta dell'Orario -->
		<input list="orari" name="orario" id="ora"  />
		<datalist id="orari"></datalist>
		
		
		
		
		<!-- Scelta del Pagamento-->
		<p style="margin-top: 15px;">Scegli il metodo di pagamento:</p>
		
  		<label><input type="radio" name="sesso" value="inFiliale"/>Pagamento in Contrassegno</label>
		<label><input type="radio" name="sesso" value="Online"/>Pagamento Online</label>
		
		<div id="prenota" style="display: none;">
			<input id="prenota" type="submit" value="Prenota">
		</div>


</form>
<button class="bottone" id="disponibilita" onclick="validaCampi()">Cerca Disponibilità</button>




<p class="error" id="demo"></p>
<p class="error"id="demo1"></p>
<p class="error" id="demo2"></p>
<p class="error" id="demo3"></p>

</div>

</div>
<script>
	function cancellaCampi() {
		document.getElementById("sceltaFiliale").value = "";
		document.getElementById("ora").value = "";
		//$("#filiale").empty();

	}
	function validaCampi() {
		
		var dataCheck= false;
		var filialeCheck=false;
		var orarioCheck=false;
		var payCheck=false;
		
		var data = document.prenotazione.myDate.value;
		var filiale = document.prenotazione.filiale.value;
		var orario = document.prenotazione.orario.value;

		var sesso = document.prenotazione.sesso.value;
		
		
		//Data Inserita
		var giorno = data.substr(8, 2);
		var mese = data.substr(5, 2);
		var anno = data.substr(0, 4);

		var dataInserita = new Date(anno + '/' + mese + '/' + giorno);
	

		//Data Attuale
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		var yyyy = today.getFullYear();

		var dataAttuale = new Date(yyyy + '/' + mm + '/' + dd);
		               
		
		
		
		var espressione = new RegExp(
				/^(?:(?=[02468][048]00|[13579][26]00|\d{2}0[48]|\d{2}[2468][048]|\d{2}[13579][26])\d{4})-(?:(?:01|03|05|07|08|10|12)-(?:[0-2]\d|3[0-1])|(?:04|06|09|11)-(?:[0-2]\d|30)|02-[0-2]\d)|(?:(?![02468][048]00|[13579][26]00|\d{2}0[48]|\d{2}[2468][048]|\d{2}[13579][26])\d{4})-(?:(?:01|03|05|07|08|10|12)-(?:[0-2]\d|3[0-1])|(?:04|06|09|11)-(?:[0-2]\d|30)|02-(?:[0-1]\d|2[0-8]))$/);
		
		
		if (data != ""){
			document.getElementById("demo").innerHTML = "";
			document.getElementById("demo").style.display = "none";
			dataCheck=true;
		}

		if (data == ''){
			document.getElementById("demo").innerHTML = "Inserisci la Data !";
			document.getElementById("demo").style.display = "block";
			dataCheck=false;	
		}
		else if ((dataInserita > dataAttuale ) == false
				|| espressione.test(data) == false || ( dataAttuale.getTime()+(1*1000*60*60*24*60))<dataInserita ) {
			document.getElementById("demo").innerHTML = "Formato Data Non Corretto!";
			document.getElementById("demo").style.display = "block";
			dataCheck=false;
		}
		

		if (filiale != ""){
			document.getElementById("demo1").innerHTML = "";
			filialeCheck=true;	
			document.getElementById("demo1").style.display = "none";
		}
			
		else{
			document.getElementById("demo1").innerHTML = "Inserisci La Filiale !";
			document.getElementById("demo1").style.display = "block";
		}
		
		
		if (orario != ""){
			document.getElementById("demo2").innerHTML = "";
			orarioCheck=true;
			document.getElementById("demo2").style.display = "none";
		}
		else{
			document.getElementById("demo2").innerHTML = "Inserisci L'orario !";
			document.getElementById("demo2").style.display = "block";
		}
		if(sesso !=''){
			
			document.getElementById("demo3").innerHTML = "";
			payCheck=true;	
			document.getElementById("demo3").style.display = "none";
		}
		else{
			document.getElementById("demo3").innerHTML = "Inserisci Il pagamento !";
			document.getElementById("demo3").style.display = "block";
		}
		
		
		
		if(dataCheck && filialeCheck && orarioCheck && payCheck)
		{
			document.getElementById("prenota").style.display = "block";
			document.getElementById("disponibilita").style.display = "none";
		}
		
		

		

	}

	function ricercaOrari(str) {
		$("#orari").empty();
		var data = document.prenotazione.myDate.value;

		var dataList = document.getElementById('orari');

		if (str.length == 0) {
			dataList.innerHTML = '';
			return;
		}

		var xmlHttpReq = new XMLHttpRequest();
		xmlHttpReq.responseType = 'json';

		xmlHttpReq.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				dataList.innerHTML = '';

				for ( var i in this.response) {
					var option = document.createElement('option');
					option.value = this.response[i];
					dataList.appendChild(option);
				}
			}
		}

		
		xmlHttpReq.open("GET", "PrenotazioneAjax?ric="
				+ encodeURIComponent(str) + ',' + encodeURIComponent(data),
				true);
		xmlHttpReq.send();

	}
</script>
<%@include file="/Footer.jsp"%>