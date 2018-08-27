<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp" charEncoding="utf-8"></c:import>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<script type="text/javascript">

    window.onload=function(){
        setTimeout(function(){$("#msgjs").remove()},2000);
    }

</script>

<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2 >
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="absmiddle">
                  <a href="indexController/showIndexPage">杰普电子商务门户</a> → 用户登录

                </td>
                </tr>
		</table>
              <br>


	<form action="customerController/customerLogin" method=post name="login">
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle colspan=2 align=center height=25 background="images/bg2.gif" ><font color="#ffffff"><b>输入您的用户名、密码登录</b></font></td>
		</tr>
		<tr>
		<td valign=middle class=tablebody1>请输入您的用户名</td>
			<td valign=middle class=tablebody1><INPUT name=name type=text> &nbsp;
				<a href="customerController/registerPage">没有注册？</a>
			</td>
		</tr>
		<tr>
			<td valign=middle class=tablebody1>请输入您的密码</td>
			<td valign=middle class=tablebody1><INPUT name=password type=password>
                <span id="msgjs" style="position: absolute;left: 650px;top: 232px">
		            <font color="#E3001B" >${sessionScope.commonmsg }</font>
	            </span>
                <c:remove var="msg" scope="session"/>
            </td>

		</tr>
		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center><input type=button value="登 录" onclick="javascript:checkMe()"></td>
		</tr>
		</table>
	</form>

<c:import url="footer.jsp"></c:import>