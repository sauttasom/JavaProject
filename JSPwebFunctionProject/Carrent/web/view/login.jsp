<div class="container py-4">
   <div class="row">
      <div class="col-3"></div>
      <div class="col-lg-6" >
         <div class="bg-secondary rounded p-5">
            <h4 class="text-white mb-4">Login</h4>
            <form action="LoginServlet" method="post" >
               <div class="row g-3">

                  <div class="col-12">
                     <div class="input-group">
                        <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                           <span class="ms-1">Username</span>
                        </div>
                        <input name="username" class="form-control" type="text">
                     </div>
                  </div>
                  <div class="col-12">
                     <div class="input-group">
                        <div class="d-flex align-items-center bg-light text-body rounded-start p-2">
                           <span class="ms-1">Password</span>
                        </div>
                        <input name="password" class="form-control" type="text">
                     </div>
                  </div>


                  <div class="col-12">
                     <button class="btn btn-danger w-100 py-2">Login</button>
                  </div>
               </div>
            </form>


         </div>
      </div>
      <div class="col-3"></div>
   </div>
</div>

