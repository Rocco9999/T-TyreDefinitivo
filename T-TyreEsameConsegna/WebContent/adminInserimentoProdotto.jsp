
<html>
<%@ page contentType="text/html; charset=UTF-8"  import="java.util.*,beanAgenda.*,controlAccount.*,daoAccount.*"%>
<head>
  
  <title>Prodotti</title>
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

<body>

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

	<div class="grid">
	<div class="col">
		<form  name="insert" action="product" method="post">
		
		<input type="hidden" name="action" value="insert"> 
		
		<div class="leftal">
		<label >Name:</label>
		<input name="name" type="text" maxlength="50" required placeholder="enter name">
		</div>
		
		
		<div class="leftal">
		<label>Description:</label>
		<input type="text" name="description" maxlength="300"  required placeholder="enter description">
		</div>
		
		
		<div class="leftal">
			<label for="price">Price:</label>
			<input type="text" name="price"   placeholder="1" required>
		</div>
	
	
		<div class="leftal">
		<label for="categoria">Category:</label><br>
  		<select name="category" id="categoria" >
  			<option value="" ></option>
    		<option value="Estivo">Estivo</option>
   			<option value="Invernale">Invernale</option>
    		<option value="4 Stagioni">4 Stagioni</option>
    	
  		</select>
		</div>
		
		
		<div class="leftal">
		<label for="name">Photo:</label><br>
		<input type="file" name="photo" id="fileToUpload" accept="image/png, image/jpeg"> <br>
		</div>
		
	
		<div id="prenota" style="display: none;">
			<input type="submit" value="Insert"  >
		</div>
		
		<input class="inputbut"type="reset" value="Reset">
		
		
	</form>
	
<div id="disponibilita" >
<button class="inputbut" onclick="validaCampiInsert()">Check Date</button>
</div>
  
<p id="demo"></p>
<p id="demo1"></p>
<p id="demo2"></p>
<p id="demo3"></p>
<p id="demo4"></p>
     	</div>
     </div>
     
     
	<%}else response.sendRedirect("./login.jsp"); %>
	<%}%>

</body>
</html>
<script>

	function validaCampiInsert(){
		
		var nomeCheck=false;
		var descrizioneCheck=false;
		var prezzoCheck=false;
		var categoriaCheck=false;
		var photoCheck=false;
		
		
		var nome = document.insert.name.value;
		var descrizione = document.insert.description.value;
		var prezzo = document.insert.price.value;

		var categoria = document.insert.category.value;
		var photo = document.insert.photo.value;
	
		
		
		
		
		var espressione3= new RegExp(/^([1-9][0-9]{0,2}|1000)$/);
		
		
		
		//Nome
		if (nome != ""){
			document.getElementById("demo").innerHTML = "";
			nomeCheck=true;
		}
		
		if (nome == ""){
			document.getElementById("demo").innerHTML = "Inserisci Il Nome";
			nomeCheck=false;
		}
	
		
		
	
		//Descrizione
		if (descrizione != ""){
			document.getElementById("demo1").innerHTML = "";
			descrizioneCheck=true;
		}
		
		if(descrizione==""){
			document.getElementById("demo1").innerHTML = "Inserisci Descrizione!";
			descrizioneCheck=false;
		}
		
	
		
		//Prezzo
		if (prezzo != ""){
			document.getElementById("demo2").innerHTML = "";
			prezzoCheck=true;
		}
		
		if(prezzo==""){
			document.getElementById("demo2").innerHTML = "Inserisci Prezzo!";
			descrizioneCheck=false;
		}
		else
			if(espressione3.test(prezzo)== false){
				document.getElementById("demo2").innerHTML = "Formato Prezzo Non Corretto!";
				prezzoCheck=false;
		}
		
		//Categoria
		if(categoria !=""){
			document.getElementById("demo3").innerHTML = "";
			categoriaCheck=true;
		}
		
		if(categoria ==""){
			document.getElementById("demo3").innerHTML = "Inserisci Categoria!";
			categoriaCheck=false;
		}
		
		
		
		//Photo
		if (photo ==""){
			document.getElementById("demo4").innerHTML = "Inserisci La Foto!";
			photoCheck=false;
		}
		else
			{	document.getElementById("demo4").innerHTML = "";
				photoCheck=true;
			}
		
		
		if(nomeCheck && descrizioneCheck && categoriaCheck && prezzoCheck && photoCheck){
				
			document.getElementById("disponibilita").style.display = "none";
			document.getElementById("prenota").style.display = "block";
				
			}
			
	}

</script>
		
