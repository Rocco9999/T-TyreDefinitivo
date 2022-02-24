
<%
	
	Collection<?> products = (Collection<?>) request.getAttribute("products");

	if(products == null) {
	
	response.sendRedirect("./product");	
	return;
	}
	
 
	
	
%>

<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,beanAccount.*,controlAccount.*,daoAccount.*,beanOrdine.*,beanProdotto.*"%>
<head>
  
  <title>Prodotti</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" />
  <link rel="stylesheet" href="style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.min.css" integrity="sha512-BiFZ6oflftBIwm6lYCQtQ5DIRQ6tm02svznor2GYQOfAlT3pnVJ10xCrU3XuXnUrWQ4EG8GKxntXnYEdKY0Ugg==" crossorigin="anonymous" />

</head>

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
	<a class="button" href="adminInserimentoProdotto.jsp">Aggiungi prodotto</a>
	</div>

     
     
     
     <!-- Start Griglia -->
     <div class="griglia-prodotti mt-1">
		<!-- VISUALIZZAZIONE DEI PRODOTTI -->
		<%
			if (products != null && products.size() != 0) {
				Iterator<?> it = products.iterator();
				while (it.hasNext()) {
					ProductBean bean = (ProductBean) it.next();
		%>
		
      
      <div class="item product" style="margin-bottom: 15px;">
		
        <div class="image-product"  id="Immagine"><a href="Dettagli?action=read&id=<%=bean.getCode()%>"><%if(bean.getPhoto()!=null) {
				String img = bean.getPhoto();
			%><img src="src/<%=img %>" height="300px" />
			<%}  else { %>
			<img src="<%=request.getContextPath()%>/images/unnamed1.jpg" height="300px"/>
			<%} %>
			</a>
		
        </div>
         
        <div class="title-product">
          <h3 class="normal-text"><%=bean.getName()%></h3>
          <p class="med-text prezzo">€ <%=bean.getPrice()%>0</p>
          
          
          <a class="button" style="margin-bottom:10px;" href="./UpdateProduct?action=update&id=<%=bean.getCode()%>">Update</a><br>
          
          
          
          <a class="button" href="./product?action=delete&id=<%=bean.getCode()%>">Cancella</a><br>
        </div>
      
      </div>
      

		
      
		<%
				}
			
		%>	
		
			
			
		<% 
			}else {
		
		
		%>
		
			<h1>No products available</h1>
		
		<%
			}
		
		
		
	 }else response.sendRedirect("./login.jsp"); %>
	<% }%>

</div>
		

   
    


