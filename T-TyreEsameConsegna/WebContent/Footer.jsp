<html>


<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,beanAgenda.*,controlAccount.*,daoAccount.*"%>

 
<div class="mt-3"></div>

<footer class="footer">
 <div class="grid">
   <div class="col">
     <h4 class="tw normal-text">SPARE PART SRL</h4>
     <p>CI troviamo in Via Turati 33, Milano, Italy</p>
   </div>
   <div class="col"> 
   		 
   		 <ul class="menu-footer">
   		  <% 
           
			if(session.getAttribute("user")!= null){%>
			
			<h4 class="tw normal-text">Account</h4>
   		    <li><a href="./OrdineUtente">I miei ordini</a></li>
   		    <li><a href="./DatiUtente">I miei dati</a></li>
   		    
   		    	<%}%>
   		    <li></li>
   		 </ul>
   </div>
   
   <div class="col">
   		 <h4 class="tw normal-text">Categorie</h4>
   		 <ul class="menu-footer">
   		    <li><a href="Categoria?action=get&categoria=accessori">Accessori</a></li>
   		    <li><a href="Categoria?action=get&categoria=auto">Pneumatici auto</a></li>
   		    <li><a href="Categoria?action=get&categoria=moto">Pneumatici moto</a></li>
   		    <li></li>
   		 </ul>
   </div>
   
    <div class="col">
    	<img src="src/payments.png">
   </div>
  </div>
  
 </footer>
 <div style="background: #000;">
<div class="grid footer-bor">
  <p style="bottom: 0;">© 2021 Spare Parts SRL tutti i diritti sono riservati - Powered by Fortunato&Ferrante&Carotenuto</p>
  </div>
</div>
</body>

</html>