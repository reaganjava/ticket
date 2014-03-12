<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录</title>

    <!--皮肤-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/themes/ext-theme-neptune/ext-theme-neptune-all.css" />
    <!--自定义桌面样式-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/desktop.css" />




    <!--动态加载js，引导文件-->
    <script type="text/javascript" src="<%=basePath%>lib/ext/bootstrap.js"></script>

    <!--语言本地化-->
    <script type="text/javascript" src="<%=basePath%>lib/ext/ext-lang-zh_CN.js"></script>

    <!--修正样式缺陷-->
    <script type="text/javascript" src="<%=basePath%>lib/ext/ext-theme-neptune.js"></script>

    <script type="text/javascript" src="<%=basePath%>app/SignIn.js"></script>






    <script type="text/javascript">

        //tips 提示框，表单错误消息提示方式。
        Ext.QuickTips.init();
        Ext.form.Field.prototype.msgTarget = 'side';



        Ext.onReady(function () {


            //显示登录
            Wms.view.signin.SignIn.show();


        });

    </script>
</head>
<body>

</body>
</html>