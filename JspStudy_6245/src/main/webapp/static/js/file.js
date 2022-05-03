const fileUpload = document.querySelector(".file-upload");
const previewImg = document.querySelector(".preview-img");


fileUpload.onchange =()=>{
	previewImg.innerHTML ="";

	for(let i =0; i<fileUpload.files.length; i++){
		if(!isImage(fileUpload.files[i])){ // 이미지 인지 체크
		alert((i+1)+" 번 파일은 이미지가 아닙니다.");
		fileUpload.select();
		document.selection.clear();	
		previewImg.innerHTML ="";	
		return;
	}
	const reader = new FileReader();
	
	reader.onload=()=>{	
		const img = document.createElement("img");
		img.src = reader.result;	 //reader.readAsDataURL의 결과
		//img.innerHTML =`<img class ="preview-img-item" src="${reader.result}">`;
		previewImg.appendChild(img);	
		}
	reader.readAsDataURL(fileUpload.files[i]); //reader.onload 보다 먼저 실행		
	}
}

function isImage(file){
	console.log(file.type);
	return file.type.indexOf("image") >= 0; // 이미지 체크 함수
}