/**
 *  KH 정보교육원 수업 자료
 * 
 *  제작자 : 피카츄
 *  제작일 : 2021-11-10
 *  연락처 : 알아서뭐하게
 * 
 *  기능 설명 : 
 *  - class="confirm-link"인 a 태그에 확인창을 띄우도록 처리
 *  - textContent를 읽어서 "정말 OOO 하시겠습니까?" 형태의 확인창을 출력
 */

 window.addEventListener("load", function(){
    //모든 .confirm-link를 클릭하면 확인창이 표시되도록 변경
    var confirmLinkList = document.querySelectorAll("a.confirm-link");
    for(var i=0; i < confirmLinkList.length; i++){
        confirmLinkList[i].addEventListener("click", function(e){
            //this == 클릭한 .confirm-link
            var choice = confirm("정말 "+this.textContent+"하시겠습니까?");
            if(!choice){
                e.preventDefault();
            }
        });
    }
});