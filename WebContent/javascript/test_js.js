function checkLogin() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var regex = /\w+/;
	if (!(regex.test(username) && regex.test(password))) {
		alert("输入格式不正确");
		return false;
	}
};

//function goPage() {
//	alert("更新成功");
//	var m = "updateCar";
//	window.open('/myShopping/ShoppingCIServlet?shopCLMess=' + m, '_self');
//};

function checkDel() {
	return window.confirm('真的要删除书吗？');
};

