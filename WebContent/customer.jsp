<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="entity.Customer, entity.Card"%>

<!DOCTYPE html>	
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
<meta name="author" content="Łukasz Holeczek">
<meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">

<link href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" />
<link href="http://cdn.bootcss.com/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />
<link href="https://cdn.bootcss.com/flat-ui/2.3.0/css/flat-ui.min.css" rel="stylesheet">


<script>

	function updatModal(id){/*点击修改按钮，给模态框加载信息并且弹出模态框*/
		$('#customer_id').val(id);
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
 <div style="width:100%;position:absolute z-index:999; top:0;">
  <ol class="breadcrumb">
   <li class="breadcrumb-menu d-md-down-none">
    <div class="btn-group" role="group" aria-label="Button group">
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
          <i class="fa fa-align-justify"></i> 客户管理
         </div>
         <div class="card-body">
          <table class="table table-responsive-sm table-striped">
           <thead>
            <tr>
             <th>用户账户</th>
             <th>姓名</th>
             <th>状态</th>
             <th>联系电话</th>
             <th>card id</th>
             <th>余额</th>
             <th>总流量</th>
             <th>使用流量</th>
             <th>操作</th>
            </tr>
           </thead>
           <tbody>
           <%
   				

   		
           		Map<Customer, Card> map_C_C = (Map<Customer, Card>) session.getAttribute("map_C_C");
				for (Map.Entry<Customer, Card> entry : map_C_C.entrySet()) {
   			%>
   			<tr>
   			 <th><%= entry.getKey().getAccountString() %></th>
   			 <th><%= entry.getKey().getNameString() %></th>
   			 <th>高</th>
   			 <th><%= entry.getKey().getPhoneString() %></th>
   			 <th><%= entry.getValue().getCard_idString() %></th>
   			 <th><%= entry.getValue().getRechargeFloat() %></th>
   			 <th><%= entry.getValue().getFlow_totalFloat() %></th>
   			 <th><%= entry.getValue().getFlow_usedFloat() %></th>
   			 <th>
			  <div class="dropdown">
               <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">操作
                <span class="caret"></span>
               </button>
               <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                <li role="presentation">
                 <a role="menuitem" tabindex="-1" href="#"> 详情</a>
                </li>
                <li role="presentation">
                 <a role="menuitem" tabindex="-1"  onclick="updatModal(<%=entry.getKey().getIdInteger()%>)"> 重置密码</a>
                </li>
                <li role="presentation">
                 <a role="menuitem" tabindex="-1"  onclick="updatModal()"> 设置标签</a>
                </li>
               </ul>
              </div>
			  </div>
			 </th>
   			<%
        
            	}
            %>
            </tr>
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
  <form method="post" action="servlet/customerServlet" class="form-horizontal" role="form" id="myForm" onsubmit="return ">
   <div class="modal fade" id="myModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
     <div class="modal-content">
      <div class="btn-info modal-header">
       <button type="button" class="close" data-dismiss="modal">&times;</button>
       <h4>修改密码</h4>
      </div>
      <div class="modal-body">
       <form class="form-horizontal" role="form">
        <div class="form-group">
         <label for="uname" class="col-sm-2 control-label">密码</label>
         <input type="hidden" id="form" name="form" class="form-control well" value="change_password"/>
         <input type="hidden" id="customer_id" name="customer_id" class="form-control well"/>
         <div class="col-sm-9">
          <input type="text" id="password" name="password" class="form-control well" placeholder="请输入密码"/>
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
