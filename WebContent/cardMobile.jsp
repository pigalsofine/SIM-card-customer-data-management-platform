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


<script>

	function updatModal(ip,id){/*点击修改按钮，给模态框加载信息并且弹出模态框*/
		$('#card_id').val(id);
		$('#ip').val(ip);
		$('#myModal').modal('show')
	}

	function set_card_status(start_ip_id, status){/*点击修改按钮，给模态框加载信息并且弹出模态框*/
		var form = document.getElementById("start_ip_form");
		$('#start_ip_id').val(start_ip_id);
		$('#status_id').val(status)
		form.submit();
	}

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

<script src="https://unpkg.com/element-ui/lib/index.js"></script>

</head>
<body class="" width="100%" height="100%" marginwidth="0" marginheight="0">
 <form action="servlet/cardServlet" id="start_ip_form" class="form-horizontal" role="form">
    <input type="hidden" id="operator" name="operator" class="form-control well" value="mobile"/>
 	<input type="hidden" id="start_ip_form" name="start_ip_form" class="form-control well" value="start_ip_form"/>
    <input type="hidden" id="start_ip_id" name="start_ip_id" class="form-control well" value=""/>
    <input type="hidden" id="status_id" name="status_id" class="form-control well" value=""/>
 </form>
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
             <th>ICCID</th>
             <th>IP</th>
             <th>我方卡号</th>
             <th>接入号码</th>
             <th>二级用户</th>
             <th>域名</th>
             <th>状态</th>
             <th>&nbsp;&nbsp;操作</th>
            </tr>
           </thead>
           <tbody>
           <%
           		ArrayList<Card> card_list = (ArrayList<Card>) session.getAttribute("card_list");
           		for (int i = 0; i < card_list.size(); i++){
           			if( card_list.get(i).getOperatorString().equals("移动") ) {
           %>
            <tr>
             <td><%= card_list.get(i).getICCID() %></td>
             <td><%= card_list.get(i).getIpString() %></td>
             <td><%= card_list.get(i).getCard_idString() %></td>
             <td><%= card_list.get(i).getNumberString() %></td>
             <td><%= card_list.get(i).getOwnerString() %></td>
			 <td><%= card_list.get(i).getDomainString() %></td>
			<% switch(card_list.get(i).getStatusInteger()){
			   case 1:%> <td>未激活</td> <% break;
			   case 2:%> <td>停机保号</td> <% break;
			   case 3:%> <td>在用</td> <% break;
			   case 4:%> <td>欠费停机</td> <% break;
			   case 5:%> <td>拆机</td> <% break;
			}
			 %>
			 <td>
			  <div class="dropdown">
               <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">操作
                <span class="caret"></span>
               </button>
               <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                <li role="presentation">
                 <a role="menuitem" tabindex="-1" href="#"> 详情</a>
                </li>
                <li role="presentation">
                 <a role="menuitem" tabindex="-1"  onclick="updatModal(<%=card_list.get(i).getIpString()%>,<%=card_list.get(i).getIdInteger()%>)"> 修改IP</a>
                </li>
                <li role="presentation">
                 <a role="menuitem" tabindex="-1"  onclick="updatModal()"> 设置标签</a>
                </li>
                <li role="presentation">
                 <a role="menuitem" tabindex="-1"  onclick="set_card_status(<%=card_list.get(i).getIdInteger()%>,'2')"> 停机保号</a>
                </li>
                <li role="presentation">
                 <a role="menuitem" tabindex="-1"  onclick="set_card_status(<%=card_list.get(i).getIdInteger()%>,'3')"> 启用</a>
                </li>
                <li role="presentation">
                 <a role="menuitem" tabindex="-1"  onclick="set_card_status(<%=card_list.get(i).getIdInteger()%>,'4')"> 欠费停机</a>
                </li>
                <li role="presentation">
                 <a role="menuitem" tabindex="-1"  onclick="set_card_status(<%=card_list.get(i).getIdInteger()%>,'5')"> 拆机</a>
                </li>
                </li>
               </ul>
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
 <div class="container">
    <!--  定义模态框触发器，此处为按钮触发  -->
  <form method="post" action="servlet/cardServlet?operator=mobile" class="form-horizontal" role="form" id="myForm" onsubmit="return ">
   <div class="modal fade" id="myModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
     <div class="modal-content">
      <div class="btn-info modal-header">
       <button type="button" class="close" data-dismiss="modal">&times;</button>
       <h4>修改IP</h4>
      </div>
      <div class="modal-body">
       <form class="form-horizontal" role="form">
        <div class="form-group">
         <label for="uname" class="col-sm-2 control-label">IP</label>
         <input type="hidden" id="form" name="form" class="form-control well" value="change_ip"/>
         <input type="hidden" id="card_id" name="card_id" class="form-control well"/>
         <div class="col-sm-9">
          <input type="text" id="ip" name="ip" class="form-control well" placeholder="请输入IP"/>
         </div>
        </div>
       </form>
      </div>
      <div class="modal-footer">
       <button type="submit" class="btn btn-info">确定</button>
       <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
      </div>
     </div><!-- /.modal-content -->
    </div>
   </div> <!-- /.modal -->
  </form>
 </div>
</body>
</html>
