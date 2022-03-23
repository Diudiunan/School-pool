
var IDTAB = false;
var PASSTAB = false;
var VERIFYTAB = false;

//ID检查
function LOFO(ID){
	if(ID.value==""){
		IDTAB = false;
	}else{
		IDTAB = true;
	}
}

//密码检查
function checkpass(PW){
	if(PW.value==""){
		PASSTAB = false;
	}else{
		PASSTAB = true;
	}
}

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

function ChangeVicon(){
	var vicon = document.getElementById("Vicon");
	vicon.src = "/MyShoppingSystem/ser/getverify?" + new Date().getTime();
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
		}
		alert("请检查:"+STR)
		return false;
	}
}
