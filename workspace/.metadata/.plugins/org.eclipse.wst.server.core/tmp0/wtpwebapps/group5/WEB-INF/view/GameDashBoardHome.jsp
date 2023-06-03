<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + "/";
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link rel="stylesheet" href="<%=basePath%>css/style.css">
<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
<script src="<%=basePath%>js/GameDashBoardHome.js"></script>
<style>
* td {
	padding-left: 10px;
	padding-top: 10px;
	padding-bottom: 10px;
}
</style>
<title>GameDashBoard</title>
</head>
<body onload="showGames()">
	<!-- 背景跟樣式 -->
	<nav class="navbar navbar-expand-lg bg-body-tertiary navbar bg-dark"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="http://localhost:8080/group5/Main/GoBackToHome"> <i
				class="d-inline-block align-text-top fa-solid fa-gamepad"
				style="color: #ffc107; font-size: 1.5em;">CARBON</i>
			</a>
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

	<!-- 邊欄 -->
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
							<a class="navbar-brand" style="font-size: 30px;">Game</a>
							<div class="d-flex" role="search">
								<input class="form-control me-2" type="search"
									placeholder="Search" aria-label="Search" name="gname">
								<button class="btn btn-outline-warning" type="submit"
									id="findName">Search</button>
								<input type="hidden" name="action" value="searchByName" />
							</div>
						</div>
					</nav>
				</div>
				<ul class="nav nav-tabs">
					<li class="nav-item">
						<form method="get" action="<%=basePath%>DashHome.controller">
							<div>
								<input class="nav-link active" type="submit" name="getItem"
									value="ALL" />
							</div>
						</form>
					</li>
					<li class="nav-item">
						<div>
							<input class="nav-link " type="submit" name="insert"
								value="New Game" data-bs-toggle="modal" data-bs-target="#create" />
						</div>
					</li>
				</ul>

				<!-- table 列表 -->
				<div align="center">
					<div style="margin: 50px;">
						<table border="1" id="example"
							class="hover row-border order-column table table-striped table-dark">
							<thead>
								<tr style="background-color: #a8fefa">
									<th scope="col">遊戲編號
									<th scope="col">遊戲名稱
									<th scope="col">遊戲價格
									<th scope="col">創建日期
									<th scope="col">遊戲介紹
									<th scope="col">遊戲圖片
									<th scope="col">購買人數
									<th scope="col">遊戲狀態
									<th scope="col">更新
									<th scope="col">刪除
							</thead>
							<tbody id="showAllGame">
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
	<div class="modal fade " id="create" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true"
		style="color: black">
		<div class="modal-dialog" onload="RunForm()">
			<form class="needs-validation" method="post" id="gameForm"
				action="<%=basePath%>create.controller"
				enctype="multipart/form-data" novalidate>
				<div class="modal-content"
					style="background-color: #262424; color: white;">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Create New
							Game</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<table id="CTable">
							<tbody>
								<tr>
									<td>遊戲名稱
									<td><input type="text" name="GameName" id="copyName"
										class="form-control" required /> <span id="username_err"
										style="display: none; color: yellow;"><em>不要抄襲</em></span> <span
										class="invalid-feedback" style="color: rgb(238, 146, 146);"><em>No
												Name???Are you sure???</em> </span></td>
								<tr>
									<td>遊戲價格
									<td><input type="text" name="Price" class="form-control"
										required pattern="^\d+(\.\d+)?$" /> <span
										class="invalid-feedback" style="color: rgb(238, 146, 146);"><em>Please
												enter Number</em> </span>
								<tr>
									<td>上架時間
									<td><input type="date" name="CreateDate"
										value="2002-01-01" class="form-control" />
										<div class="valid-feedback" style="color: rgb(114, 245, 132);">
											<em>Looks good!</em>
										</div>
								<tr>
									<td>遊戲介紹
									<td><input type="text" name="GameIntroduce"
										class="form-control" required />
										<div class="valid-feedback" style="color: rgb(114, 245, 132);">
											<em>Looks good!</em>
										</div>
										<div class="invalid-feedback"
											style="color: rgb(238, 146, 146);">
											<em>Lazy!</em>
										</div>
								<tr>
									<td>圖片
									<td><input type="file" name="GamePicPath"
										accept=".png,.jpg,.gif" class="form-control" required
										id="file" /> <img id="demo"
										style="width: 150px; display: none" />
										<div class="invalid-feedback"
											style="color: rgb(238, 146, 146);">
											<em>????</em>
										</div>
								<tr>
									<td>購買人數
									<td><input type="text" name="BuyerCount"
										class="form-control" pattern="[0-9]{1,}" required />
										<div class="valid-feedback" style="color: rgb(114, 245, 132);">Looks
											good!</div>
										<div class="invalid-feedback"
											style="color: rgb(238, 146, 146);">
											<em>Give me the Number!</em>
										</div>
								<tr>
									<td>上架狀態
									<td style="text-align: center"><input type="radio"
										name="Status" value="0" checked /><em>關閉</em> <input
										type="radio" name="Status" value="1" style="margin-left: 50px" /><em>開啟</em>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary" onclick="RunForm();">確定</button>
					</div>
				</div>
			</form>
		</div>
	</div>
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
	  let basePath = '<%=basePath%>'
	  
	  //----------------------取得全部遊戲資訊
	  function showGames(){
	      let allTable = document.querySelector('#example');
	      
	      const xhttp =new XMLHttpRequest();
	      xhttp.onload = function(){
	          if (this.status === 200 ) {
	              gamesInfos = JSON.parse(this.response);
	              showGameContent(gamesInfos);
	          }
	      }
	      xhttp.open("Post", "<%=basePath%>
		getAllgames.controller");
			xhttp.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xhttp.send("action=query")

			allTable.style.display = "";
		}

		//---------------------命名不得重複
		document.getElementById("copyName").onblur = function() {
			var username = this.value;

			var xhttp;
			if (window.XMLHttpRequest) {
				xhttp = new XMLHttpRequest();
			} else {
				xhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xhttp.open("GET", basePath + 'serchName.controller?username='
					+ username);
			xhttp.send();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					if (this.responseText == "true") {
						document.getElementById("username_err").style.display = '';
						$('#confirm').prop('disabled', true);
					} else {
						document.getElementById("username_err").style.display = 'none';
						$('#confirm').prop('disabled', false);
					}
				}
			}
		}
	</script>

</body>
</html>