<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js"></script>
<link rel="stylesheet"
	href="http://localhost:8080/group5/css/jquery-ui.min.css">
<script src="http://localhost:8080/group5/js/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://localhost:8080/group5/css/home.css">
<script src="https://kit.fontawesome.com/f3a13d5fed.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/css/lightslider.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/js/lightslider.min.js"></script>


<style>
body {
	background-color: #3652c0;
}

.imgContainer {
	width: 800px;
	height: 490px;
	position: absolute;
	top: 104px;
	left: 200px;
	background-color: rgba(255, 255, 255, 0.452);
}

#imageGallery li img {
	width: 800px;
}

/* 
        aside {
            width: 200px;
            height: 100%;

        } */
.title {
	font-size: 40px;
	color: azure;
	position: absolute;
	top: 50px;
	left: 200px;
}

.topGame {
	position: absolute;
	top: 40px;
	height: 95vh;
	width: 100vw;
}

.gameselect {
	width: 200px;
	height: 300px;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}

.gameSelect1 {
	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0),
		rgb(235, 88, 88)),
		url("http://localhost:8080/group5/img/gameclass1.jpg");
}

.gameSelect2 {
	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0),
		rgb(201, 35, 252)),
		url("http://localhost:8080/group5/img/gameclass2.jpg");
}

.gameSelect3 {
	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0),
		rgb(255, 201, 54)),
		url("http://localhost:8080/group5/img/gameclass3.jpg");
}

.gameSelect4 {
	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0),
		rgb(172, 168, 168)),
		url("http://localhost:8080/group5/img/gameclass4.jpg");
}

.gameSelect5 {
	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0),
		rgb(114, 231, 247)),
		url("http://localhost:8080/group5/img/gameclass5.jpg");
}

.gameSelect1:hover {
	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0),
		rgb(248, 67, 67)),
		url("http://localhost:8080/group5/img/gameclass1.jpg");
}

.gameSelect2:hover {
	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0),
		rgb(170, 13, 218)),
		url("http://localhost:8080/group5/img/gameclass2.jpg");
}

.gameSelect3:hover {
	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0),
		rgb(252, 189, 16)),
		url("http://localhost:8080/group5/img/gameclass3.jpg");
}

.gameSelect4:hover {
	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0),
		rgb(121, 118, 118)),
		url("http://localhost:8080/group5/img/gameclass4.jpg");
}

.gameSelect5:hover {
	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0),
		rgb(28, 206, 230)),
		url("http://localhost:8080/group5/img/gameclass5.jpg");
}

.gameSelectorContainer {
	width: 800px;
	height: 300px;
	position: absolute;
	top: 700px;
	left: 200px;
	background-color: rgba(255, 255, 255, 0.452);
}

.srotByCLass {
	font-size: 40px;
	color: azure;
	position: absolute;
	top: 645px;
	left: 200px;
}
</style>
<title>Member Login</title>
</head>

<body>

	<nav class="navbar navbar-expand-lg bg-body-tertiary navbar bg-dark"
		data-bs-theme="dark" style="padding: 0">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <i
				class="d-inline-block align-text-top fa-solid fa-gamepad"
				style="color: #6fb7d4; font-size: 1.5em;">Carbon</i>
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<div class="navbar-nav me-auto mb-2 mb-lg-0"></div>
				<a class="nav-link active"
					href="#"
					style="background-color: rgb(72, 168, 247); padding: 8px; margin: 0px; border: 2px solid rgb(72, 168, 247); margin-right: 10px;">
					<i class="fa-solid fa-user d-inline-block"></i>
					${memberBeans.userId }
				</a>
				<form method="post"
					action="http://localhost:8080/group5/Main/ManagerLogout">
					<button type="submit" class="btn btn-secondary btn-sm"
						style="margin-left: 10px;">logout</button>
				</form>
			</div>
		</div>
	</nav>

	<!-- <aside>




    </aside> -->
	<div class="topGame">
		<div class="title">精選遊戲</div>
		<div class="imgContainer">
			<ul id="imageGallery">
				<li><img src="http://localhost:8080/group5/img/homegame1.jpg" />

				</li>
				<li><img src="http://localhost:8080/group5/img/homegame2.jpg" />
				</li>
				<li><img src="http://localhost:8080/group5/img/homegame3.jpg" />
				</li>
				<li><img src="http://localhost:8080/group5/img/homegame4.jpg" />
				</li>
				<li><img src="http://localhost:8080/group5/img/homegame5.jpg" />
				</li>
			</ul>
		</div>
	</div>

	<div class="gameSelector">
		<div class="srotByCLass">依類別瀏覽</div>
		<div class="gameSelectorContainer">
			<ul id="gameclass">
				<li>
					<div class="gameselect gameSelect1"></div>
					<div
						style="width: 200px; background-color: rgb(248, 67, 67); text-align: center;">經典</div>
				<li>
					<div class="gameselect gameSelect2"></div>
					<div
						style="width: 200px; background-color: rgb(170, 13, 218); text-align: center;">冒險</div>
				</li>
				<li>
					<div class="gameselect gameSelect3"></div>
					<div
						style="width: 200px; background-color: rgb(252, 189, 16); text-align: center;">博弈</div>
				</li>
				<li>
					<div class="gameselect gameSelect4"></div>
					<div
						style="width: 200px; background-color: rgb(121, 118, 118); text-align: center;">益智</div>
				</li>
				<li>
					<div class="gameselect gameSelect5"></div>
					<div
						style="width: 200px; background-color: rgb(28, 206, 230); text-align: center;">趣味</div>
				</li>
			</ul>
		</div>


	</div>



	<script>
		$("#imageGallery").lightSlider({
			// 參數設定[註1]
			slideWidth : 600, // 物件寬度
			speed : 400, // 切換速度
			pause : 2000, // 當等待時間超過此時，則自動切換
			auto : true, // 自動切換
			item : 1, // 顯示數量
			responsive : [ {
				breakpoint : 960, // 當螢幕大於此寬度時，則啟用此設定值
				settings : {
					item : 1, // 顯示數量
					slideMove : 1
				// 一次切換數量
				}
			}, {
				breakpoint : 640, // 當螢幕大於此寬度時，則啟用此設定值
				settings : {
					item : 1, // 顯示張數
					slideMove : 1
				// 一次切換數量
				}
			} ]

		});

		$("#gameclass").lightSlider({
			// 參數設定[註1]
			slideWidth : 600, // 物件寬度
			speed : 400, // 切換速度
			pause : 2000, // 當等待時間超過此時，則自動切換
			auto : false, // 自動切換
			item : 4, // 顯示數量
			responsive : [ {
				breakpoint : 960, // 當螢幕大於此寬度時，則啟用此設定值
				settings : {
					item : 4, // 顯示數量
					slideMove : 1
				// 一次切換數量
				}
			}, {
				breakpoint : 640, // 當螢幕大於此寬度時，則啟用此設定值
				settings : {
					item : 4, // 顯示張數
					slideMove : 1
				// 一次切換數量
				}
			} ]

		});
	</script>
</body>



</html>