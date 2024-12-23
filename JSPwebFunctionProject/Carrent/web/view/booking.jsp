<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Carousel Start -->
<div class="header-carousel">
   <div id="carouselId" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">
      <ol class="carousel-indicators">
         <li data-bs-target="#carouselId" data-bs-slide-to="0" class="active" aria-current="true" aria-label="First slide"></li>
         <li data-bs-target="#carouselId" data-bs-slide-to="1" aria-label="Second slide"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
         <div class="carousel-item active">
            <img src="img/carousel-2.jpg" class="img-fluid w-100" alt="First slide"/>
            <div class="carousel-caption">
               <div class="container py-4">
                  <div class="row g-5">
                     <div class="col-lg-6 fadeInLeft animated" data-animation="fadeInLeft" data-delay="1s" style="animation-delay: 1s;">
                        <div class="bg-secondary rounded p-5">
                           <h4 class="text-white mb-4">CONTINUE CAR RESERVATION</h4>
                           <form action="MainServlet" method="post">
                              <div class="row g-3">

                                 <div class="col-12">
                                    <div class="input-group">
                                       <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                                          <span class="fas fa-map-marker-alt"></span> <span class="ms-1">Pick Up</span>
                                       </div>
                                       <input 
                                          name="pickUp_address"
                                          class="form-control" type="text"
                                          placeholder="Enter a City or Airport" 
                                          aria-label="Enter a City or Airport">
                                    </div>
                                 </div>

                                 <div class="col-12">

                                    <div class="input-group">
                                       <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                                          <span class="fas fa-map-marker-alt"></span><span class="ms-1">Drop off</span>
                                       </div>
                                       <input 
                                          class="form-control" type="text"
                                          name="dropoff_address"
                                          placeholder="Enter a City or Airport" 
                                          aria-label="Enter a City or Airport">
                                    </div>
                                 </div>

                                 <div class="col-12">
                                    <div class="input-group">
                                       <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                                          <span class="fas fa-calendar-alt"></span><span class="ms-1">Pick Up</span>
                                       </div>
                                       <input  name="pickup_date"  class="form-control" type="date">

                                    </div>
                                 </div>
                                 <div class="col-12">
                                    <div class="input-group">

                                       <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                                          <span class="fas fa-calendar-alt"></span><span class="ms-1">Drop off</span>
                                       </div>
                                       <input  name="dropoff_date" class="form-control" type="date">

                                    </div>
                                 </div>

                                 <div class="col-12">
                                    <button class="btn btn-light w-100 py-2">Select Car</button>
                                 </div>
                              </div>
                           </form>
                        </div>
                     </div>
                     <div class="col-lg-6 d-none d-lg-flex fadeInRight animated" data-animation="fadeInRight" data-delay="1s" style="animation-delay: 1s;">
                        <div class="text-start">
                           <h1 class="display-5 text-white">Get 15% off your rental Plan your trip now</h1>
                           <p>Treat yourself in USA</p>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>

      </div>
   </div>
</div>