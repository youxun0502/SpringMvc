<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<jsp:include page="./DiscussionsMain.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Discussion data</title>
<style>

</style>
</head>
<body>
<div style="text-align:center; position:relative; margin-top: 130px; margin-left:700px;width:300px;">
    <h2>新增文章資料</h2>
    <form method="post" action="insertdiscussionfinal">
       <!--文章編號:<input type="text" name="articleId"/readonly><br> -->
        會員編號:<input type="text" name="memberId"/><br>
        會員名稱:<input type="text" name="userName"/><br>
        遊戲名稱:<input type="text" name="gameName"/><br>
        文章標題:<input type="text" name="title"/><br>
        文章內容:<input type="text" name="content"/><br>
        最後回覆時間:<input type="text" name="lastReplyTime"/><br>
        觀看次數:<input type="text" name="d_views"/><br>
        創建日期:<input type="text" name="created_at"/><br>
        按讚次數:<input type="text" name="likes"/><br>
        <input type="submit" value="確定" />
    </form>
</div>
</body>
</html>