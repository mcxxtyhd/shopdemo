var focus = document.getElementsByClassName("focus"),
    username=document.getElementById("username"),
    password=document.getElementById("password");


/*用户名的黑色灰色点击切换*/
username.onfocus = function () {
    focus[0].style.color = "#ff0000";
};
username.onblur=function(){
    focus[0].style.color = "#000000";
};

/*密码的黑色灰色点击切换*/
password.onfocus = function () {
    focus[1].style.color = "#ff0000";
};
password.onblur=function(){
    focus[1].style.color = "#000000";
};
