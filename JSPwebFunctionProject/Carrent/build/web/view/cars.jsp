
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Service.CarService" %>
<%@ page import="Models.Cars" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="java.util.logging.Level" %>
<%@ page import="java.sql.SQLException" %>
<%@ page isErrorPage="true" %>
<%
      CarService cars = new CarService();
      List<Cars> cardata = new ArrayList<>(); 
      try {
          cardata = cars.GetCarList();
         cardata.forEach(item ->{System.out.println(item.getCarname());});
         
      } catch (SQLException ex) {
         throw new ServletException(ex); 
      }
%>

<div class="container-fluid categories py-5">
   <div class="container py-5">
      <div class="text-center mx-auto pb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 800px;">
         <h1 class="display-5 text-capitalize mb-3">Vehicle <span class="text-primary">Categories</span></h1>
      </div>
      <form action="CarsServlet" method="post">
         <div class="categories-carousel owl-carousel wow fadeInUp" data-wow-delay="0.5s">

            <%
            if(cardata != null && !cardata.isEmpty()) {
               for(Cars car : cardata) {
                    System.out.println( car.getPathimage() );
            %>

            <div  class="categories-item p-4">
            
               <div class="categories-item-inner">
                  <div class="categories-img rounded-top">
                     <input name="carid" type="hidden" value="<%=car.getCarid()%>"  >
                     <img src="<%= "img/"+ car.getImageName() %>" img-fluid w-100 rounded-top" alt="">
                     
                     <div  class="categories-content rounded-bottom p-4">
                        <h4><%= car.getCarname()%></h4>

                        <div class="mb-4">
                           <h4 class="bg-white text-primary rounded-pill py-2 px-4 mb-0">$:<%= car.getCarPirce()%>/Day</h4>
                        </div>

                        <button  
                           class="btn btn-lg btn-primary rounded-pill d-flex justify-content-center py-3">
                           Book Now
                        </button>
                     </div>
                  </div>
               </div>
            </div>

            <%      
                  }
               }
            %>
 
         </div>
      </form>
   </div>
</div>