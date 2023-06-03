<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">


<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<!-- <link rel="stylesheet" href="../css/main_style.css" type="text/css"> -->
<style>
body {
	position: relative;
	width: 100%;
	height: 910px;
	background-color: rgb(22, 22, 24);
	background-image:
		url("https://images.unsplash.com/photo-1619170743049-4688803388b4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80");
	background-size: 2000px;
	background-repeat: no-repeat;
	color: rgb(242, 236, 236);
}

.aside {
	position: absolute;
	width: 200px;
	height: 100%;
	background-color: rgb(33, 37, 41);
	left: 0;
	padding-top: 30px;
}

.content {
	position: absolute;
	width: calc(100% - 200px);
	height: 100%;
	left: 200px;
	display: flex;
	justify-content: center;
}

.area {
	width: 100%;
	position: absolute;
}

.searchBar {
	width: 100%;
	background-color: rgb(22, 22, 24);
	padding-top: 20px;
}

.searchBar form {
	padding: 0 20px;
}
</style>
<title>HOMEPAGE</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary navbar bg-dark"
		data-bs-theme="dark">
		<div class="container-fluid">

			<form method="post"
				action="http://localhost:8080/group5/Main/GoBackToHome">
				<button type="submit" class="navbar-brand"
					style="background-color: transparent; border-color: transparent;">
					<i class="d-inline-block align-text-top fa-solid fa-gamepad"
						style="color: #ffc107; font-size: 1.5em;">CARBON</i>
				</button>
			</form>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<div class="navbar-nav me-auto mb-2 mb-lg-0"></div>

				<a class="nav-link active" href="#"> <i
					class="fa-solid fa-user d-inline-block"></i> ${managerBeans.userId }
				</a>
				<!-- 更改為管理員帳號名稱 -->
				<form class="d-flex " method="post"
					action="http://localhost:8080/group5/Main/ManagerLogout">
					<button type="submit" class="btn btn-secondary btn-sm"
						style="margin-left: 10px;">
						<i class="fa-solid fa-right-from-bracket"></i>
						<!-- Logout -->
					</button>
				</form>

			</div>
		</div>
	</nav>

	<aside class="aside">
		<nav class="nav flex-column">
			<a class="nav-link active link-light" aria-current="page"
				href="http://localhost:8080/group5/Member/memberMain">MEMBER</a> <a
				class="nav-link link-light"
				href="http://localhost:8080/group5/DashHome.controller">GAME</a> <a
				class="nav-link link-light"
				href="http://localhost:8080/group5/gameitem.controller">GAME
				ITEM</a> <a class="nav-link link-light"
				href="http://localhost:8080/group5/bonusitemmain">SHOP</a> <a
				class="nav-link link-light"
				href="http://localhost:8080/group5/EventMain">EVENT</a> <a
				class="nav-link link-light"
				href="http://localhost:8080/group5/discussionmain">DISCUSSIONS</a>
		</nav>
	</aside>


	<div class="content">
		<div class="area">
			<div class="contentHeader">
				<div class="searchBar">
					<nav class="navbar ">
						<div class=" container-fluid">
							<a class="navbar-brand" style="font-size: 30px;">EVENT</a>
							<form class="d-flex" role="search" method="post"
								action="SearchCompetition">
								<input class="form-control me-2" type="search"
									placeholder="請輸入賽事名稱" aria-label="Search" name="gameName"
									autocomplete="off">
								<button class="btn btn-outline-warning" type="submit">Search</button>
							</form>
						</div>
					</nav>
				</div>
				<ul class="nav nav-tabs">
					<li class="nav-item">
						<!-- <a class="nav-link" href="#">Link</a> -->
						<form method="post" action="AllCompetition">
							<div>
								<input class="nav-link active" type="submit"
									name="allCompetition" value="ALL" />
							</div>
						</form>
					</li>
					<li class="nav-item">
						<form method="post" action="InsertPage">
							<div>
								<input class="nav-link active" type="submit" name="create"
									value="CREATE" />
							</div>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script src="https://kit.fontawesome.com/f3a13d5fed.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
	<script>
		$(function() {

		})
	</script>
</body>

</html>