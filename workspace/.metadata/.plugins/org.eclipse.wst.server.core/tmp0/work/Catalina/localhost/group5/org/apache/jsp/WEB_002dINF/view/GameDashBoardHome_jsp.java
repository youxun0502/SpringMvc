/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.8
 * Generated at: 2023-06-01 12:00:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.*;

public final class GameDashBoardHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0.jar", Long.valueOf(1685620521741L));
    _jspx_dependants.put("jar:file:/Users/liuyouxun/SpringMvc/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/group5/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0.jar!/META-INF/c.tld", Long.valueOf(1602845172000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + "/";
request.setAttribute("basePath", basePath);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("	content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n");
      out.write("	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\"\r\n");
      out.write("	integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(basePath);
      out.write("css/style.css\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.4.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("js/GameDashBoardHome.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("* td {\r\n");
      out.write("	padding-left: 10px;\r\n");
      out.write("	padding-top: 10px;\r\n");
      out.write("	padding-bottom: 10px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<title>GameDashBoard</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"showGames()\">\r\n");
      out.write("	<!-- 背景跟樣式 -->\r\n");
      out.write("	<nav class=\"navbar navbar-expand-lg bg-body-tertiary navbar bg-dark\"\r\n");
      out.write("		data-bs-theme=\"dark\">\r\n");
      out.write("		<div class=\"container-fluid\">\r\n");
      out.write("			<a class=\"navbar-brand\"\r\n");
      out.write("				href=\"http://localhost:8080/group5/Main/GoBackToHome\"> <i\r\n");
      out.write("				class=\"d-inline-block align-text-top fa-solid fa-gamepad\"\r\n");
      out.write("				style=\"color: #ffc107; font-size: 1.5em;\">CARBON</i>\r\n");
      out.write("			</a>\r\n");
      out.write("			<button class=\"navbar-toggler\" type=\"button\"\r\n");
      out.write("				data-bs-toggle=\"collapse\" data-bs-target=\"#navbarText\"\r\n");
      out.write("				aria-controls=\"navbarText\" aria-expanded=\"false\"\r\n");
      out.write("				aria-label=\"Toggle navigation\">\r\n");
      out.write("				<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("			</button>\r\n");
      out.write("			<div class=\"collapse navbar-collapse\" id=\"navbarText\">\r\n");
      out.write("				<div class=\"navbar-nav me-auto mb-2 mb-lg-0\"></div>\r\n");
      out.write("				<a class=\"nav-link active\" href=\"#\"> <i\r\n");
      out.write("					class=\"fa-solid fa-user d-inline-block\"></i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${managerBeans.userId }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("				</a>\r\n");
      out.write("				<!-- 更改為管理員帳號名稱 -->\r\n");
      out.write("				<form class=\"d-flex \" method=\"post\"\r\n");
      out.write("					action=\"http://localhost:8080/group5/Main/ManagerLogout\">\r\n");
      out.write("					<button type=\"submit\" class=\"btn btn-secondary btn-sm\"\r\n");
      out.write("						style=\"margin-left: 10px;\">\r\n");
      out.write("						<i class=\"fa-solid fa-right-from-bracket\"></i>\r\n");
      out.write("						<!-- Logout -->\r\n");
      out.write("					</button>\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</nav>\r\n");
      out.write("\r\n");
      out.write("	<!-- 邊欄 -->\r\n");
      out.write("	<aside class=\"aside\">\r\n");
      out.write("		<nav class=\"nav flex-column\">\r\n");
      out.write("			<a class=\"nav-link active link-light\" aria-current=\"page\"\r\n");
      out.write("				href=\"http://localhost:8080/group5/Member/memberMain\">MEMBER</a> <a\r\n");
      out.write("				class=\"nav-link link-light\"\r\n");
      out.write("				href=\"http://localhost:8080/group5/DashHome.controller\">GAME</a> <a\r\n");
      out.write("				class=\"nav-link link-light\"\r\n");
      out.write("				href=\"http://localhost:8080/group5/gameitem.controller\">GAME\r\n");
      out.write("				ITEM</a> <a class=\"nav-link link-light\"\r\n");
      out.write("				href=\"http://localhost:8080/group5/bonusitemmain\">SHOP</a> <a\r\n");
      out.write("				class=\"nav-link link-light\"\r\n");
      out.write("				href=\"http://localhost:8080/group5/EventMain\">EVENT</a> <a\r\n");
      out.write("				class=\"nav-link link-light\"\r\n");
      out.write("				href=\"http://localhost:8080/group5/discussionmain\">DISCUSSIONS</a>\r\n");
      out.write("		</nav>\r\n");
      out.write("	</aside>\r\n");
      out.write("	<div class=\"content\">\r\n");
      out.write("		<div class=\"area\">\r\n");
      out.write("			<div class=\"contentHeader\">\r\n");
      out.write("				<div class=\"searchBar\">\r\n");
      out.write("					<nav class=\"navbar \">\r\n");
      out.write("						<div class=\" container-fluid\">\r\n");
      out.write("							<a class=\"navbar-brand\" style=\"font-size: 30px;\">Game</a>\r\n");
      out.write("							<div class=\"d-flex\" role=\"search\">\r\n");
      out.write("								<input class=\"form-control me-2\" type=\"search\"\r\n");
      out.write("									placeholder=\"Search\" aria-label=\"Search\" name=\"gname\">\r\n");
      out.write("								<button class=\"btn btn-outline-warning\" type=\"submit\"\r\n");
      out.write("									id=\"findName\">Search</button>\r\n");
      out.write("								<input type=\"hidden\" name=\"action\" value=\"searchByName\" />\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</nav>\r\n");
      out.write("				</div>\r\n");
      out.write("				<ul class=\"nav nav-tabs\">\r\n");
      out.write("					<li class=\"nav-item\">\r\n");
      out.write("						<form method=\"get\" action=\"");
      out.print(basePath);
      out.write("DashHome.controller\">\r\n");
      out.write("							<div>\r\n");
      out.write("								<input class=\"nav-link active\" type=\"submit\" name=\"getItem\"\r\n");
      out.write("									value=\"ALL\" />\r\n");
      out.write("							</div>\r\n");
      out.write("						</form>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"nav-item\">\r\n");
      out.write("						<div>\r\n");
      out.write("							<input class=\"nav-link \" type=\"submit\" name=\"insert\"\r\n");
      out.write("								value=\"New Game\" data-bs-toggle=\"modal\" data-bs-target=\"#create\" />\r\n");
      out.write("						</div>\r\n");
      out.write("					</li>\r\n");
      out.write("				</ul>\r\n");
      out.write("\r\n");
      out.write("				<!-- table 列表 -->\r\n");
      out.write("				<div align=\"center\">\r\n");
      out.write("					<div style=\"margin: 50px;\">\r\n");
      out.write("						<table border=\"1\" id=\"example\"\r\n");
      out.write("							class=\"hover row-border order-column table table-striped table-dark\">\r\n");
      out.write("							<thead>\r\n");
      out.write("								<tr style=\"background-color: #a8fefa\">\r\n");
      out.write("									<th scope=\"col\">遊戲編號\r\n");
      out.write("									<th scope=\"col\">遊戲名稱\r\n");
      out.write("									<th scope=\"col\">遊戲價格\r\n");
      out.write("									<th scope=\"col\">創建日期\r\n");
      out.write("									<th scope=\"col\">遊戲介紹\r\n");
      out.write("									<th scope=\"col\">遊戲圖片\r\n");
      out.write("									<th scope=\"col\">購買人數\r\n");
      out.write("									<th scope=\"col\">遊戲狀態\r\n");
      out.write("									<th scope=\"col\">更新\r\n");
      out.write("									<th scope=\"col\">刪除\r\n");
      out.write("							</thead>\r\n");
      out.write("							<tbody id=\"showAllGame\">\r\n");
      out.write("							</tbody>\r\n");
      out.write("						</table>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"modal fade \" id=\"create\" tabindex=\"-1\"\r\n");
      out.write("		aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\"\r\n");
      out.write("		style=\"color: black\">\r\n");
      out.write("		<div class=\"modal-dialog\" onload=\"RunForm()\">\r\n");
      out.write("			<form class=\"needs-validation\" method=\"post\" id=\"gameForm\"\r\n");
      out.write("				action=\"");
      out.print(basePath);
      out.write("create.controller\"\r\n");
      out.write("				enctype=\"multipart/form-data\" novalidate>\r\n");
      out.write("				<div class=\"modal-content\"\r\n");
      out.write("					style=\"background-color: #262424; color: white;\">\r\n");
      out.write("					<div class=\"modal-header\">\r\n");
      out.write("						<h5 class=\"modal-title\" id=\"exampleModalLabel\">Create New\r\n");
      out.write("							Game</h5>\r\n");
      out.write("						<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"\r\n");
      out.write("							aria-label=\"Close\"></button>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"modal-body\">\r\n");
      out.write("						<table id=\"CTable\">\r\n");
      out.write("							<tbody>\r\n");
      out.write("								<tr>\r\n");
      out.write("									<td>遊戲名稱\r\n");
      out.write("									<td><input type=\"text\" name=\"GameName\" id=\"copyName\"\r\n");
      out.write("										class=\"form-control\" required /> <span id=\"username_err\"\r\n");
      out.write("										style=\"display: none; color: yellow;\"><em>不要抄襲</em></span> <span\r\n");
      out.write("										class=\"invalid-feedback\" style=\"color: rgb(238, 146, 146);\"><em>No\r\n");
      out.write("												Name???Are you sure???</em> </span></td>\r\n");
      out.write("								<tr>\r\n");
      out.write("									<td>遊戲價格\r\n");
      out.write("									<td><input type=\"text\" name=\"Price\" class=\"form-control\"\r\n");
      out.write("										required pattern=\"^\\d+(\\.\\d+)?$\" /> <span\r\n");
      out.write("										class=\"invalid-feedback\" style=\"color: rgb(238, 146, 146);\"><em>Please\r\n");
      out.write("												enter Number</em> </span>\r\n");
      out.write("								<tr>\r\n");
      out.write("									<td>上架時間\r\n");
      out.write("									<td><input type=\"date\" name=\"CreateDate\"\r\n");
      out.write("										value=\"2002-01-01\" class=\"form-control\" />\r\n");
      out.write("										<div class=\"valid-feedback\" style=\"color: rgb(114, 245, 132);\">\r\n");
      out.write("											<em>Looks good!</em>\r\n");
      out.write("										</div>\r\n");
      out.write("								<tr>\r\n");
      out.write("									<td>遊戲介紹\r\n");
      out.write("									<td><input type=\"text\" name=\"GameIntroduce\"\r\n");
      out.write("										class=\"form-control\" required />\r\n");
      out.write("										<div class=\"valid-feedback\" style=\"color: rgb(114, 245, 132);\">\r\n");
      out.write("											<em>Looks good!</em>\r\n");
      out.write("										</div>\r\n");
      out.write("										<div class=\"invalid-feedback\"\r\n");
      out.write("											style=\"color: rgb(238, 146, 146);\">\r\n");
      out.write("											<em>Lazy!</em>\r\n");
      out.write("										</div>\r\n");
      out.write("								<tr>\r\n");
      out.write("									<td>圖片\r\n");
      out.write("									<td><input type=\"file\" name=\"GamePicPath\"\r\n");
      out.write("										accept=\".png,.jpg,.gif\" class=\"form-control\" required\r\n");
      out.write("										id=\"file\" /> <img id=\"demo\"\r\n");
      out.write("										style=\"width: 150px; display: none\" />\r\n");
      out.write("										<div class=\"invalid-feedback\"\r\n");
      out.write("											style=\"color: rgb(238, 146, 146);\">\r\n");
      out.write("											<em>????</em>\r\n");
      out.write("										</div>\r\n");
      out.write("								<tr>\r\n");
      out.write("									<td>購買人數\r\n");
      out.write("									<td><input type=\"text\" name=\"BuyerCount\"\r\n");
      out.write("										class=\"form-control\" pattern=\"[0-9]{1,}\" required />\r\n");
      out.write("										<div class=\"valid-feedback\" style=\"color: rgb(114, 245, 132);\">Looks\r\n");
      out.write("											good!</div>\r\n");
      out.write("										<div class=\"invalid-feedback\"\r\n");
      out.write("											style=\"color: rgb(238, 146, 146);\">\r\n");
      out.write("											<em>Give me the Number!</em>\r\n");
      out.write("										</div>\r\n");
      out.write("								<tr>\r\n");
      out.write("									<td>上架狀態\r\n");
      out.write("									<td style=\"text-align: center\"><input type=\"radio\"\r\n");
      out.write("										name=\"Status\" value=\"0\" checked /><em>關閉</em> <input\r\n");
      out.write("										type=\"radio\" name=\"Status\" value=\"1\" style=\"margin-left: 50px\" /><em>開啟</em>\r\n");
      out.write("							</tbody>\r\n");
      out.write("						</table>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"modal-footer\">\r\n");
      out.write("						<button type=\"button\" class=\"btn btn-secondary\"\r\n");
      out.write("							data-bs-dismiss=\"modal\">Close</button>\r\n");
      out.write("						<button type=\"submit\" class=\"btn btn-primary\" onclick=\"RunForm();\">確定</button>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</form>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script src=\"https://kit.fontawesome.com/f3a13d5fed.js\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\r\n");
      out.write("		integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("		integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("	  let basePath = '");
      out.print(basePath);
      out.write("'\r\n");
      out.write("	  \r\n");
      out.write("	  //----------------------取得全部遊戲資訊\r\n");
      out.write("	  function showGames(){\r\n");
      out.write("	      let allTable = document.querySelector('#example');\r\n");
      out.write("	      \r\n");
      out.write("	      const xhttp =new XMLHttpRequest();\r\n");
      out.write("	      xhttp.onload = function(){\r\n");
      out.write("	          if (this.status === 200 ) {\r\n");
      out.write("	              gamesInfos = JSON.parse(this.response);\r\n");
      out.write("	              showGameContent(gamesInfos);\r\n");
      out.write("	          }\r\n");
      out.write("	      }\r\n");
      out.write("	      xhttp.open(\"Post\", \"");
      out.print(basePath);
      out.write("\r\n");
      out.write("		getAllgames.controller\");\r\n");
      out.write("			xhttp.setRequestHeader(\"Content-type\",\r\n");
      out.write("					\"application/x-www-form-urlencoded\");\r\n");
      out.write("			xhttp.send(\"action=query\")\r\n");
      out.write("\r\n");
      out.write("			allTable.style.display = \"\";\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		//---------------------命名不得重複\r\n");
      out.write("		document.getElementById(\"copyName\").onblur = function() {\r\n");
      out.write("			var username = this.value;\r\n");
      out.write("\r\n");
      out.write("			var xhttp;\r\n");
      out.write("			if (window.XMLHttpRequest) {\r\n");
      out.write("				xhttp = new XMLHttpRequest();\r\n");
      out.write("			} else {\r\n");
      out.write("				xhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("			}\r\n");
      out.write("			xhttp.open(\"GET\", basePath + 'serchName.controller?username='\r\n");
      out.write("					+ username);\r\n");
      out.write("			xhttp.send();\r\n");
      out.write("			xhttp.onreadystatechange = function() {\r\n");
      out.write("				if (this.readyState == 4 && this.status == 200) {\r\n");
      out.write("					if (this.responseText == \"true\") {\r\n");
      out.write("						document.getElementById(\"username_err\").style.display = '';\r\n");
      out.write("						$('#confirm').prop('disabled', true);\r\n");
      out.write("					} else {\r\n");
      out.write("						document.getElementById(\"username_err\").style.display = 'none';\r\n");
      out.write("						$('#confirm').prop('disabled', false);\r\n");
      out.write("					}\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
