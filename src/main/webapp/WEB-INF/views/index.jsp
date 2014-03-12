<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mopon</title>
<!--皮肤-->
    <link rel="stylesheet"  href="<%=basePath%>resources/themes/ext-theme-neptune/ext-theme-neptune-all.css" />
    <!--自定义桌面样式-->
    <link rel="stylesheet"  href="<%=basePath%>resources/css/desktop.css" />




    <!--动态加载js，引导文件-->
    <script src="<%=basePath%>lib/ext/bootstrap.js"></script>

    <!--语言本地化-->
    <script  src="<%=basePath%>lib/ext/ext-lang-zh_CN.js"></script>

    <!--样式修正-->
    <script  src="<%=basePath%>lib/ext/ext-theme-neptune.js"></script>




    <script>
         Ext.Loader.setConfig({
             //开启动态加载js文件功能，
             enabled: true,

             //动态载入js文件不附加随机数，即启用js文件缓存。调试时设置为false，否则firebug中打断点会无效。
             disableCaching: true,

             //载入类路径设置。
             paths:{
                 //应用名称对应的路径
                 'Wms': '<%=basePath%>app',

                 //针对Ext本身的一些功能扩展类存放路径 ，
                 // 扩展类应定义为  Ext.define('Ext.ux.ClassName'{.......})，并创建ClassName.js文件放在lib/ux/目录内
                 'Ext.ux':'<%=basePath%>lib/ux'
                 //'Wms.Application':'/app/Application.js'

             }
         });



         //初始化tips 提示框，
         Ext.QuickTips.init();

         //设置表单错误消息提示方式。
         Ext.form.Field.prototype.msgTarget = 'side';


         //创建命名空间
         Ext.ns("Wms");

         //预先载入Wms.Application，如果有其它自定义的类要使用，也应该以此方式   Ext.require('myClass');，在这里先载入
         Ext.require('Wms.Application');



         //创建一个用户对象，用于存储已登录的用户信息，此对象可以在服务端写入，
         // 此处为了方便Demo开发，直接写入一个User对象
         Wms.curUser={
             userName:"admin",
             signInTime:new Date().getDate(),
             roles:0,
             online:true,
             locked:false,
             authority:[
                 //新闻中心菜单项
                 {
                     type:"newsCenter",
                     menu:[
                         {menuName:"newsMgr",  add:true,  edit:true,  del:true },
                         {menuName:"newsTypeMgr",  add:true,  edit:true,  del:false }
                     ]
                 },

                 //Demo菜单项
                 {
                     type:"demo",
                     menu:[
                         {menuName:"file",  create:true,  open:true,  exit:true },
                         {menuName:"edit",  copy:true,  cut:true,  paste:true,search:true }
                     ]
                 }

             ]
         };




         //dom ready 后启动应用，即显示应用界面。实例化 Wms.Application类
        Ext.onReady(function () {
            Ext.create("Wms.Application");
        });
    </script>


    <!--自定义的工具类-->
    <script src="<%=basePath%>lib/tools/WmsTools.js"></script>
    
    <!--引入TinyMCE  htmleditor编辑器-->
    <script src="lib/tinymce/tiny_mce.js"></script>

    <script>

           //编辑器全局配置对象
        Wms.tinyCfg1 = {
            // 基本选项
            theme:"advanced", //使用高级选项
            language:"zh",   //使用中文
            skin:"extjs",    //使用extjs的样式
            inlinepopups_skin: "extjs",
            inline_styles: true,
            theme_advanced_row_height: 27,
           // delta_height: 0,
            convert_urls : false,
            relative_urls :true,
            media_use_script:true,

            //要添加那些插件
            plugins:"autolink,lists,pagebreak,style,layer,table,advhr,advimage,advlink,inlinepopups,media,searchreplace,contextmenu,paste,directionality,noneditable,visualchars,nonbreaking,advlist",

            // 样式选项，用来设置显示那些操作按钮
            theme_advanced_buttons1: "bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
            theme_advanced_buttons2:"cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,code,|,forecolor,backcolor",
            theme_advanced_buttons3:"tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,media,advhr,|,ltr,rtl",
            theme_advanced_toolbar_location: "top",
            theme_advanced_toolbar_align:"left",
            theme_advanced_statusbar_location: "bottom",

            //content_css: "Scripts/Extjs/ux/Form/site.css"

            // Drop lists for link/image/media/template dialogs
            template_external_list_url : "js/template_list.js",
            external_link_list_url : "js/link_list.js",
            external_image_list_url : "js/image_list.js",
            media_external_list_url : "js/media_list.js",

            // Replace values for the template plugin
            template_replace_values : {
                username : "Some User",
                staffid : "991234"
            }
        };


    </script>
    
    
</head>
<body>
	
</body>
</html>