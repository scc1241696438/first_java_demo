/**
 * Created by qianghj on 2019/7/10.
 */


/**
 1. 当鼠标光标移开用户名输入框，就开始验证是否为空
  若为空，则显示消息提示
  若不为空，则是否是有效账户

 2. 当鼠标光标移开密码输入框，就开始验证是否为空
 若为空，则显示消息提示
 若不为空，则是否是有效密码

 3. 点击登录，验证用户名与密码
 */


//1. 验证用户名
function checkUsername(){
    //（1）获得id="username" 的输入值
    var username = document.querySelector("#username").value;
    console.log("username:"+username);

    //（2）判断用户名是否为空
    if(username == null || username== ""){
        document.querySelector("#username-err-tip").style.display ="block";     // id="username-err-tip" 的消息提示要显示
        return false;
    }else if(username == "1748343933"){  //用户名是正确的
        document.querySelector("#username-err-tip").style.display ="none";  // id="username-err-tip" 的消息提示要隐藏
        return true;
    }else{ //用户名是错误
        document.querySelector("#username-err-tip").style.display ="block";     // id="username-err-tip" 的消息提示要显示
        return false;
    }
}


//2. 验证密码
function checkPassword(){
    //（1）获得id="password" 的输入值
    var password = document.querySelector("#password").value;
    console.log("password:"+password);

    //（2）判断密码是否为空
    if(password == null || password== ""){
        document.querySelector("#password-err-tip").style.display ="block";     // id="password-err-tip" 的消息提示要显示
        return false;
    }else if(password == "123456"){  //密码是正确的
        document.querySelector("#password-err-tip").style.display ="none";  // id="password-err-tip" 的消息提示要隐藏
        return true;
    }else{ //密码是错误
        document.querySelector("#password-err-tip").style.display ="block";     // id="password-err-tip" 的消息提示要显示
        return false;
    }
}


//点击登录触发的方法
function login(){
        return checkUsername() && checkPassword();
}


