<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>	
<html>
<head>
<base href="./">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
<meta name="author" content="Łukasz Holeczek">
<meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
<title>CoreUI Pro Bootstrap Admin Template</title>

<link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">>
<script async="" src="https://w	ww.google-analytics.com/analytics.js"></script>
<script>
    (function(i, s, o, g, r, a, m) {
      i['GoogleAnalyticsObject'] = r;
      i[r] = i[r] || function() {
        (i[r].q = i[r].q || []).push(arguments)
      }, i[r].l = 1 * new Date();
      a = s.createElement(o), m = s.getElementsByTagName(o)[0];
      a.async = 1;
      a.src = g;
      m.parentNode.insertBefore(a, m)
    })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');
    ga('create', 'UA-118965717-1', 'auto');
    ga('send', 'pageview');
    </script>
  <script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://unpkg.com/@coreui/coreui/dist/js/coreui.min.js"></script>
</head>
  <body class="app flex-row align-items-center  pace-done">
 <div class="pace  pace-inactive">
  <div class="pace-progress" data-progress-text="100%" data-progress="99" style="transform: translate3d(100%, 0px, 0px);">
   <div class="pace-progress-inner">
   </div>
  </div>
  <div class="pace-activity"></div>
 </div>
 <div class="container">
  <div class="row justify-content-center">
   <div class="col-md-8">
    <div class="card-group">
     <div class="card p-4">
      <div class="card-body">
       <h1>Login</h1>
       <p class="text-muted">Sign In to your account</p>
       <form action="servlet/dologinServlet" method="post">
        <div class="input-group mb-3">
         <input class="form-control" type="text" placeholder="Username">
        </div>
        <div class="input-group mb-4">
         <input class="form-control" type="password" placeholder="Password">
        </div>
        <div class="row">
         <div class="col-6"> 
          <button class="btn btn-primary px-4" type="submit">Login</button>
         </div>
        </div>
       </form>
      </div>
     </div>
     <div class="card text-white bg-primary py-5 d-md-down-none" style="width:44%">
      <div class="card-body text-center">
       <div>
        <h2>Sign up</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        <button class="btn btn-primary active mt-3" type="button">Register Now!</button>
       </div>
      </div>
     </div>
    </div>
   </div>
  </div>
 </div>

 <script>
    $('#ui-view').ajaxLoad();
    $(document).ajaxComplete(function() {
      Pace.restart()
    });
 </script>
</body>
</html>
