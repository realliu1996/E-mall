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
        setTimeout(function(){$("#addjs").remove()},1000)
    }

</script>


<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href="indexController/showIndexPage">杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
	            <span>
		        <font color="#E3001B">${sessionScope.msg }</font>
	            </span>
                <c:remove var="msg" scope="session"/>
					欢迎<font color="blue">&nbsp;${sessionScope.customer.name }&nbsp;</font>光临！

            <span id="addjs" style="position: absolute;left: 1190px;top: 140px"><font color="red">${sessionScope.addmessage }</font></span>
            <c:remove var="addmessage" scope="session"/>
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
         
        
        <c:forEach items="${sessionScope.pageInfo.list}" var="book">
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${book.id}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="bookController/bookDetail/${book.id }">${book.name}</a></td>
			<td class=tablebody2 valign=middle align=center width="">${book.price}</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="/book_store/shoppingCarController/addOrderline/${book.id}">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>
        </c:forEach>

            <tr align="center" bgcolor="#FFFFFF">
                <td colspan="5">共${sessionScope.pageInfo.total }条记录 每页 3 条 第${sessionScope.pageInfo.pageNum }/${sessionScope.pageInfo.pageSize }页
                    <a	href="indexController/showIndexPage?page=1">首页</a>
                    <c:if test="${sessionScope.pageInfo.hasPreviousPage}">
                        <a href="indexController/showIndexPage?page=${sessionScope.pageInfo.prePage }">上一页</a>
                    </c:if>
                    <c:if test="${sessionScope.pageInfo.hasNextPage}">
                        <a href="indexController/showIndexPage?page=${sessionScope.pageInfo.nextPage }">下一页</a>
                    </c:if>
                    <a href="indexController/showIndexPage?page=${sessionScope.pageInfo.lastPage }">尾页</a>
                </td>
            </tr>
		</table>

<c:import url="footer.jsp"></c:import>