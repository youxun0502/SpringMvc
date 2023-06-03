<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./DiscussionsMain.jsp" />
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
<title>文章資料</title>
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
				style="width: 100%">
				<thead>
					<tr>
						<th>文章編號</th>
						<th>會員編號</th>
						<th>會員名稱</th>
						<th>遊戲名稱</th>
						<th>文章標題</th>
						<th>文章內容</th>
						<th>最後回覆時間</th>
						<th>觀看次數</th>
						<th>創建日期</th>
						<th>按讚次數</th>
						<th>更新</th>
						<th>刪除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="discussion" items="${discussions}">
						<tr>
							<td>${discussion.articleId}</td>
							<td>${discussion.memberId}</td>
							<td>${discussion.userName}</td>
							<td>${discussion.gameName}</td>
							<td>${discussion.title}</td>
							<td>${discussion.content}</td>
							<td>${discussion.lastReplyTime}</td>
							<td>${discussion.d_views}</td>
							<td>${discussion.created_at}</td>
							<td>${discussion.likes}</td>
							<td>
								<form method="post" action="GetDiscussion">
									<button type="submit" name="articleId" value="${discussion.articleId}">更新</button>
								</form>
							</td>
							<td>
								<form method="post" action="deleteDiscussionfinal">
									<button type="submit" name="articleId" value="${discussion.articleId}" onclick="return confirm('確定要刪除嗎？')">刪除</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
	<script>
		$(function() {
			$.extend(true, $.fn.dataTable.defaults, {
				searching: false,
				// ordering: true,
			});
			$(document).ready(function() {
				$('#example').DataTable();
			});
		})
	</script>
</body>

</html>