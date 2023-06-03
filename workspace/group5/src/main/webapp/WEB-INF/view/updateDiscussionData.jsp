<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./DiscussionsMain.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章資料</title>
<style>
    table {
        margin: 0 auto;
        text-align: center;
    }
</style>
</head>
<body style="background-color:#fdf5e6">
<div style="text-align:center; position:relative; margin-top: 130px;">
<h2>文章 資料</h2>
<form method="post" action="updateDiscussionfinal">
<table style="text-align:center; position:relative;">
<tr><td>文章編號
	<td><input type="text" name="articleId" value="${discussion.articleId}" readonly>
<tr><td>會員編號<td><input type="text" name="memberId" value="${discussion.memberId}">
<tr><td>會員名稱<td><input type="text" name="userName" value="${discussion.userName}">
<tr><td>遊戲名稱<td><input type="text" name="gameName" value="${discussion.gameName}"/>
<tr><td>文章標題<td><input type="text" name="title" value="${discussion.title}">
<tr><td>文章內容<td><input type="text" name="content" value="${discussion.content}">
<tr><td>最後回覆時間<td><input type="text" name="lastReplyTime" value="${discussion.lastReplyTime}">
<tr><td>觀看次數<td><input type="text" name="d_views" value="${discussion.d_views}">
<tr><td>創建日期<td><input type="text" name="created_at" value="${discussion.created_at}">
<tr><td>按讚次數<td><input type="text" name="likes" value="${discussion.likes}">
</table>
<input type="submit" value="修改資料" />
</form>
</div>
</body>
</html>