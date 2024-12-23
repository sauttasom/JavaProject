<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <title>Cental - Car Rent Website Template</title>
      <meta content="width=device-width, initial-scale=1.0" name="viewport">
      <meta content="" name="keywords">
      <meta content="" name="description">

      <!-- Google Web Fonts -->
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,400;0,700;0,900;1,400;1,700;1,900&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet"> 


      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">


      <link href="lib/animate/animate.min.css" rel="stylesheet">
      <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


      <link href="css/bootstrap.min.css" rel="stylesheet">


      <link href="css/style.css" rel="stylesheet">
   </head>
   <body>
      <jsp:include page="/view/navbar.jsp" />


      <div class="container py-4">

         <form action="PaymentServlet" method="post">
            
            <div class="col-lg-12 wow fadeInUp"  style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
               <div class="row">
                  
                  <div class="col-lg-2"></div>
                  <div class="col-lg-4">
                     <div class="blog-item">
                        <input value="${bookingId}" name="bookingId" type="hidden">
                        <div class="blog-img">
                           <img src="img/${imagecar}" class="img-fluid rounded-top w-100" alt="Image">
                        </div>

                     </div>
                  </div>
                  <div class="col-lg-5">
                     <div class="blog-content rounded-bottom p-4">
                        <div class="blog-date">30 Dec 2025</div>
                        <div class="input-group mb-1">
                           <span class="input-group-text" id="basic-addon1">Name</span>
                           <input type="text" class="form-control" 
                                  disabled="true"
                                  name="name"
                                  value="${name}"
                                  >


                        </div>
                        <div class="input-group mb-1">
                           <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                              <span class="fas fa-calendar-alt"></span><span class="ms-1">Pick Up</span>
                           </div>
                           <input  value="${pickupaddress}"  name="pickup_address"  class="form-control" type="date">

                        </div>
                        <div class="input-group mb-1">
                           <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                              <span class="fas fa-calendar-alt"></span><span class="ms-1">Drop Up</span>
                           </div>
                           <input value="${dropoffDate}"  name="dropoff_date"  class="form-control" type="date">
                        </div>
                        <div class="input-group mb-1">
                           <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                              <span class="fas fa-map-marker-alt"></span><span class="ms-1">Pick Up</span>
                           </div>
                           <input   value="${pickupdate}"  name="pickup_date"  class="form-control" type="text">
                        </div>
                        <div class="input-group mb-1">
                           <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                              <span class="fas fa-map-marker-alt"></span><span class="ms-1">Drop Up</span>
                           </div>
                           <input value="${dropoffaddress}"  name="dropoff_address"  class="form-control" type="text">
                        </div>
                        <div class="btn btn-group">
                           <button class="btn btn-lg btn-danger" >Cancel</button>
                           <button type="submit" class="btn btn-lg btn-light" >
                              <i class="fab fa-cc-paypal"></i> Pay
                           </button>
                        </div>

                     </div>
                  </div>

               </div>
            </div>
         </form>
      </div>

      <jsp:include page="/view/footer.jsp" />

      <!-- JavaScript Libraries -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
      <script src="../lib/wow/wow.min.js"></script>
      <script src="../lib/easing/easing.min.js"></script>
      <script src="../lib/waypoints/waypoints.min.js"></script>
      <script src="../lib/counterup/counterup.min.js"></script>
      <script src="../lib/owlcarousel/owl.carousel.min.js"></script>


      <!-- Template Javascript -->
      <script src="js/main.js"></script>

   </body>
</html>
