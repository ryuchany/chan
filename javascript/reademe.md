# 자바스크립트로 제어할 수 있는 요소
- 태그 선택 - `var tag = document.querySelector("선택자");`
	- 입력값 - `tag.value`
	- 속성 - `tag.id`, `tag.type` 등
	- 내부 글자 - `tag.textContent`, `tag.innerHTML`
	- 스타일 - `tag.style = "color:red;";`, `tag.style.color = "red";`
	- 클래스
        - `tag.className = "danger";`
		- `tag.classList.add("danger");`
		- `tag.classList.remove("danger");`
		- `tag.classList.contains("danger");`
- 이벤트	
    - click - 클릭했을 때
    - input - 입력이 발생했을 때
    - blur - 입력창에서 벗어나려 할 때
    - submit - 폼이 전송되려 할 때
    - load - 페이지가 로딩되었을 때


- 11/11
	# jQuery로 제어할 수 있는 요소별 명령

- style	
    - `$(선택자).css(항목, 값)` - 특정 스타일 항목을 특정 값으로 변경
	- `$(선택자).css(항목)` - 특정 스타일 항목을 확인(반환)
- value	
    - `$(선택자).val(값)` - value 설정
	- `$(선택자).val()` - value 반환
- textContent	
	- `$(선택자).text(값)` - textContent 설정
	- `$(선택자).text()` - textContent 반환
- innerHTML	
	- `$(선택자).html(값)` - innerHTML 설정
	- `$(선택자).html()` - innerHTML 반환
- attribute	
	- `.attr(항목, 값)` - 대상 태그에 작성된 항목 속성 글자를 설정
	- `.attr(항목)` - 대상 태그에 작성된 항목 속성 글자를 반환
	- `.prop(항목, 값)` - 대상 태그가 가지고 있는 항목에 대한 상태를 설정
	- `.prop(항목)` - 대상 태그가 가지고 있는 항목에 대한 상태를 반환
	- `.prop(항목)` - 대상 태그가 가지고 있는 항목에 대한 상태를 반환
- class
    - `.addClass(이름)` - 클래스 추가
    - `.hasClass(이름)` - 클래스 검사
    - `.removeClass(이름)` - 클래스 제거
    - `.toggleClass(이름)` - 클래스 토글
- visibility
    - `show()` , `slideDown()` , `fadeIn()` - 표시 명령
    - `hide()` , `slideUp()` , `fadeOut()` - 숨김 명령
    - `toggle()` , `slideToggle()` , `fadeToggle()` - 토글 명령
	