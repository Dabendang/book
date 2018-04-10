<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="ctx" />
<!DOCTYPE html>
<html >
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        <link rel="stylesheet" type="text/css" href="${ctx}/css/application.css"/>
        <title>管理员主界面</title>
       
        <style type="text/css">
            body{margin:0;padding:0;overflow-x:hidden;}
            html, body{height:100%;}
            img{border:none;}
            *{font-family:'微软雅黑';font-size:12px;color:#626262;}
            dl,dt,dd{display:block;margin:0;}
            a{text-decoration:none;}
            #bg{background-image:url(/images/content/dotted.png);}
            .container{
            	width:100%;height:100%;margin:auto;
            	float:left;
            	}
            .foot{
                width: 150px;
            }

			/*head*/
			#content{
					   
					   width:1180px;
			}
			#header{
  					 height:80px;	
  					 border-bottom:2px solid blue;
  					 background:url(${ctx}/images/12.jpg) top left;
				}
			#productName{
 					  font-size:30px;
 					  font-weight:bold;
 					  float:left;
 					  padding:10px;
 					  margin-left:600px;
 					  
				}
            /*left*/
            .menus_area{
            width:160px;height:510px;float:left;background-color:#3992d0;}
            .line{height:2px;width:100%;background-image:url(/images/left/line_bg.png);background-repeat:repeat-x;}
            .menus_area dt{padding-left:40px;padding-right:10px;background-repeat:no-repeat;background-position:10px center;background-color: #3992d0;color:#f5f5f5;font-size:14px;position:relative;line-height:48px;cursor:pointer;}
            .menus_area dd{background-color:#317eb4;padding-left:40px;display: none;}
            .menus_area dd a{color:#f5f5f5;line-height:20px;}
            .menus_area dt img{position:absolute;right:10px;top:20px;}
            .system_log dt{background-image:url(${ctx}/images/left/system.png)}
            .custom dt{background-image:url(${ctx}/images/left/custom.png)}
            .channel dt{background-image:url(${ctx}/images/left/channel.png)}
            .app dt{background-image:url(${ctx}/images/left/app.png)}
            .cloud dt{background-image:url(${ctx}/images/left/cloud.png)}
            .syetem_management dt{background-image:url(${ctx}/images/left/syetem_management.png)}
            .source dt{background-image:url(${ctx}/images/left/source.png)}
            .statistics dt{background-image:url(${ctx}/images/left/statistics.png)}
            .menus_area dl dd:last-child{padding-bottom:10px;}
            dt.on{background-color: #317eb4}
        </style>
        
		<script type="text/javascript">
	      function logout(){
	         if(confirm('尊敬的管理员:${currentAdmin.nickname},您真的要离开系统吗？')){
                 window.location.href="${ctx}/backend/admin/logout";
	         }
	      }
		</script>
    </head>
    
    <body id="bg">
    <div id="main">
     <div id="header">
        <div id="productName">悦心网上书店系统</div>
     	<div style="float:right; margin-top:60px; font-weight:600;">
            	 管理员:${currentAdmin.nickname},&nbsp;
             <button class="" onclick="logout();" title="点击离开系统" >离开系统</button>
     	</div> 
     </div>
        <div class="container" style="width:100%">
            <div class="menus_area" id="menus_area">
                <div class="line"></div>

   <dl class="channel">
                    <dt>图书信息管理<img src="${ctx}/images/left/select_xl01.png"/></dt>
                    <dd class="first_dd"><a href="${ctx }/admin/book/book" target="contentFrame">增加图书</a></dd>
                    <dd><a href="${ctx }/admin/book/books" target="contentFrame">查阅图书</a></dd>
                </dl>

                <dl class="custom">
                    <dt>用户信息管理<img src="${ctx}/images/left/select_xl01.png"/></dt>
                    <dd><a href="${ctx}/backend/admin/getAllUserInfo" target="contentFrame">查阅用户</a></dd>
                    <dd><a href="${ctx}/backend/admin/toRecharge" target="contentFrame">用户充值</a></dd>
                </dl>

                <dl class="source">
                    <dt>订单管理<img src="${ctx}/images/left/select_xl01.png"/></dt>
                    <dd><a href="${ctx}/admin/order/getAllOrderInfo" target="contentFrame">查阅订单信息</a></dd>
                </dl>

                <dl class="app">
                    <dt>图书类型管理<img src="${ctx}/images/left/select_xl01.png"/></dt>
                    <dd><a href="${ctx}/admin/category/categories" target="contentFrame">查阅图书类型</a></dd>
                </dl>

                <dl class="statistics">
                    <dt>图书统计分析<img src="${ctx}/images/left/select_xl01.png"/></dt>
                    <dd class="first_dd"><a href="/admin/stock/getStockInfo" target="contentFrame">库存统计</a></dd>
                    <dd class="first_dd"><a href="/backend/admin/getUsersInfo" target="contentFrame">用户统计</a></dd>
                </dl>

            </div>
            <!-- iframe : inner frame(window)-->
          <div id="content">
			<iframe id="contentFrame" style="float:right;width:100%;height:510px;"
				scrolling="no" height="300px"  frameborder="0" name="contentFrame"
				allowtransparency="true" src='' align="left">

			</iframe>  
		  </div>   
      </div>
     </div> 
	<div class="foot">
     <%@ include file="footer.jsp"%>
     </div>
        <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
        <script type="text/javascript">

            $(function() {
                $("#menus_area").find("dt").hover(function() { //一级菜单点击
                    if (!$(this).hasClass("on")) { //当前一级菜单不选中状态才切换
                        $("#menus_area").find("dt").removeClass("on");//所有的一级菜单去除选中样式
                        $(this).addClass("on");//当前一级菜单去除选中样式
                        $('dd').slideUp();//所有二级菜单隐藏
                        $(this).nextAll('dd').slideToggle();//当前所有二级菜单切换
                    }
                });
            })
        </script>

    </body>

</html>