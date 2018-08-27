<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" charEncoding="utf-8"></c:import>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


<script type="text/javascript">

    window.onload=function(){
        setTimeout(function(){$("#orderjs").remove()},1000)
    }

</script>

<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href="indexController/showIndexPage">杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					订单列表
            <span id="orderjs" style="position: absolute;left: 1260px;top: 140px"><font color="red">${sessionScope.ordermessage }</font></span>
            <c:remove var="ordermessage" scope="session"/>
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单编号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单金额</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单状态</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>付款方式</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
        
        
        <c:forEach items="${orderall}" var="orderall" varStatus="status">      
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${status.index + 1}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="orderController/datailOrder/${orderall.id }">${orderall.id}</a></td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;￥${orderall.cost}</td>
			<td class=tablebody1 valign=middle align=center width="">pending</td>
			<td class=tablebody2 valign=middle align=center width="">&nbsp;&nbsp;${orderall.payment} </td>
			<td class=tablebody1 valign=middle align=center width="">
			<input type="button" value="删除" onclick="javascript:window.location='orderController/delOrder/${orderall.id}';">&nbsp;<input type="button" value="明细" onclick="javascript:window.location='orderController/datailOrder/${orderall.id }';"><!--&nbsp;<input type="button" value="修改"/>--> </td>
		</tr>
        </c:forEach>           
                
         </table><br>
<c:import url="footer.jsp"></c:import>
