<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.content {
	width : 800px;
	height : 600px;
	text-align : center;
}
</style>
</head>
<body>
<div class="content">
<div id="slideshow">
<img src="images/background1.PNG" style="width:800px;height:600px;" alt="이미지를 확인해 주세요.">
<img src="images/background2.PNG" style="width:800px;height:600px;" alt="이미지를 확인해 주세요.">
<img src="images/background3.PNG" style="width:800px;height:600px;" alt="이미지를 확인해 주세요.">
</div>
<script>
	var slideShow = function(container) {
    	this.images = [];
    	this.curImage = 0;
    	for (i = 0; i < container.childElementCount; i++) {
        	this.images.push(container.children[i]);
        	this.images[i].style.display = "none";
    	}
    	// Handle going to to the next slide
    	var nextSlide = function() {
        	for (var i = 0; i < this.images.length; i++) {
            	this.images[i].style.display = "none";
        	}
        	this.images[this.curImage].style.display = "block";
        	this.curImage++;
        	if (this.curImage >= this.images.length) {
            	this.curImage = 0;
        	}
        	window.setTimeout(nextSlide.bind(this), 2000);
    	};
    
    	nextSlide.call(this);
	};
	slideShow(document.getElementById("slideshow"));
</script>
</div>
</body>
</html>