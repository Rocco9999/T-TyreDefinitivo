<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	
	MimeMessage message = (MimeMessage) request.getAttribute("message");
	
	ProductBean product = (ProductBean) request.getAttribute("product");
	

%>

<html>
<%@ page contentType="text/html; charset=UTF-8" import="javax.activation.*,javax.mail.internet.*,javax.mail.*,java.util.*, java.net.Inet4Address, java.io. *,javax.servlet.*,javax.servlet.annotation.WebServlet,javax.servlet.http.*,java.util.*,beanAccount.*,controlAccount.*,daoAccount.*,beanOrdine.*,beanProdotto.*"%>
<head>
  
  <title>Email</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.min.css" integrity="sha512-BiFZ6oflftBIwm6lYCQtQ5DIRQ6tm02svznor2GYQOfAlT3pnVJ10xCrU3XuXnUrWQ4EG8GKxntXnYEdKY0Ugg==" crossorigin="anonymous" />
 	
  
 
</head>
<body>
	<%@include file="/Header.jsp" %>
	
	
	<% message.setSubject ( "This is the Subject Line!");

         message.setContent ( "<h1> This is actual message </ h1>",
                            "Text / html");
          Transport.send (message);
         String title = "email";
         String res = "successfully sent messages ...";
         String docType = "\n <DOCTYPE html!>";
         out.println (docType +
         "<Html>	\n" +
         "<Head> <title>" + title + "</title> </head> \n" +
         "<Body bgcolor = \" # f0f0f0 \"> \n" +
         "<H1 align =\" center \">" + title + "</h1> \n" +
         "<p align =\" center \">"+ res + "</p> \n" +
        "</ Body> </ html>");%>
	
	
	
	
     
	<%@include file="/Footer.jsp" %>
</body>

</html>


	