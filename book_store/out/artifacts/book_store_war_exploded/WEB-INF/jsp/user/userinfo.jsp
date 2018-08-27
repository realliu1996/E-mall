<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp" charEncoding="utf-8"></c:import>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>


<script type="text/javascript">


    window.onload=function(){
        setTimeout(function(){$("#js").remove()},1000)
    }

    $(function(){

        $("#password2").blur(function () {
            var password = $("#password").val();
            var password2 = $("#password2").val();
            if(password.length!=0 && password == password2)
            {
                $("#message1").html("<font color=\"#33CC00\">*两次密码相同</font>");
                $("#sub").removeAttr("disabled");
            }
            else if (password.length==0 ||password2.length==0){
                $("#message1").html("<font color=\"#E3001B\">*密码不能为空</font>");
                $("#sub").attr("disabled","disabled");
            }
            else {
                $("#message1").html("<font color=\"#E3001B\">*两次密码不相同</font>");
                $("#sub").attr("disabled","disabled");
            }
        })

        $("#password").blur(function () {
            var password = $("#password").val();
            if (password.length>5){
                $("#message2").html("<font color=\"#33CC00\">*密码可用</font>");
                $("#sub").removeAttr("disabled");
            }
            else if (password.length==0){
                $("#message2").html("<font color=\"#E3001B\">*密码不可为空</font>");
                $("#sub").attr("disabled","disabled");
            }
            else {
                $("#message2").html("<font color=\"#E3001B\">*密码不可用</font>");
                $("#sub").attr("disabled","disabled");
            }
        })


    });
</script>



<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="absmiddle">
                  <a href="indexController/showIndexPage">杰普电子商务门户</a> → 用户信息修改
                </td>
                </tr>
		</table>
              <br>

<form method="post" name="reg" action="customerController/customerUpdate">
	<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#ffffff"><b>用户信息修改</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>用户名</b>：<br>
			注册用户名长度限制为0－16字节</td>
			<td width="60%" class="tablebody1">
                <input type="hidden" name="id" value=${customer.id } >
			<input type="hidden" name="name" value=${customer.name } >
			<input type="text" maxLength="8" size="32" disabled value=${customer.name } style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			<font color="#FF0000">*</font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>密码(至少6位，至多8位)</b>：<br>
			请输入密码，区分大小写。<br>
			请不要使用任何类似 \'*\'、\' \' 或 HTML 字符'
			</td>
			<td width="60%" class="tablebody1">
			<input type="password" maxLength="8" size="32" id="password" name="password" value=${customer.password } style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                <span id="message2"><font color="#FF0000">*</font></span>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>密码(至少6位，至多8位)</b>：<br>
			请再输一遍确认</td>
			<td class="tablebody1">
			<input type="password" maxLength="8" size="32" id="password2" name="password2" value=${customer.password } style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                <span id="message1"><font color="#FF0000">*</font></span>
		</tr>
		<tr>
			<td class="tablebody1"><b>所在地区</b>：</td>
			<td class="tablebody1">
			<select name="country" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
				<option value=${customer.country }>${customer.country }</option>
				<option value="中国">中国</option>
				<option value="中国香港">中国香港</option>
				<option value="中国台湾">中国台湾</option>
			</select>
			<select name="province" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                
                <option value=${customer.province }>${customer.province }</option>
                                
                <option value="安徽" >安徽</option>

                <option value="北京" >北京</option>

                <option value="重庆" >重庆</option>

                <option value="福建" >福建</option>

                <option value="广东" >广东</option>

                <option value="甘肃" >甘肃</option>

                <option value="广西" >广西</option>

                <option value="贵州" >贵州</option>

                <option value="河南" >河南</option>

                <option value="湖北" >湖北</option>

                <option value="河北" >河北</option>

                <option value="海南" >海南</option>

                <option value="香港" >香港</option>

                <option value="黑龙江" >黑龙江</option>

                <option value="湖南" >湖南</option>

                <option value="吉林" >吉林</option>

                <option value="江苏" >江苏</option>

                <option value="江西" >江西</option>

                <option value="辽宁" >辽宁</option>

                <option value="澳门" >澳门</option>

                <option value="内蒙古" >内蒙古</option>

                <option value="宁夏" >宁夏</option>

                <option value="青海" >青海</option>

                <option value="四川" >四川</option>

                <option value="山东" >山东</option>

                <option value="上海" >上海</option>

                <option value="陕西" >陕西</option>

                <option value="山西" >山西</option>

                <option value="天津" >天津</option>

                <option value="台湾" >台湾</option>

                <option value="新疆" >新疆</option>

                <option value="西藏" >西藏</option>

                <option value="云南" >云南</option>

                <option value="浙江" >浙江</option>

                <option value="其它" >其它</option>
			</select>省
			<input type="text" size="8" name="city" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000" value=${customer.city }>市/县</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>联系地址1</b>：</td>
			<td class="tablebody1">
			<input type="text" size="64" maxlength="32" name="street1" value=${customer.street1 } style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>联系地址2</b>：</td>
			<td class="tablebody1">
			<input type="text" size="64" maxlength="32" name="street2" value=${customer.street2 } style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>邮编</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="8" name="zip" value=${customer.zip } style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>家庭电话</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="16" name="homephone" value=${customer.homephone } style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>办公室电话</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="16" name="officephone" value=${customer.officephone } style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>手机</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="16" name="cellphone" value=${customer.cellphone } style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>Email地址</b>：<br>
			请输入有效的邮件地址</td>
			<td class="tablebody1">
			<input maxLength="50" size="32" maxlength="32" name="email" value=${customer.email } style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"></td>
		</tr>
		<tr>
			<td class="tablebody2" valign="middle" colspan="2" align="center">
			<input id="sub" type="button" value="修 改" onclick="javascript:checkReg()">
            <span id="js"><font color="#E3001B" style="position: absolute;left: 820px;top: 535px">${sessionScope.updatemsg }</font></span></td>
            <c:remove var="updatemsg" scope="session"/>
		</tr>
	</table>
</form>

<c:import url="../footer.jsp"></c:import>