const profileInput = document.querySelectorAll(".profile-input");
const updateSubmitBtn = document.querySelector(".update-submit-btn");
const passwordUpdateBtn = document.querySelector(".password-update-btn");

const originPricopal = {
	"name": profileInput[0].value,
	"email": profileInput[1].value
};


function isEmpty(str) { // 빈값을 체크
	return str == "" || str == null || str == "undefined";
}



updateSubmitBtn.onclick = () => {
	let name = profileInput[0].value;
	let email = profileInput[1].value;

	if (isEmpty(name)) {
		alert("이름을 입력해 주세요.")
	} else if (isEmpty(email)) {
		alert("이메일을 입력해 주세요")
	} else if (originPricopal.name == name && originPricopal.email == email) {
		//기존 데이터과 현재 데이터를 비교
		alert("수정할 정보가 없습니다.")
	} else {
		document.querySelector("form").submit(); //submit와 동일
		//alert("회원정보 수정 요청");

	}
}



