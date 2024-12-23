<div class="container-fluid topbar bg-secondary d-none d-xl-block w-100">
   <div class="container">
      <div class="row gx-0 align-items-center" style="height: 45px;">
         <div class="col-lg-6 text-center text-lg-start mb-lg-0">
            <div class="d-flex flex-wrap">
               <a href="#" class="text-muted me-4"><i class="fas fa-map-marker-alt text-primary me-2"></i>Find A Location</a>
               <a href="tel:+01234567890" class="text-muted me-4"><i class="fas fa-phone-alt text-primary me-2"></i>+01234567890</a>
               <a href="mailto:example@gmail.com" class="text-muted me-0"><i class="fas fa-envelope text-primary me-2"></i>Example@gmail.com</a>
            </div>
         </div>
         <div class="col-lg-6 text-center text-lg-end">
            <div class="d-flex align-items-center justify-content-end">
               <a href="#" class="btn btn-light btn-sm-square rounded-circle me-3"><i class="fab fa-facebook-f"></i></a>
               <a href="#" class="btn btn-light btn-sm-square rounded-circle me-3"><i class="fab fa-twitter"></i></a>
               <a href="#" class="btn btn-light btn-sm-square rounded-circle me-3"><i class="fab fa-instagram"></i></a>
               <a href="#" class="btn btn-light btn-sm-square rounded-circle me-0"><i class="fab fa-linkedin-in"></i></a>
            </div>
         </div>
      </div>
   </div>
</div> 
<div class="container-fluid nav-bar sticky-top px-0 px-lg-4 py-2 py-lg-0">
   <div class="container">
      <nav class="navbar navbar-expand-lg navbar-light">
         <a href="MainServlet" class="navbar-brand p-0">
            <h1 class="display-6 text-primary">
               <i class="fas fa-car-alt me-3">

               </i></i>Cental</h1>
            <!-- <img src="img/logo.png" alt="Logo"> -->
         </a>

         <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="fa fa-bars"></span>
         </button>

         <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul  class="navbar-nav me-auto mb-2 mb-lg-0 py-0">

            </ul >

            <div class="d-flex">
            
                  <a class="navbar-brand" href="#">

                      <jsp:include page="${profilename}" />
                  </a>
            
            
                  <a href="PageSerlver?page=login.jsp" 
                     class="btn btn-primary btn-lg-square rounded-circle">
                     <i class="fas fa-user-circle "></i></a>

            
            </div>
         </div>
      </nav>
   </div>
</div>
