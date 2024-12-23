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

      <jsp:include page="${contentPage}" />

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