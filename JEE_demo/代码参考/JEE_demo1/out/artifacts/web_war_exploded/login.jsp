<%--
  Created by IntelliJ IDEA.
  User: qianghj
  Date: 2019/11/18
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <!--  引入外部css文件 -->
    <link rel="stylesheet" href="css/login.css">


</head>
<body>
<div class="lt-rt">
    <form  action="login" method="post" >
        <!--密码登录标题-->
        <span class="login-by-pwd">密码登录</span>
        <span style="color:red;font-size: 10px;margin-left: 30px" >${loginMsg}</span>
        <!-- 用户名或 密码错误提示-->
        <div class="login-err">
            <span class="tip-logo"></span>
            <span class="login-err-tip" >${loginMsg}</span>
        </div>



        <!--用户输入 用户名与密码-->
        <div class="input-area">
            <div class="username-area">
                <span class="username">账号</span>
                <div class="tip"  id="username-err-tip">
                    <span class="tip-logo"></span>
                    <span class="tip-msg">请输入正确的51Job账号</span>
                </div>

            </div>
            <!-- 用户名输入框
            onblur 事件：当光标移开输入框时，会触发checkUsername()
            -->
            <input type="text" id="username" placeholder="请输入用户名或邮箱"  name="username">
        </div>

        <div class="input-area">
            <div class="username-area">
                <span class="username">密码</span>
                <div class="tip" id="password-err-tip">
                    <span class="tip-logo"></span>
                    <span class="tip-msg">请输入正确的密码</span>
                </div>

            </div>
            <!-- 密码输入框-->
            <input type="password" placeholder="请输入用户密码"  id="password" name="userpwd">
        </div>

        <!-- 自动登录 忘记密码区域-->
        <div class="lr-ok">
            <div class="auto-login">
                <input type="checkbox" >
                <span>自动登录</span>
            </div>
            <div class="forget-pwd">
                <a href="">忘记密码?</a>
            </div>
        </div>

        <!--登录按钮
            onclick : 单击事件
        -->
        <input type="submit" class="login-btn"  value="登录"/>
        <!--  <button class="login-btn" onclick="checkLogin()"> 登录 </button>-->

        <!-- 第三方登录的控件-->
        <div class="third-part-login-logo">
            <div class="wechat-logo"> </div>
            <div class="qq-logo"> </div>
            <div class="weibo-logo"> </div>
        </div>

    </form>
</div>




<!-- 引入外部js文件 -->
<%--<script src="js/login.js"></script>--%>
</body>
</html>
