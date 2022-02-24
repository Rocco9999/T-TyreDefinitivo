

<html lang="it">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Admin</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="admin/Adminstyle.css">
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

<div style="margin-left:18%;padding:10px 10px;"><h3 class="med-text"> CIAO, ${user}</h3>
	<a href="${pageContext.request.contextPath}/logout">Logout</a></div>
	
      <!--  <h1>Non sei un amministratore!</h1>-->
     <%} else response.sendRedirect("./login.jsp");%>
<%}%>



</body>
</html>
