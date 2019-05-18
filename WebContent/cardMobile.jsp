<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="entity.Card"%>

<!DOCTYPE html>	
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
<meta name="author" content="Łukasz Holeczek">
<meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
<title>CoreUI Pro Bootstrap Admin Template</title>
<link href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" />
<link href="http://cdn.bootcss.com/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />
<link href="https://cdn.bootcss.com/flat-ui/2.3.0/css/flat-ui.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
<link href="vendors/@coreui/icons/css/coreui-icons.min.css" rel="stylesheet">
<link href="vendors/flag-icon-css/css/flag-icon.min.css" rel="stylesheet">
<link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="vendors/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

<link href="css/style.css" rel="stylesheet">
<link href="vendors/pace-progress/css/pace.min.css" rel="stylesheet">
<script async="" src="https://www.google-analytics.com/analytics.js"></script>
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
   <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
   <script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
   
  <script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
  <script src="https://unpkg.com/@coreui/coreui/dist/js/coreui.min.js"></script>
</head>
<body class="" width="100%" height="100%" marginwidth="0" marginheight="0">
 <div style="width:100%;position:absolute z-index:999; top:0;">
  <ol class="breadcrumb">
   <li class="breadcrumb-item">Home</li>
   <li class="breadcrumb-item">
    <a href="#">Admin</a>
   </li>
   <li class="breadcrumb-item active">Dashboard</li>
   <li class="breadcrumb-menu d-md-down-none">
    <div class="btn-group" role="group" aria-label="Button group">
     <a class="btn" href="#">
      <i class="icon-speech"></i>
     </a>
     <a class="btn" href="./">
      <i class="icon-graph"></i> &nbsp;Dashboard</a>
     <a class="btn" href="#">
      <i class="icon-settings"></i> &nbsp;Settings
     </a>
    </div>
   </li>
  </ol>
  <div class="container-fluid">
   <div id="ui-view">
   	<div>
   	 <div class="animated fadeIn">
      <div class="row">
       <div class="col-lg-12">
        <div class="card">
         <div class="card-header">
          <i class="fa fa-align-justify"></i> 电信通道管理
         </div>
         <div class="card-body">
          <table class="table table-responsive-sm table-striped">
           <thead>
            <tr>
             <th>接入号码</th>
             <th>卡号</th>
             <th>ICCID</th>
             <th>IMSI</th>
             <th>status</th>
             <th>tag</th>
             <th>start_time</th>
             <th>flow_used</th>
             <th>flow_total</th>
             <th> &nbsp;  &nbsp;操作</th>
            </tr>
           </thead>
           <tbody>
           <%
           		ArrayList<Card> card_list = (ArrayList<Card>) session.getAttribute("card_list");
           		for (int i = 0; i < card_list.size(); i++){
           			if( card_list.get(i).getOperatorString().equals("移动") ) {
           %>
            <tr>
             <td><%= card_list.get(i).getNumberString() %></td>
             <td><%= card_list.get(i).getCard_idString() %></td>
             <td><%= card_list.get(i).getICCID() %></td>
             <td><%= card_list.get(i).getIMSI() %></td>
             <td><%= card_list.get(i).getStatusInteger() %></td>
             <td><%= card_list.get(i).getTagString() %></td>
             <td><%= card_list.get(i).getStart_timeString() %></td>
			 <td><%= card_list.get(i).getFlow_usedFloat() %></td>
			 <td><%= card_list.get(i).getFlow_totalFloat() %></td>
			 <td>
			  <div class=" dropdown d-md-down-none ">
 				<a class="nav-link" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">操作</a>
  				<div class="dropdown-menu dropdown-menu-right dropdown-menu-lg">
  				 <a class="dropdown-item" href="#"><i class="icon-user-follow text-success"></i> New user registered</a>
 				</div>
			  </div>
			 </td>
            </tr>
            <% 		}
            	}
            %>
           </tbody>
          </table>
         </div>
        </div>
       </div>
      </div>
     </div>
    </div>
   </div>
  </div>
 </div>
</body>
</html>
