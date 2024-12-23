<%-- 
    Document   : register
    Created on : Nov 12, 2024, 11:05:34 PM
    Author     : Thanawin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

      <!-- Icon Font Stylesheet -->
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

      <!-- Libraries Stylesheet -->
      <link href="lib/animate/animate.min.css" rel="stylesheet">
      <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


      <!-- Customized Bootstrap Stylesheet -->
      <link href="css/bootstrap.min.css" rel="stylesheet">

      <!-- Template Stylesheet -->
      <link href="css/style.css" rel="stylesheet">
   </head>
   <body>
      <div class="header-carousel">
         <div id="carouselId" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">

            <div class="carousel-inner" role="listbox">
               <div class="carousel-item active">
                  <img src="img/banner-1.jpg" class="img-fluid w-100" alt="First slide">
                  <div class="carousel-caption">
                     <div class="container ">

                        <div class="row g-5">
                           <div class="col-lg-6 fadeInLeft animated">
                              <div class="bg-secondary rounded p-5">
                                 <h4 class="text-white mb-4">REGISTER MEMBER</h4>

                                 <form action="ResgisterServlet" method="post">
                                    <div class="row g-3">
                                       <!--                                 url icon      https://fontawesome.com/v5/search?q=id-card&o=r-->
                                       <div class="col-12">
                                          <div class="input-group">
                                             <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                                                <i class="fas fa-id-card-alt"></i><span class="ms-1">ID Card</span>
                                             </div>
                                             <input name="idcard" class="form-control" type="text" required>
                                          </div>
                                       </div>

                                       <div class="col-12">

                                          <div class="input-group">
                                             <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                                                <i class="fas fa-user"></i><span class="ms-1">Username</span>
                                             </div>
                                             <input name="username" class="form-control" type="text" required=>
                                          </div>
                                       </div>

                                       <div class="col-12">

                                          <div class="input-group">
                                             <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                                                <i class="fas fa-user"></i><span class="ms-1">Password</span>
                                             </div>
                                             <input name="passwrod" class="form-control" type="text" required=>
                                          </div>
                                       </div>

                                       <div class="col-12">
                                          <div class="input-group">
                                             <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                                                <i class="fas fa-signature"></i><span class="ms-1">Name</span>
                                             </div>
                                             <input class="form-control ms-3" name="firstname"  type="text">
                                             <input class="form-control ms-3" name="lasttname"  type="text">
                                          </div>
                                       </div>
                                       <div class="col-12">
                                          <div class="btn-group">

                                             <button  type="button"  class="btn btn-primary ">Cancel</button>
                                             <button type="submit"  class="btn btn-light">Submit</button>
                                          </div>

                                       </div>
                                    </div>
                                 </form>
                              </div>
                           </div>

                        </div>
                     </div>
                  </div>
               </div>

            </div>
         </div>
      </div>
      <!-- Template Javascript -->
      <script src="js/main.js"></script>
   </body>
</html>
