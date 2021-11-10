window.addEventListener("load", function(){
    //작게 버튼에 대한 이벤트 처리
    document.querySelector("#btn-small").addEventListener("click", function(){
        //this == #btn-small 버튼
        var image = document.querySelector("#sample");
        image.width = 100;
        image.height = 100;
    });

    //보통 버튼에 대한 이벤트 처리
    document.querySelector("#btn-normal").addEventListener("click", function(){
        //this == #btn-normal 버튼
        var image = document.querySelector("#sample");
        image.width = 200;
        image.height = 200;
    });

    //크게 버튼에 대한 이벤트 처리
    document.querySelector("#btn-large").addEventListener("click", function(){
        //this == #btn-large 버튼
        var image = document.querySelector("#sample");
        image.width = 300;
        image.height = 300;
    });
});