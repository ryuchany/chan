<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.2/chart.js" integrity="sha512-7Fh4YXugCSzbfLXgGvD/4mUJQty68IFFwB65VQwdAf1vnJSG02RjjSCslDPK0TnGRthFI8/bSecJl6vlUHklaw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	$(function(){
		//시작하자마자 통계자료를 불러와서 화면에 출력
		$.ajax({
			url:"${pageContext.request.contextPath}/data/data11",
			type:"get",
			//data:{},
			dataType:"json",
			success:function(resp){
				console.log("성공", resp);
				
				draw("#myChart", resp);
			},
			error:function(e){}
		});
		
		$.ajax({
			url:"${pageContext.request.contextPath}/data/data12",
			type:"get",
			//data:{},
			dataType:"json",
			success:function(resp){
				console.log("성공", resp);
				
				draw("#myChart2", resp);
			},
			error:function(e){}
		});
	});
	function draw(selector, data){//select = 선택자 , data = JSON(List<ChartVO>)
		//ctx는 canvas에 그림을 그리기 위한 펜 객체(고정 코드)
		var ctx = $(selector)[0].getContext("2d");
	
		//List<ChartVO> 처럼 {text:?, count:?} 형태의 값이 List로 들어있는 data를
		//text만 뽑아서 배열 한 개를 만들고, count만 뽑아서 배열 한 개를 만든다
		
		var textArray = [];//text만 모아둘 배열
		var countArray = [];//count만 모아둘 배열
		
		for(var i=0; i < data.length; i++){
			textArray.push(data[i].text);
			countArray.push(data[i].count);
		}
	
	
		//var myChart = new Chart(펜객체, 차트옵션);
		var myChart = new Chart(ctx, {
		    type: 'bar', //차트의 유형
		    data: { //차트 데이터
		    	
		    	//하단 제목
		        labels: textArray,
		        datasets: [{
		            label: '조회수',//차트 범례
		            data: countArray,//실 데이터(하단 제목과 개수가 일치하도록 구성)
		            backgroundColor: [//배경색상(하단 제목과 개수가 일치하도록 구성)
		                'rgba(255, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(255, 206, 86, 0.2)',
		                'rgba(75, 192, 192, 0.2)',
		                'rgba(153, 102, 255, 0.2)',
		                'rgba(255, 159, 64, 0.2)'
		            ],
		            borderColor: [//테두리색상(하단 제목과 개수가 일치하도록 구성)
		                'rgba(255, 99, 132, 1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)',
		                'rgba(75, 192, 192, 1)',
		                'rgba(153, 102, 255, 1)',
		                'rgba(255, 159, 64, 1)'
		            ],
		            borderWidth: 5//테두리 두께
		        }]
		    },
		    options: {
		        scales: {
		            y: {
		                beginAtZero: true
		            }
		        }
		    }
		});
	}
</script>

<h1>차트 예제</h1>

<canvas id="myChart" width="400" height="400"></canvas>
<canvas id="myChart2" width="400" height="400"></canvas>