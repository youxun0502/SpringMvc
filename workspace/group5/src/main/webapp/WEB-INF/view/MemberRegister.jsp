<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<link rel="stylesheet"
	href="http://localhost:8080/group5/css/memberRegister.css">
<script src="https://kit.fontawesome.com/f3a13d5fed.js"
	crossorigin="anonymous"></script>
<title>Member Register</title>
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
	<div class="mainContainer">
		<h2>建立您的帳號</h2>
		<div class="registerFormContainer">
			<form:form method="post" action="../Member/InsertMember" class="form"
				modelAttribute="member" id="submitForm">
				<div>
					<span>帳號<span style="color: red; margin: 0; padding: 0;">*</span></span>
					<form:input type="text" path="userId" class="bootinput userId"
						value="" placeholder="請輸入帳號" required="true" autofocus="true"
						pattern="^[a-zA-Z0-9]+$" />
				</div>
				<span style="margin-left: 20px; display: none" id="userId1"><i
					class="fa-regular fa-circle-check"></i></span>
				<br>
				<div>
					<span>信箱<span style="color: red; margin: 0; padding: 0;">*</span></span>
					<form:input type="email" path="email" class="bootinput email"
						value="" placeholder="xxxx@xxxx.xxxx" required="true"
						pattern="^[^@\s]+@[^@\s]+\.[^@\s]+$" />
				</div>
				<span style="margin-left: 20px; display: none" id="email1"><i
					class="fa-regular fa-circle-check"></i></span>
				<br>
				<div>
					<span>密碼<span style="color: red; margin: 0; padding: 0;">*</span></span>
					<form:input type="password" path="memberPwd"
						class="bootinput memberPwd" value="" placeholder="請輸入6位數以上英數字"
						required="true" pattern="^[a-zA-Z0-9]{6,}$" />
				</div>
				<span style="margin-left: 20px; display: none" id="memberPwd1"><i
					class="fa-regular fa-circle-check"></i></span>
				<br>
				<div>
					<span>姓名<span
						style="color: red; margin: 0; padding: 0; visibility: hidden;">*</span></span>
					<form:input type="text" path="memberName" class="bootinput"
						value="" placeholder="請輸入姓名" />
				</div>
				<span style="margin-left: 20px; display: none" id="memberName1"><i
					class="fa-regular fa-circle-check"></i></span>
				<br>
				<div>
					<span>生日<span style="color: red; margin: 0; padding: 0;">*</span></span>
					<form:input type="text" path="birthday"
						class="bootinput birthday" value="" placeholder="請輸入生日"
						required="true" pattern="^\d{4}-\d{2}-\d{2}$" />
				</div>
				<span style="margin-left: 20px; display: none" id="birthday1"><i
					class="fa-regular fa-circle-check"></i></span>
				<br>
				<div>
					<span>電話<span style="color: red; margin: 0; padding: 0;">*</span></span>
					<form:input type="text" path="phone" class="bootinput phone"
						value="" placeholder="請輸入電話" required="true"
						pattern="^0[29]\d{8}$" />
				</div>
				<span style="margin-left: 20px; display: none" id="phone1"><i
					class="fa-regular fa-circle-check"></i></span>
				<br>
				<div>
					<span>性別</span> <label for="man"
						style="font-size: 24px; margin-right: 0; margin-left: 20px;">男</label>
					<form:radiobutton class="bootinput" path="gender" value="1"
						style="margin-right: 20px; margin-left: 5px; height: 20px"
						id="man" />
					<label for="woman" style="font-size: 24px; margin-right: 0;">女</label>
					<form:radiobutton class="bootinput" path="gender" value="2"
						style="margin-left: 5px; height: 20px" id="woman" />
				</div>
				<br>
				<form:input type="text" path="levelId" value=""
					style="display: none;" />
				<form:input type="text" path="account" value=""
					style="display: none;" />
				<form:input type="text" path="registrationDate" value=""
					id="registrationDate" style="display: none;" />
				<div>
					<input type="button" class="btn btn-primary bootup"
						style="width: 250px" value="註冊" onclick="submitForm()">
				</div>
				<div>
					<input type="button" class="btn btn-secondary bootup "
						style="width: 250px; margin-top: 5px;" value="一鍵輸入"
						onclick="autoInput()">
				</div>
			</form:form>
		</div>

	</div>



	<script>
		$(".userId").on("change", function() {
			let userId = $(".userId").val();
			let regex = /[a-zA-Z0-9]/;
			if (regex.test(userId)) {
				$("#userId1").css("display", "inline");
			} else {
				$("#userId1").css("display", "none");
			}
		})
		$(".email").on("change", function() {
			let email = $(".email").val();
			let regex = /^[^@\s]+@[^@\s]+\.[^@\s]+$/;
			if (regex.test(email)) {
				$("#email1").css("display", "inline");
			} else {
				$("#email1").css("display", "none");
			}
		})
		$(".memberPwd").on("change", function() {
			let memberPwd = $(".memberPwd").val();
			let regex = /[a-zA-Z0-9]{6,}/;
			if (regex.test(memberPwd)) {
				$("#memberPwd1").css("display", "inline");
			} else {
				$("#memberPwd1").css("display", "none");
			}
		})
		$(".birthday").on("change", function() {
			let birthday = $(".birthday").val();
			let regex = /^\d{4}-\d{2}-\d{2}$/;
			if (regex.test(birthday)) {
				$("#birthday1").css("display", "inline");
			} else {
				$("#birthday1").css("display", "none");
			}
		})
		$(".phone").on("change", function() {
			let phone = $(".phone").val();
			let regex = /^0[29]\d{8}$/;
			if (regex.test(phone)) {
				$("#phone1").css("display", "inline");
			} else {
				$("#phone1").css("display", "none");
			}
		})

		$("#birthday").datepicker({
			dateFormat : "yy-mm-dd"
		})
		function submitForm() {
			var currentDate = new Date();
			var formattedDate = $.datepicker
					.formatDate('yy-mm-dd', currentDate);
			document.querySelector("#registrationDate").value = formattedDate;
			document.querySelector("#submitForm").submit();
		}

		function autoInput() {
			$("#userId").val("XiaoMing").trigger("change");
			$("#email").val("XiaoMing123@gmail.com").trigger("change");
			$("#memberPwd").val("XiaoMing123").trigger("change");
			$("#memberName").val("XiaoMing").trigger("change");
			$("#birthday").val("2000-05-01").trigger("change");
			$("#phone").val("0908666444").trigger("change");
			$('input[name="gender"][value="1"]').prop('checked', true).trigger("change");
		}
	</script>
</body>

</html>