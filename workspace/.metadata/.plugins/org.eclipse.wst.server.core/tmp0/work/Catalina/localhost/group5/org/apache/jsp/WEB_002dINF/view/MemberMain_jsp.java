/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.8
 * Generated at: 2023-06-01 12:00:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class MemberMain_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("	content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n");
      out.write("	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\"\r\n");
      out.write("	integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("<!-- <link rel=\"stylesheet\" href=\"../css/main_style.css\" type=\"text/css\"> -->\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("	position: relative;\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	height: 910px;\r\n");
      out.write("	background-color: rgb(22, 22, 24);\r\n");
      out.write("	background-image:\r\n");
      out.write("		url(\"https://images.unsplash.com/photo-1619170743049-4688803388b4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80\");\r\n");
      out.write("	background-size: 2000px;\r\n");
      out.write("	background-repeat: no-repeat;\r\n");
      out.write("	color: rgb(242, 236, 236);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".aside {\r\n");
      out.write("	position: absolute;\r\n");
      out.write("	width: 200px;\r\n");
      out.write("	height: 100%;\r\n");
      out.write("	background-color: rgb(33, 37, 41);\r\n");
      out.write("	left: 0;\r\n");
      out.write("	padding-top: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".content {\r\n");
      out.write("	position: absolute;\r\n");
      out.write("	width: calc(100% - 200px);\r\n");
      out.write("	left: 200px;\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".area {\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	position: absolute;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".searchBar {\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	background-color: rgb(22, 22, 24);\r\n");
      out.write("	padding-top: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".searchBar form {\r\n");
      out.write("	padding: 0 20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<title>MemberMain</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<nav class=\"navbar navbar-expand-lg bg-body-tertiary navbar bg-dark\"\r\n");
      out.write("		data-bs-theme=\"dark\">\r\n");
      out.write("		<div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("			<form method=\"post\"\r\n");
      out.write("				action=\"http://localhost:8080/group5/Main/GoBackToHome\">\r\n");
      out.write("				<button type=\"submit\" class=\"navbar-brand\"\r\n");
      out.write("					style=\"background-color: transparent; border-color: transparent;\">\r\n");
      out.write("					<i class=\"d-inline-block align-text-top fa-solid fa-gamepad\"\r\n");
      out.write("						style=\"color: #ffc107; font-size: 1.5em;\">Carbon</i>\r\n");
      out.write("				</button>\r\n");
      out.write("			</form>\r\n");
      out.write("			<button class=\"navbar-toggler\" type=\"button\"\r\n");
      out.write("				data-bs-toggle=\"collapse\" data-bs-target=\"#navbarText\"\r\n");
      out.write("				aria-controls=\"navbarText\" aria-expanded=\"false\"\r\n");
      out.write("				aria-label=\"Toggle navigation\">\r\n");
      out.write("				<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("			</button>\r\n");
      out.write("			<div class=\"collapse navbar-collapse\" id=\"navbarText\">\r\n");
      out.write("				<div class=\"navbar-nav me-auto mb-2 mb-lg-0\"></div>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<div class=\"content\">\r\n");
      out.write("		<div class=\"area\">\r\n");
      out.write("			<div class=\"contentHeader\">\r\n");
      out.write("				<div class=\"searchBar\">\r\n");
      out.write("					<nav class=\"navbar \">\r\n");
      out.write("						<div class=\" container-fluid\">\r\n");
      out.write("							<a class=\"navbar-brand\" style=\"font-size: 30px;\">MEMBER</a>\r\n");
      out.write("							<form class=\"d-flex\" role=\"search\" method=\"post\"\r\n");
      out.write("								action=\"http://localhost:8080/group5/Member/SelectMember\">\r\n");
      out.write("\r\n");
      out.write("								<input class=\"form-control me-2\" type=\"search\"\r\n");
      out.write("									placeholder=\"請輸入姓名\" aria-label=\"Search\" name=\"memberName\">\r\n");
      out.write("								<button class=\"btn btn-outline-warning\" type=\"submit\">Search</button>\r\n");
      out.write("							</form>\r\n");
      out.write("						</div>\r\n");
      out.write("					</nav>\r\n");
      out.write("				</div>\r\n");
      out.write("				<ul class=\"nav nav-tabs\">\r\n");
      out.write("					<li class=\"nav-item\">\r\n");
      out.write("						<!-- <a class=\"nav-link\" href=\"#\">Link</a> -->\r\n");
      out.write("						<form method=\"post\" action=\"SelectMember\">\r\n");
      out.write("							<div>\r\n");
      out.write("								<input class=\"nav-link active\" type=\"submit\" name=\"memberName\"\r\n");
      out.write("									value=\"ALL\" />\r\n");
      out.write("							</div>\r\n");
      out.write("\r\n");
      out.write("						</form>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"nav-item\"></li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.6.4.js\"></script>\r\n");
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
      out.write("	<script>\r\n");
      out.write("		$(function() {\r\n");
      out.write("\r\n");
      out.write("		})\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
