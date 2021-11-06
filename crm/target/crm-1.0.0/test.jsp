<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>


$.ajax({
        url :"",
        data : {

        },
        type:"",
        dataType:"json",
        success : function (data){

        }
})


//创建时间是当前时间
String createTime = DateTimeUtil.getSysTime();
String createBy = ((User)request.getSession().getAttribute("user")).getName();

</body>
</html>
