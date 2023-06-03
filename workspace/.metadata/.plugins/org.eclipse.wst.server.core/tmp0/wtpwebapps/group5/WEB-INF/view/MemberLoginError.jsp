<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="http://localhost:8080/group5/css/jquery-ui.min.css">
<script src="http://localhost:8080/group5/js/jquery-ui.min.js"></script>
<link rel="stylesheet" href="sweetalert2.min.css">
<link rel="stylesheet" href="http://localhost:8080/group5/css/memberlogin.css">
<script src="https://kit.fontawesome.com/f3a13d5fed.js"
	crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script src="sweetalert2.min.js"></script>
<style>
	.loginForm input{
	margin-bottom: 0;
	}
</style>
<title>Member Login</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary navbar bg-dark"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="http://localhost:8080/group5/html/Home.html"> <i
				class="d-inline-block align-t
                ext-top fa-solid fa-gamepad"
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
				<!-- <a class="nav-link active" href="#">
                    <i class="fa-solid fa-user d-inline-block"></i>
                    Login</a> -->
			</div>
		</div>
	</nav>
	<div class="loginContainer">
		<div class="formContainer">
			<!-- 更改位置 -->
			<form method="post" action="./MemberLogin" class="loginForm">
				<div
					style="text-align: center; font-size: 40px; padding: 0; margin: 0">
					<i class="fa-solid fa-circle-user" style="font-size: 80px;"></i> <br>會員登入
				</div>
				<span>帳號</span><input type="text" name="email" id="email"
					placeholder="請輸入電子郵件"></Input> <br> <span>密碼</span><input
					type="password" name="memberPwd" id="" placeholder="請輸入密碼"></Input>
				<br> <span style="all: unset; color: red; margin-left: 10px"
					id="error">帳號或密碼錯誤，請重新輸入！</span>
				<div style="height: 40px">
					<Input type="checkbox" name="rememberMe" id="rememberMe" value="1"
						style="width: 20px" checked></Input> <label style="margin: 0;"
						for="rememberMe">記住我</label>
					<button type="submit" class="btn btn-info"
						style="margin-left: 193px; background-color: cornflowerblue; border: none;">下一步</button>
				</div>
				<hr>
				<a href="./MemberRegister.html"><button type="button"
						class="btn btn-info" data-bs-toggle="modal"
						data-bs-target="#register"
						style="margin-left: 0px; padding-left: 140px; padding-right: 140px; background-color: #8CA0D7; border: none;">註冊帳號</button></a>
				<br>
				<button type="button" class="btn btn-info"
					style="margin-top: 20px; margin-left: 0px; padding-left: 140px; padding-right: 140px; background-color: rgb(159, 209, 236); border: none;">忘記密碼</button>
			</form>
		</div>
	</div>

	<script>
		$("#email").on("focus", function() {
			$("#error").css("visibility", "hidden");
		})
		const params = new URLSearchParams(window.location.search);
		const register = params.get('register');
		if (register == 'success') {
			Swal.fire({
				position : 'top-center',
				icon : 'success',
				title : 'Registration successful',
				showConfirmButton : true,
			//timer: 1500

			})
			$(".swal2-height-auto").removeClass("swal2-height-auto");
		}
		if (register == 'unsuccess') {
			Swal.fire({
				position : 'top-center',
				icon : 'error',
				title : 'Email or phone number already exists',
				showConfirmButton : true,
			//timer: 1500

			})
			$(".swal2-height-auto").removeClass("swal2-height-auto");
		}
	</script>
</body>

</html>