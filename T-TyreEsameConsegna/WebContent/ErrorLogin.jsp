<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,beanAgenda.*,controlAccount.*,daoAccount.*"%>
<head>
  
  <title>Errore Login</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.min.css" integrity="sha512-BiFZ6oflftBIwm6lYCQtQ5DIRQ6tm02svznor2GYQOfAlT3pnVJ10xCrU3XuXnUrWQ4EG8GKxntXnYEdKY0Ugg==" crossorigin="anonymous" />

</head>

 
<%@include file="/Header.jsp" %>
     
    
     
     <div class="grid">
     <div class="col">
     
     		<h1 class="big-text">Username e/o Password errate</h1>
     
     </div>
     
     <div class="col">
     
     	<div class="button">
     		<a href="./login.jsp">Torna login</a>
     		</div>
    	 </div>
	</div>

<%@include file="/Footer.jsp" %>

