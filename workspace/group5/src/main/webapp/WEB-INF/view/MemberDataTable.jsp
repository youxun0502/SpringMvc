<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./MemberMain.jsp" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
<link rel="stylesheet"
	href="http://localhost:8080/group5/css/table_style.css" type="text/css">

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<style>
.area1 {
	position: absolute;
	width: 80%;
	margin: 180px 250px;
}

table {
	background-color: rgb(33, 37, 41);
}
</style>
</head>

<body>

	<div class="context">
		<div class="area1">
			<table id="example" class="hover row-border order-column"
				style="width: 100%;">
				<thead>
					<tr>
						<th>id</th>
						<th>帳號</th>
						<th>信箱</th>
						<th>密碼</th>
						<th>姓名</th>
						<th>生日</th>
						<th>性別</th>
						<th>電話</th>
						<th>等級</th>
						<th>帳戶</th>
						<th>註冊日期</th>
						<th>更新</th>
						<th>刪除</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${member}" var="memberBean" varStatus="c">
						<tr>
							<td>${memberBean.id}</td>
							<td>${memberBean.userId}</td>
							<td>${memberBean.email}</td>
							<td>${memberBean.memberPwd}</td>
							<td>${memberBean.memberName}</td>
							<td><fmt:formatDate value="${memberBean.birthday}"
									pattern="yyyy-MM-dd" /></td>
							<td>${memberBean.gender}</td>

							<td>${memberBean.phone}</td>
							<td>${memberBean.levelId}</td>
							<td>${memberBean.account}</td>
							<td><fmt:formatDate value="${memberBean.registrationDate}"
									pattern="yyyy-MM-dd" /></td>
							<td>
								<form method="post" action="UpdateForm">
									<input name="action" value="updateForm" style="display: none;">
									<button type="submit" value="${memberBean.id}" name="id">更新</button>
								</form>
							</td>
							<td>
								<form method="post" action="Delete">
									<button type="submit" value="${memberBean.id}" name="id"
										onclick="return confirm('確定刪除此筆資料?')">刪除</button>
								</form>
							</td>
						</tr>
						<c:set var="count" value="${c.count}" />
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
	<script>
		$(document).ready(function() {
			$('#example').DataTable({
				scrollX : true,
			});
		});

		if (`${update}` == "success") {
			Swal.fire({
				position : 'top-center',
				icon : 'success',
				title : 'Update success',
				showConfirmButton : false,
				timer : 1500
			})
		} else if (`${update}` == "unsuccess") {
			Swal
					.fire({
						position : 'top-center',
						icon : 'error',
						title : 'Sorry, something went wrong. \nPlease try again later.',
						showConfirmButton : false,
						timer : 1500
					})
		}
		if (`${delete}` == "success") {
			Swal.fire({
				position : 'top-center',
				icon : 'success',
				title : 'Delete success',
				showConfirmButton : false,
				timer : 1500
			})
		}
		$(function() {
			$.extend(true, $.fn.dataTable.defaults, {
				searching : false,
			// ordering: true,
			});
			$(document).ready(function() {
				$('#example').DataTable();
			});

		})
		let scrollHeight ;
		let count = 0;
		

		window.addEventListener("resize", function() {
			scrollHeight = document.documentElement.scrollHeight;//偵測視窗改變，找到畫面溢出多少
		})

		let aside = document.querySelector(".aside");
		let computedStyle = window.getComputedStyle(aside);
		let asideHeight = parseInt(computedStyle.getPropertyValue("height"));
		window.addEventListener("scroll", function() {
			if(count == 0){
				scrollHeight = document.documentElement.scrollHeight;
				count++;
			}
			let yOffset = window.pageYOffset;
			if ((asideHeight + yOffset) < scrollHeight) {
				aside.style.height = asideHeight + yOffset + "px";
			}
		});
	</script>
</body>

</html>