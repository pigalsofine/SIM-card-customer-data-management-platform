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
<script async="" src="https://www.google-analytics.com/analytics.js"></script><script>
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
  
  <script type="text/javascript">
    window.onload = function () {
        function $(id) { return document.getElementById(id) }
        var menu = $("topTags").getElementsByTagName("ul")[0]; //顶部菜单容器
        var tags = menu.getElementsByTagName("li"); //顶部菜单
        var ck = $("leftMenu").getElementsByTagName("ul")[0].getElementsByTagName("li"); //左侧菜单
        var j;
        //点击左侧菜单增加新标签
        for (i = 0; i < ck.length; i++) {
            ck[i].onclick = function () {
                $("welcome").style.display = "none"//欢迎内容隐藏
                //循环取得当前索引
                for (j = 0; j < 8; j++) {
                    if (this == ck[j]) {
                        if ($("p" + j) == null) {
                            openNew(j, this.innerHTML); //设置标签显示文字
                        }
                        clearStyle();
                        $("p" + j).style.backgroundColor = "yellow";
                        clearContent();
                        $("c" + j).style.display = "block";
                    }
                }
               // return false;
            }
        }
        //增加或删除标签
        function openNew(id, name) {
            var tagMenu = document.createElement("li");
            tagMenu.id = "p" + id;
            tagMenu.innerHTML = name + "   " + "<img src='http://www.tjdadi.com.cn/off.gif' style='vertical-align:middle'/>";
            //标签点击事件
            tagMenu.onclick = function (evt) {
                clearStyle();
                tagMenu.style.backgroundColor = "yellow";
                clearContent();
                $("c" + id).style.display = "block";
            }
            //标签内关闭图片点击事件
            tagMenu.getElementsByTagName("img")[0].onclick = function (evt) {
                evt = (evt) ? evt : ((window.event) ? window.event : null);
                if (evt.stopPropagation) { evt.stopPropagation() } //取消opera和Safari冒泡行为;
                this.parentNode.parentNode.removeChild(tagMenu); //删除当前标签
                var color = tagMenu.style.backgroundColor;
                //设置如果关闭一个标签时，让最后一个标签得到焦点
                if (color == "#ffff00" || color == "yellow") {//区别浏览器对颜色解释
                    if (tags.length - 1 >= 0) {
                        clearStyle();
                        tags[tags.length - 1].style.backgroundColor = "yellow";
                        clearContent();
                        var cc = tags[tags.length - 1].id.split("p");
                        $("c" + cc[1]).style.display = "block";
                    }
                    else {
                        clearContent();
                        $("welcome").style.display = "block"
                    }
                }
            }
            menu.appendChild(tagMenu);
        }
        //清除标签样式
        function clearStyle() {
            for (i = 0; i < tags.length; i++) {
                menu.getElementsByTagName("li")[i].style.backgroundColor = "#FFCC00";
            }
        }
        //清除内容
        function clearContent() {
            for (i = 0; i < 7; i++) {
                $("c" + i).style.display = "none";
            }
        }
    }
</script>
</head>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
  <script src="https://unpkg.com/@coreui/coreui/dist/js/coreui.min.js"></script>
<style type="text/css">/* Chart.js */
@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style></head>


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
  <button class="navbar-toggler sidebar-toggler d-lg-none mr-auto" type="button" data-toggle="sidebar-show">
   <span class="navbar-toggler-icon"></span>
  </button>
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
        <i class="nav-icon icon-puzzle" ></i>物联网卡管理</a>
       <ul class="nav-dropdown-items">
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="login.jsp">
          <i class="nav-icon icon-puzzle"></i>  物联网卡入库</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  电信物联网卡管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  移动物联网卡管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  诊断</a>
        </li>
       </ul>
      </li>
      <li class="nav-item nav-dropdown">
       <a class="nav-link nav-dropdown-toggle" href="#">
        <i class="nav-icon icon-puzzle"></i>销售管理</a>
       <ul class="nav-dropdown-items">
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  客户管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  物联网卡销售</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
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
        <i class="nav-icon icon-puzzle"></i>套餐管理</a>
       <ul class="nav-dropdown-items">
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  电信原始套餐管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  移动原始套餐管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  自营套餐管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  费率管理</a>
        </li>
       </ul>
      </li>
      <li class="nav-item nav-dropdown">
       <a class="nav-link nav-dropdown-toggle" href="#">
        <i class="nav-icon icon-puzzle"></i>佣金管理</a>
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
        <i class="nav-icon icon-puzzle"></i>系统管理</a>
       <ul class="nav-dropdown-items">
        <li class="nav-item">
         <a class="nav-link" target="iframe_a" href="users_manager.jsp">
          <i class="nav-icon icon-puzzle"></i>  角色管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  二级用户管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  企业管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  电信通道管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  移动通道管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  标签类型管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  标签管理</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
          <i class="nav-icon icon-puzzle"></i>  操作日志</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="base/breadcrumb.html">
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
   <iframe src="login.jsp" name="iframe_a" frameborder="1"marginheight="0" marginwidth="0" frameborder="0" scrolling="no" width="100%" height="100%" src="">
   </iframe>
  </div>
<script>
    $('#ui-view').ajaxLoad();
    $(document).ajaxComplete(function() {
      Pace.restart()
    });
  </script>
</body>