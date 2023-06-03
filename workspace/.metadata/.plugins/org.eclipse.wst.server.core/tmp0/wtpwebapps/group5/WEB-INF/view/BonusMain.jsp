<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.li.model.BonusItem" %>
<jsp:include page="./mainBonusL.jsp"/>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>商品管理頁面</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<style>
					.area1 {
						position: absolute;
						width: 80%;
						margin: 180px 250px;
					}

					table {
						background-color: rgb(33, 37, 41);
						color: white;
					}

					buttom {
						margin: 5px
					}
				</style>

</head>

<body>

	<div class="container01" style="margin-top:100px;">
		<p>
			<button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#insertitem"
				aria-expanded="false" aria-controls="collapseExample">
				新增商品
			</button>
	
			<button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#search"
				aria-expanded="false" aria-controls="collapseExample">
				查看商品
			</button>
		</p>
		<!-- 查看商品 -->
		<div class="collapse" id="search" style="width:500px">
			<div class="card card-body">
				<form id="searchall" method="post" action="bonusitem.searchall">
				<input class="btn btn-primary" type="submit" value="查詢所有資料" />
				</form>
				<div style="width:250px">
				<button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#searchsome"
					aria-expanded="false" aria-controls="searchsome" style="margin-top:5px;">
					查詢關鍵字
				</button>	
				</div>
			</div>
		</div>
		<!-- 新增商品 -->
		<div class="collapse" id="insertitem" style="width:500px">
			<form id="insert" method="post" action="bonusitem.insert" enctype="multipart/form-data">
				<div class="card card-body">
					
					<table>
						<tr>
							<td>商品名稱</td>
							<td><input type="text" name="bonusname" /></td>
						</tr>
						<tr>
							<td>商品價格</td>
							<td><input type="number" name="bonusprice" /></td>
						</tr>
						<tr>
							<td>商品描述</td>
							<td><textarea name="bonusdes" id="bonusdes" cols="30" rows="10"></textarea></td>
						</tr>
						<tr>
							<td>商品圖片</td>
							<td><input type="file" name="bonusimg2" /></td>

						</tr>

						<tr>
							<td><input type="submit" value="確定"><input type="reset" value="清除" /></td>
						</tr>
					</table>

				</div>
			</form>
		</div>
		<!-- 查詢多筆 -->
		<div class="collapse" id="searchsome" style="width:500px">
			<form id="search" method="post" action="bonusitem.search">
				<input type="hidden" name="formId" value="search">
				<div class="card card-body">
					<table>
						<tr>
							<td>關鍵字查詢</td>
							<td><input type="text" name="bonussearch" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="確定" /><input type="reset" value="清除" /></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>

	<script>
		$(function () {

		})
	</script>
</body>

</html>