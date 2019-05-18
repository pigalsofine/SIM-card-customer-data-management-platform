<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    function openDialog(){
        paramers="dialogWidth:500px; dialogHeight:300px; status:no";
        workerId = window.showModalDialog("mm.jsp","",paramers);
       
        if(workerId!=undefined && workerId!=""){
           document.getElementById("leader").value = workerId;
          }
        }
</script>
</head>
<body>
   <form >
   <input type="text" id="leader" onclick="javascript:openDialog();"/>
    <input type="button" id="leader" onclick="javascript:openDialog();"/>

       </form>	
</body>
</html>