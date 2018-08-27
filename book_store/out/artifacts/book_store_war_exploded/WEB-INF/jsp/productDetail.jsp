<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" charEncoding="utf-8"></c:import>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

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
            <a href="indexController/showIndexPage">杰普电子商务门户</a> → 产品明细

            <span id="addjs" style="position: absolute;left: 1190px;top: 140px"><font color="red">${sessionScope.addmessage }</font></span>
            <c:remove var="addmessage" scope="session"/>
        </td>
    </tr>
</table>
<br>

<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
    <tr>
        <td valign=middle align=center height=25 background="images/bg2.gif" colspan="2"><p><font color="#ffffff"><b>${book.name}</b></font></td>
    </tr>
    <tr>
        <td class=tablebody1 valign=middle align=center width="20%">【
            作&nbsp; 者 】</td>
        <td class=tablebody1 valign=middle width="80%">&nbsp;&nbsp;${book.author}</td>
    </tr>
    <tr>
        <td class=tablebody1 valign=middle align=center width="20%">【
            价&nbsp; 格 】</td>
        <td class=tablebody1 valign=middle width="80%">&nbsp;&nbsp;${book.price}</td>
    </tr>
    <tr>
        <td class=tablebody1 valign=middle align=center width="">【出 版 社】</td>
        <td class=tablebody1 valign=middle width="">&nbsp;&nbsp;${book.publish}</td>
    </tr>
    <tr>
        <td class=tablebody1 valign=middle align=center width="">【 书&nbsp; 号
            】</td>
        <td class=tablebody1 valign=middle width="">&nbsp;&nbsp;${book.id}</td>
    </tr>
    <tr>
        <td class=tablebody1 valign=middle align=center width="">【 页&nbsp; 码
            】</td>
        <td class=tablebody1 valign=middle width="">&nbsp;&nbsp;${book.page}</td>
    </tr>
    <tr>
        <td class=tablebody1 valign=middle align=center width="">【所属类别】</td>
        <td class=tablebody1 valign=middle width="">&nbsp;&nbsp;${book.sort}</td>
    </tr>
    <tr>
        <td class=tablebody1 align=center width="" valign="top">【 简&nbsp; 介
            】</td>
        <td class=tablebody1 valign=middle width="">&nbsp;&nbsp;${book.introduction}</td>
    </tr>
    <tr>
        <td class=tablebody1 valign=middle align=center width="">　</td>
        <td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<img border="0" src="images/product/zcover${book.id }.gif" width="127" height="180"></td>
    </tr>
    <tr>
        <td class=tablebody2 valign=middle align=center colspan="2"><a href="bookController/addOrderline/${book.id}">
            <img border="0" src="images/buycar.gif" width="92" height="21"></a> </td>
    </tr>
</table>

<c:import url="footer.jsp"></c:import>
