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
        setTimeout(function(){$("#deljs").remove()},1000)
    }

</script>

<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href="indexController/showIndexPage">杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					购物清单

            <span id="deljs" style="position: absolute;left: 1260px;top: 140px"><font color="red">${sessionScope.delmessage }</font></span>
            <c:remove var="delmessage" scope="session"/>
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>数量</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>合计</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>

		<c:set var="count" value="0"></c:set>
        <c:forEach items="${shoppingCarAll}" var="shoppingCar" varStatus="status">

		<tr>
			<form method="post" action="shoppingCarController/updateProduct" name="f1">
			<input type="hidden" id="productid" name="productid" value=${shoppingCar.key }>
			<td class=tablebody2 valign=middle align=center width="">${status.index + 1}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="bookController/bookDetail/${shoppingCar.key }">${shoppingCar.value.book.getName() }</a></td>
			<td class=tablebody2 valign=middle align=center width="">${shoppingCar.value.book.getPrice()}</td>
			<td class=tablebody1 valign=middle align=center width=""><input type="text"  name="num" value=${shoppingCar.value.num } size="4" onblur="javascript:if(this.value<1){alert('对不起，产品数量不能小于 1 ');this.value=${shoppingCar.value.num };this.focus();}else{number.value=this.value;}"/></td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;${ shoppingCar.value.num * shoppingCar.value.book.getPrice()}</td>
			<c:set var="count" value=" ${ shoppingCar.value.num * shoppingCar.value.book.getPrice() + count } " />
			<td class=tablebody1 valign=middle align=center width="">
			<input type="button" value="取消" onclick="javascript:window.location='shoppingCarController/removeProduct/${shoppingCar.key }';"> <input  type="submit" value="保存修改"></td>
			</form>
		</tr>


		</c:forEach>
                      
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width="">&nbsp;&nbsp;<font color="#ff0000"><b>￥${count }</b></font></td>
			<td class=tablebody1 valign=middle align=center width="">　</td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle align=center colspan="6"><input type="button" value="提交订单" onclick="javascript:window.location='orderController/confirmOrder';"> <input type="button" value="继续购物" onclick="javascript:window.location='indexController/showIndexPage';"> <input type="button" value="清空购物车" onclick="javascript:window.location='shoppingCarController/removeAllProduct';"></td>
		</tr>
        </table><br>

<c:import url="footer.jsp"></c:import>