

var IDTAB = false;
var PASSTAB = false;
var VERIFYTAB = false;

function changeicon1(V){
	
	var ICON = document.getElementById("ICON1");
	var PASS = document.getElementsByName("PASSWORD")[0];
	var SRC1 = "../images/icons/icons8-closed-eye-24.png";
	var SRC2 = "../images/icons/icons8-eye-24.png";
	if(V === "2"){
		ICON.src = SRC1;
		PASS.type = "password";
		ICON.value = "1";
	}else{
		ICON.src = SRC2;
		PASS.type = "text";
		ICON.value = "2";
	}
}

function changeicon2(V){
	
	var ICON = document.getElementById("ICON2");
	var PASS = document.getElementsByName("PASSWORD")[1];
	var SRC1 = "../images/icons/icons8-closed-eye-24.png";
	var SRC2 = "../images/icons/icons8-eye-24.png";
	if(V === "2"){
		ICON.src = SRC1;
		PASS.type = "password";
		ICON.value = "1";
	}else{
		ICON.src = SRC2;
		PASS.type = "text";
		ICON.value = "2";
	}
}

function ChangeVicon(){
	var vicon = document.getElementById("Vicon");
	vicon.src = "/MyShoppingSystem/ser/getverify?" + new Date().getTime();
}

//获得焦点
function FOON(){
	var IIS = document.getElementById("IIS");
	IIS.style.visibility = "visible";
}

//验证申请账号唯一性
function LOFO(ID){
	var IIS = document.getElementById("IIS");
	if(ID.value == ""){
		IIS.style.visibility = "hidden";
	}else{
		var ajax = new XMLHttpRequest();
		var URL = "/MyShoppingSystem/ser/registeridsame?ID="+encodeURI(ID.value)+"&"+new Date().getTime();
		ajax.open('GET',URL);
		ajax.send();
		ajax.onreadystatechange = function(){
			if(ajax.status==200&&ajax.readyState==4){
				IIS.src = "../images/icons/icons8-done-48.png";
				IDTAB = true;
			}else{
				IIS.src = "../images/icons/icons8-cross-mark-48.png";
				IDTAB = false;
			}
			//console.log(ajax.status);
		}
	}
}

//密码确认
function checkpass(){
	var Pass = document.getElementsByClassName("password");
	var pass1 = Pass[0];
	var pass2 = Pass[1];
	if (pass1.value==""||pass2.value==""){
		pass1.style.color='black';
		pass2.style.color='black';
		PASSTAB = false;
	}else {
		if(pass1.value==pass2.value){
			pass1.style.color='green';
			pass2.style.color='green';
			PASSTAB = true;
		}else{
			pass1.style.color='red';
			pass2.style.color='red';
			PASSTAB = false;
		}
	}
}

//验证验证码是否正确
function CVCODE(CV){
	var SubM = document.getElementById("Submit");
	if(CV.value == ""){
		CV.style.color='yellow';
		SubM.style.backgroundColor='skyblue';
	}else{
		var ajax = new XMLHttpRequest();
		var URL = "/MyShoppingSystem/ser/getverify?vcode="+encodeURI(CV.value)+"&"+new Date().getTime();
		ajax.open('POST',URL);
		ajax.send();
		ajax.onreadystatechange = function(){
			if(ajax.readyState==4&&ajax.status==1){
				CV.style.color='green';
				SubM.style.backgroundColor='green';
				SubM.type = "submit";
				VERIFYTAB = true;
			}else{
				CV.style.color='red';
				SubM.style.backgroundColor='red';
				VERIFYTAB = false;
			}
		}
	}
}

//表单验证拦截
function verifyfrom(From){
	alert(String(IDTAB) + String(PASSTAB) + String(VERIFYTAB))
	if(IDTAB&&PASSTAB&&VERIFYTAB){
		console.log("1");
		return true;
	}else{
		var STR="";
		if(!IDTAB){
			STR += " 用户名 ";
		}
		if(!PASSTAB){
			STR += " 密码 ";
		}
		if(!VERIFYTAB){
			STR += " 验证码 ";
			alert('q')
		}
		alert("请检查:"+STR)
		return false;
	}
}