<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp" charEncoding="utf-8"></c:import>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href="indexController/showIndexPage">杰普电子商务门户</a> →
					<a href="orderController/orderPage">定单列表</a> →
					定单明细
                </td>
                </tr>
		</table>
              <br>

<%--
		<form name="order" method="post" action="../saveOrder.action"/>
--%>
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#ffffff"><b>用户信息</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right"><b>用户名</b>：</td>
			<td width="60%" class="tablebody1">${customerfromdb.name }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>联系地址</b>：</td>
			<td class="tablebody1">${customerfromdb.country}-${customerfromdb.province}-${customerfromdb.city}-${customerfromdb.street1 }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>邮编</b>：</td>
			<td class="tablebody1">${customerfromdb.zip }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>家庭电话</b>：</td>
			<td class="tablebody1">${customerfromdb.homephone }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>办公室电话</b>：</td>
			<td class="tablebody1">${customerfromdb.officephone }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>手机</b>：</td>
			<td class="tablebody1">${customerfromdb.cellphone }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>Email地址</b>：</td>
			<td class="tablebody1">${customerfromdb.email }</td>
		</tr>
	</table>
<br>

		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table2">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#FFFFFF"><b>付款方式</b></font></td>
		</tr>
		
		
		<tr>
			<td width="40%" class="tablebody2" align="right">　</td>
			<td width="60%" class="tablebody1">${order.payment }</td>
		</tr>
		</table>
		<br>
		
		
		
		
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1 id="table3">
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" colspan="5">
			<font color="#ffffff"><b>商品购物清单</b></font></td>
		</tr>
        
        <c:set var="count" value="0"></c:set>    
        <c:forEach items="${lines}" var="lines" varStatus="status">      
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${status.index + 1}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="../productDetail.jsp?productid=2" target="_blank">${lines.book.name}</a></td>
			<td class=tablebody2 valign=middle align=center width="">价格：${lines.book.price}</td>
			<td class=tablebody1 valign=middle align=center width="">数量：${lines.num}</td>
			<td class=tablebody2 valign=middle align=left width="">小计：￥${lines.book.price * lines.num}</td>
			<c:set var="count" value=" ${ lines.book.price * lines.num + count } " />
		</tr>
        </c:forEach>    
                  
               
                
		<tr>
			<td class=tablebody1 valign=middle align=left colspan="4">定单创建时间：${format}　</td>
			<td class=tablebody1 valign=middle align=left width="">合计：<font color="#ff0000"><b>￥${count }</b></font></td>
		</tr>
		        </table>
		</form>
		<br>
</p>

<c:import url="../footer.jsp"></c:import>