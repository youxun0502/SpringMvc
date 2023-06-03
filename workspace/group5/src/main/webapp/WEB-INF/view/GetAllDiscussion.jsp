<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!@SuppressWarnings("unchecked")%>
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
						<th>文章編號
						<th>會員編號
						<th>會員名稱
						<th>遊戲名稱
						<th>文章標題
						<th>文章內容
						<th>最後回覆時間
						<th>觀看次數
						<th>創建日期
						<th>按讚次數
						<th>更新
						<th>刪除
					</tr>
				</thead>
				<tbody>
						 <c:forEach var="discussion" items="${discussions}">
					<tr>
						<td>${discussion.articleId}
						<td>${discussion.memberId}
						<td>${discussion.userName}
						<td>${discussion.gameName}
						<td>${discussion.title}
						<td>${discussion.content}
						<td>${discussion.lastReplyTime}
						<td>${discussion.d_views}
						<td>${discussion.created_at}
						<td>${discussion.likes}
						<td>
							<form method="post" action="GetDiscussion">
								<button type="submit" name="articleId"
									value="${discussion.articleId}">更新</button>
							</form>
						<td>
							<form method="post" action="deleteDiscussionfinal">
								<button type="submit" name="articleId"
									value="${discussion.articleId}"
									onclick="return confirm('確定要刪除嗎？')">刪除</button>
							</form>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
	<script>
	$(function () {
		$.extend(true, $.fn.dataTable.defaults, {
			searching: false,
			// ordering: true,
		});
		$(document).ready(function () {
			$('#example').DataTable();
		});
	})
	</script>
</body>

</html>