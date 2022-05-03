const passwordInputs = document.querySelectorAll(".password-inputs");
const passwordUpdatebtn = document.querySelector(".password-update-btn");
const originPassword = passwordInputs[0].value;


function isEmpty(str) {
	return str == "" || str == "null" || typeof str == "undefined";
}


passwordUpdatebtn.onclick = () => {

	if (isEmpty(passwordInputs[1].value) || isEmpty(passwordInputs[2].value) || isEmpty(passwordInputs[3].value)) {
		alert("비밀번호를 작성해주세요.");
	} else if (originPassword != passwordInputs[1].value) {
		alert("이전 비밀번호를 확인해 주세요.");
	} else if (passwordInputs[1].value == passwordInputs[2].value) {
		alert("이전 비밀번호와 동일한 비밀번호는 사용할 수 없습니다.");
	} else if (passwordInputs[2].value != passwordInputs[3].value) {
		alert("새 비밀번호가 일치하지 않습니다.");
	} else {
		document.querySelector("form").submit();
	}

}





