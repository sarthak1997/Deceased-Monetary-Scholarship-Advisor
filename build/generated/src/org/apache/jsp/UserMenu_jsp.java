package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UserMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User-Menu</title>\n");
      out.write("    </head>\n");
      out.write("   \n");
      out.write("<style>\n");
      out.write("/* The Modal (background) */\n");
      out.write(".modal {\n");
      out.write("    display: none; /* Hidden by default */\n");
      out.write("    position: fixed; /* Stay in place */\n");
      out.write("    z-index: 1; /* Sit on top */\n");
      out.write("    padding-top: 100px; /* Location of the box */\n");
      out.write("    left: 0;\n");
      out.write("    top: 0;\n");
      out.write("    width: 100%; /* Full width */\n");
      out.write("    height: 100%; /* Full height */\n");
      out.write("    overflow: auto; /* Enable scroll if needed */\n");
      out.write("    background-color: rgb(0,0,0); /* Fallback color */\n");
      out.write("    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Modal Content */\n");
      out.write(".modal-content {\n");
      out.write("    background-color: #fefefe;\n");
      out.write("    margin: auto;\n");
      out.write("    padding: 20px;\n");
      out.write("    border: 1px solid #888;\n");
      out.write("    width: 50%;\n");
      out.write("    \n");
      out.write("}\n");
      out.write("\n");
      out.write("/* The Close Button */\n");
      out.write(".close {\n");
      out.write("    color: #aaaaaa;\n");
      out.write("    float: right;\n");
      out.write("    font-size: 28px;\n");
      out.write("    font-weight: bold;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".close:hover,\n");
      out.write(".close:focus {\n");
      out.write("    color: #000;\n");
      out.write("    text-decoration: none;\n");
      out.write("    cursor: pointer;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write(".modal1 {\n");
      out.write("    display: none; /* Hidden by default */\n");
      out.write("    position: fixed; /* Stay in place */\n");
      out.write("    z-index: 1; /* Sit on top */\n");
      out.write("    padding-top: 100px; /* Location of the box */\n");
      out.write("    left: 0;\n");
      out.write("    top: 0;\n");
      out.write("    width: 100%; /* Full width */\n");
      out.write("    height: 100%; /* Full height */\n");
      out.write("    overflow: auto; /* Enable scroll if needed */\n");
      out.write("    background-color: rgb(0,0,0); /* Fallback color */\n");
      out.write("    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Modal Content */\n");
      out.write(".modal-content1 {\n");
      out.write("    background-color: #fefefe;\n");
      out.write("    margin: auto;\n");
      out.write("    padding: 20px;\n");
      out.write("    border: 1px solid #888;\n");
      out.write("    width: 50%;\n");
      out.write("    \n");
      out.write("}\n");
      out.write("\n");
      out.write("/* The Close Button */\n");
      out.write(".close1 {\n");
      out.write("    color: #aaaaaa;\n");
      out.write("    float: right;\n");
      out.write("    font-size: 28px;\n");
      out.write("    font-weight: bold;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".close1:hover,\n");
      out.write(".close1:focus {\n");
      out.write("    color: #000;\n");
      out.write("    text-decoration: none;\n");
      out.write("    cursor: pointer;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h2>MENU</h2>\n");
      out.write("\n");
      out.write("<!-- Trigger/Open The Modal -->\n");
      out.write("<button id=\"scholarBtn\">Scholarship</button>\n");
      out.write("\n");
      out.write("<!-- The Modal -->\n");
      out.write("<div id=\"scholarModal\" class=\"modal1\">\n");
      out.write("\n");
      out.write("<!--   Modal content -->\n");
      out.write("  <div class=\"modal-content1\">\n");
      out.write("    <span class=\"close1\">&times;</span>\n");
      out.write("    <form action=\"scholarchoice\" method=\"post\">\n");
      out.write("        <h2>Choose your role:</h2><br>\n");
      out.write("        <input type=\"radio\" name=\"choose\" value=\"provider\"> Provider\n");
      out.write("        <input type=\"radio\" name=\"choose\" value=\"scholar\"> Scholar\n");
      out.write("        &nbsp; &nbsp; &nbsp;\n");
      out.write("        <input type=\"submit\" value=\"Proceed\">\n");
      out.write("    </form>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<br> <br>\n");
      out.write("<!-- Trigger/Open The Modal -->\n");
      out.write("<button id=\"bankingBtn\">Banking</button>\n");
      out.write("\n");
      out.write("<!-- The Modal -->\n");
      out.write("<div id=\"bankingModal\" class=\"modal\">\n");
      out.write("\n");
      out.write("  <!-- Modal content -->\n");
      out.write("  <div class=\"modal-content\">\n");
      out.write("    <span class=\"close\">&times;</span>\n");
      out.write("    <h2>Choose your role:</h2><br>\n");
      out.write("    <form action=\"BankingChoice\" method=\"post\">\n");
      out.write("        <input type=\"radio\" name=\"choose\" value=\"customer\"> Customer\n");
      out.write("        <input type=\"radio\" name=\"choose\" value=\"policyagent\"> Policy Agent\n");
      out.write("        &nbsp; &nbsp; &nbsp;\n");
      out.write("        <input type=\"submit\" value=\"Proceed\">\n");
      out.write("    </form>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<button onclick=\"family()\">Family</button>\n");
      out.write("<script>\n");
      out.write("// Get the modal\n");
      out.write("var modal = document.getElementById('bankingModal');\n");
      out.write("\n");
      out.write("// Get the button that opens the modal\n");
      out.write("var btn = document.getElementById(\"bankingBtn\");\n");
      out.write("\n");
      out.write("// Get the <span> element that closes the modal\n");
      out.write("var span = document.getElementsByClassName(\"close\")[0];\n");
      out.write("\n");
      out.write("// When the user clicks the button, open the modal \n");
      out.write("btn.onclick = function() {\n");
      out.write("    modal.style.display = \"block\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("// When the user clicks on <span> (x), close the modal\n");
      out.write("span.onclick = function() {\n");
      out.write("    modal.style.display = \"none\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("// When the user clicks anywhere outside of the modal, close it\n");
      out.write("window.onclick = function(event) {\n");
      out.write("    if (event.target == modal) {\n");
      out.write("        modal.style.display = \"none\";\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("//\n");
      out.write("var modal1 = document.getElementById('scholarModal');\n");
      out.write("\n");
      out.write("// Get the button that opens the modal\n");
      out.write("var btn1 = document.getElementById(\"scholarBtn\");\n");
      out.write("\n");
      out.write("// Get the <span> element that closes the modal\n");
      out.write("var span1 = document.getElementsByClassName(\"close1\")[0];\n");
      out.write("\n");
      out.write("// When the user clicks the button, open the modal \n");
      out.write("btn1.onclick = function() {\n");
      out.write("    modal1.style.display = \"block\";\n");
      out.write("};\n");
      out.write("\n");
      out.write("// When the user clicks on <span> (x), close the modal\n");
      out.write("span1.onclick = function() {\n");
      out.write("    modal1.style.display = \"none\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("// When the user clicks anywhere outside of the modal, close it\n");
      out.write("window.onclick = function(event) {\n");
      out.write("    if (event.target == modal1) {\n");
      out.write("        modal1.style.display = \"none\";\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("\n");
      out.write("function family()\n");
      out.write("{\n");
      out.write("window.location=\"FetchFamily\";\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
