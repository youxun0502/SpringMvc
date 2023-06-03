<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="./MemberMain.jsp" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
<link rel="stylesheet"
	href="http://localhost:8080/group5/css/jquery-ui.min.css">
<script src="http://localhost:8080/group5/js/jquery-ui.min.js"></script>
<style>
.area1 {
	position: absolute;
	width: 80%;
	margin: 180px 250px;
}

.formContainer {
	width: 600px;
	position: relative;
	left: 25%;
	border: 1px solid rgba(240, 248, 255, 0.527);
	background-color: rgba(240, 248, 255, 0.527);
	border-radius: 10px;
	display: flex;
	justify-content: center;
	padding-top: 40px;
	padding-bottom: 40px;
}

form div {
	display: flex;
	justify-content: start;
	margin: 0;
}

.span {
	padding-bottom: 2.5px;
	padding-top: 2.5px;
	padding-left: 5px;
	background-color: blueviolet;
	font-size: 22px;
}
</style>
</head>

<body>
	<fmt:formatDate value="${member.birthday}" pattern="yyyy-MM-dd"
		var="memberBirthday" />
	<c:set var="birthday" value="${memberBirthday}" />
	<div class="context">
		<div class="area1">
			<div class="formContainer">
				<form:form action="Update" class="form" modelAttribute="member">
					<input name="action" value="update" style="display: none;">
					<div style="display: none;">
						<span class="span">id：</span>
						<form:input type="text" path="id" value="${member.id}" />
					</div>
					<div style="display: none;">
						<span class="span">帳號：</span>
						<form:input type="text" path="userId" value="${member.userId}" />
					</div>
					<div>
						<span class="span">信箱：</span>
						<form:input type="text" path="email" value="${member.email}" readonly="true" />
					</div>
					<br>
					<div>
						<span class="span">密碼：</span>
						<form:input type="text" path="memberPwd"
							value="${member.memberPwd}" placeholder="請輸入6位數以上英數字" required="true"
							pattern="^[a-zA-Z0-9]{6,}$" />
					</div>
					<br>
					<div>
						<span class="span">姓名：</span>
						<form:input type="text" path="memberName"
							value="${member.memberName}" 
							placeholder="請輸入姓名" />
					</div>
					<br>
					<div>
						<span class="span">生日：</span>
						<form:input type="text" path="birthday" id="mydate"
							value="${birthday}" placeholder="請輸入生日" required="true"
							pattern="^\d{4}-\d{2}-\d{2}$" />
					</div>
					<br>
					<div>
						<span class="span">性別：</span>
						<form:input type="text" path="gender" value="${member.gender}" />
					</div>
					<br>
					<div>
						<span class="span">電話：</span>
						<form:input type="text" path="phone" value="${member.phone}"
							readonly="true" />
					</div>
					<br>
					<div>
						<span class="span">等級：</span>
						<form:input type="text" path="levelId" value="${member.levelId}"
							required="true" />
					</div>
					<br>
					<div>
						<span class="span">帳戶：</span>
						<form:input type="text" path="account" value="${member.account}" />
					</div>
					<br>
					<div style="display: none;">
						<span class="span">註冊日期：</span>
						<form:input type="date" path="registrationDate"
							value="${ member.registrationDate}" readonly="true"/>
					</div>
					<br>
					<div>
						<input type="submit" style="margin-left: 100px;" value="更新">
					</div>
				</form:form>
			</div>

		</div>
	</div>

	<script>
		$("#mydate").datepicker({
			dateFormat : "yy-mm-dd"
		});

		$(".container-fluid a").last().text(
				`MEMBER : ${member.id}_${member.userId}`);
	</script>
</body>

</html>