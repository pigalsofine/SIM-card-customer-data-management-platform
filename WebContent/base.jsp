<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
 <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
 <meta name="author" content="Łukasz Holeczek">
 <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
 <title>CoreUI Pro Bootstrap Admin Template</title>
 <link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
 <link rel="stylesheet" href="https://unpkg.com/@coreui/icons/css/coreui-icons.min.css">
 <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
 
</head>
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

	<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://unpkg.com/@coreui/coreui/dist/js/coreui.min.js"></script>
<style type="text/css">/* Chart.js */
@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style>
</head>

<body class="app header-fixed sidebar-fixed aside-menu-fixed sidebar-lg-show      pace-done">
 <div class="pace  pace-inactive">
  <div class="pace-progress" data-progress-text="100%" data-progress="99" style="transform: translate3d(100%, 0px, 0px);">
   <div class="pace-progress-inner">
   </div>
  </div>
  <div class="pace-activity">
  </div>
 </div>
 <header class="app-header navbar">
  <button class="navbar-toggler sidebar-toggler d-md-down-none" type="button" data-toggle="sidebar-lg-show">
   <span class="navbar-toggler-icon"></span>
  </button>
 </header>
 
  <div class="app-body">
  <div class="main_left">
   <div class="sidebar">
    <nav class="sidebar-nav ps ps--active-y">
     <ul class="nav">
      <li class="nav-item nav-dropdown">
       <a class="nav-link nav-dropdown-toggle" href="#">
        <i class="icons cui-home" > 物联网卡管理</i></a>
       <ul class="nav-dropdown-items">
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="login.jsp">
          <i class="nav-icon icon-puzzle"></i>  物联网卡入库</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/cardServlet?operator=tele">
          <i class="nav-icon icon-puzzle"></i>  电信物联网卡管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/cardServlet?operator=mobile">
          <i class="nav-icon icon-puzzle"></i>  移动物联网卡管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/diagnosisServlet">
          <i class="nav-icon icon-puzzle"></i>  诊断</a>
        </li>
       </ul>
      </li>
      <li class="nav-item nav-dropdown">
       <a class="nav-link nav-dropdown-toggle" href="#">
        <i class="icons  cui-layers"></i> 销售管理</a>
       <ul class="nav-dropdown-items">
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/customerServlet">
          <i class="nav-icon icon-puzzle"></i>  客户管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  物联网卡销售</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/orderServlet">
          <i class="nav-icon icon-puzzle"></i>  订单管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  合同管理</a>
        </li>
       </ul>
      </li>
      <li class="nav-item nav-dropdown">
       <a class="nav-link nav-dropdown-toggle" href="#">
        <i class="icons cui-puzzle"></i> 套餐管理</a>
       <ul class="nav-dropdown-items">
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/packetOriginalServlet?operator=tele">
          <i class="nav-icon icon-puzzle"></i>  电信原始套餐管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/packetOriginalServlet?operator=mobile">
          <i class="nav-icon icon-puzzle"></i>  移动原始套餐管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/packetSelflServlet">
          <i class="nav-icon icon-puzzle"></i>  自营套餐管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/rateServlet">
          <i class="nav-icon icon-puzzle"></i>  费率管理</a>
        </li>
       </ul>
      </li>
      <li class="nav-item nav-dropdown">
       <a class="nav-link nav-dropdown-toggle" href="#">
        <i class="icons cui-tablet"></i> 佣金管理</a>
       <ul class="nav-dropdown-items">
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  套餐返佣</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  一次性返佣</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  提现申请</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  账号返佣</a>
        </li>
       </ul>
      </li>
      <li class="nav-item nav-dropdown">
       <a class="nav-link nav-dropdown-toggle" href="#">
        <i class="icons cui-layers"></i> 系统管理</a>
       <ul class="nav-dropdown-items">
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/manager_roleServlet">
          <i class="nav-icon icon-puzzle"></i>  角色管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/companyServlet">
          <i class="nav-icon icon-puzzle"></i>  二级用户管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/passageServlet?operator=tele">
          <i class="nav-icon icon-puzzle"></i>  电信通道管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/passageServlet?operator=mobile">
          <i class="nav-icon icon-puzzle"></i>  移动通道管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/tagServlet">
          <i class="nav-icon icon-puzzle"></i>  标签管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/logServlet">
          <i class="nav-icon icon-puzzle"></i>  操作日志</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="servlet/reportServlet">
          <i class="nav-icon icon-puzzle"></i>  在线报障</a>
        </li>
       </ul>
      </li>
     </ul>
    </nav>
   </div>
  </div>
  </div>
  <div class="main">
   <iframe src="login.jsp" name="iframe_a" frameborder="1" marginheight="0" marginwidth="0" frameborder="0"  width="100%" height="100%" src="">
   </iframe>
  </div>
<script>
    $('#ui-view').ajaxLoad();
    $(document).ajaxComplete(function() {
      Pace.restart()
    });
  </script>
</body>