<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- sockjs는 라이브러리가 필요하다 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.2/sockjs.min.js"></script>
<script>
	//목표 : 연결버튼을 누르면 웹소켓연결, 종료버튼을 누르면 웹소켓종료를 하도록 구현
	$(function(){
		
		disconnectOperation();
		
		//연결버튼
		$(".connect-btn").click(function(){
			//표준 웹소켓을 이용할 경우 연결 코드
			//var uri = "ws://";
			//uri += location.host;
			//uri += "${pageContext.request.contextPath}";
			//uri += "/sockjsServer";
			//window.socket = new WebSocket(uri);
			
			//SockJS를 이용할 경우 연결 코드
			var uri = "${pageContext.request.contextPath}/sockjsServer"
			window.socket = new SockJS(uri);
			console.log(socket);
			
			//콜백(예약코드)함수 설정 - 표준 웹소켓과 동일하다
			socket.onopen = function(){
				connectOperation();
			};
			socket.onclose = function(){
				disconnectOperation();				
			};
			socket.onerror = function(){
				disconnectOperation();
			};
			socket.onmessage = function(){};
		});
		
		//종료버튼
		$(".disconnect-btn").click(function(){
			if(window.socket){
				window.socket.close();
			}
		});
		
	});
	
	function connectOperation(){//연결 시 화면 처리
		$(".connect-btn").prop("disabled", true);
		$(".disconnect-btn").prop("disabled", false);
	}
	function disconnectOperation(){//종료 시 화면 처리
		$(".connect-btn").prop("disabled", false);
		$(".disconnect-btn").prop("disabled", true);
	}
</script>

<h1>SockjsWebsocket 예제</h1>

<button class="connect-btn">연결</button>
<button class="disconnect-btn">종료</button>