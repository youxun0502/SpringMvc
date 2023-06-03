	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
		import="java.util.*,com.li.model.BonusItem" %>
		<%!@SuppressWarnings("unchecked") %>
			<jsp:include page="./mainBonusL.jsp" />


			<!DOCTYPE html>
			<html lang="en">

			<head>
				<meta charset="UTF-8">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<title>商品管理頁面</title>
				<link rel="stylesheet" href="../style.css">
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
					rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
					crossorigin="anonymous">
				<style>
					table {
						margin-top: 100px;
						background-color: rgb(33, 37, 41);
						color: white;
					}
				</style>
			</head>

			<body>
			
				<form id="update" method="post" action="bonusitem.updatedata">
					<table>
						<tr>
							<td>商品編號</td>
							<td>${bonusitem.getBonusid()}
							<input type="hidden" name="bonusId" value="${bonusitem.getBonusid()}"></td>
						</tr>
						<tr>
							<td>商品名稱</td>
							<td><input type="text" name="bonusname" value="${bonusitem.getBonusname()}" /></td>
						</tr>
						<tr>
							<td>商品價格</td>
							<td><input type="number" name="bonusprice" value="${bonusitem.getBonusprice()}" /></td>
						</tr>
						<tr>
							<td>商品描述</td>
							<td><textarea name="bonusdes" id="bonusdes" cols="30"
									rows="10">${bonusitem.getBonusdes()}</textarea></td>
						</tr>
						<tr>
							<input type="hidden" name="bonusimg" value="${bonusitem.getBonusimg()}">

						</tr>

						<tr>
							<td><input type="submit" value="確定"><input type="reset" value="清除" /></td>
						</tr>
					</table>
				</form>

				<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
					integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
					crossorigin="anonymous"></script>
				<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
				<script>

					$(function () {

					})
				</script>
			</body>

			</html>