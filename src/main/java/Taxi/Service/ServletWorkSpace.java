package Taxi.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


/**
 * Created by ${BIM} on 07.07.2016.
 */
@WebServlet("/workSpace")
public class ServletWorkSpace extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
        String login = (String) request.getSession().getAttribute("clientId");
        request.getSession().setAttribute("inputIdLogin", login);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SaTax</title>");
        out.println("<meta charset=\"UTF-8\"> ");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"seccondPageView.css\">\n");
        out.print("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.6.4.min.js\"></script>\n");
        out.print("<script type=\"text/javascript\" src=\"JavaScript/workSpaceClock.js\"></script>\n");
        out.print("<script type=\"text/javascript\" src=\"JavaScript/googleMap.js\"></script>\n");
        out.print("<script type=\"text/javascript\" src=\"JavaScript/ordersInfo.js\"></script>\n");
        out.print("<script type=\"text/javascript\" src=\"JavaScript/taxiMenuBtnOrderTaxi.js\"></script>\n");
        out.print("<script type=\"text/javascript\" src=\"JavaScript/workSpaceSetOrder.js\"></script>\n");
        out.println("</head>");
        out.println("<body class=\"body\" id=\"bodyID\">" +
                "<div name=\"topMenu\" id=\"topMenu\">" +
                "<ul class=\"navigation\">\n" +
                "<li id=\"btnToMainPageId\" class=\"nav-item\"><a href=\"http://localhost:8085/\">На головну сторінку</a></li>\n" +
                "<li id=\"btnSataxNewsId\" class=\"nav-item\"><a href=\"#\">Ваші замовлення</a></li>\n" +
                "<li id=\"btnOrderTaxi\" class=\"nav-item\"><a href=\"#\">Замовити таксі</a></li>\n" +
                "<li id=\"btnContacts\" class=\"nav-item\"><a href=\"#\">Контакти</a></li>\n" +
                "</ul>\n" +
                "</div>" +
                "<div id=\"taxiOrderDivId\">" +
                "<form action=\"/orderFromWorkSpace\" method=\"post\">\n" +
                "<div id=\"imputsDivId\">" +
                "<label for=\"palaceFrom\"> Місце подачі таксі</label>\n" +
                "<input id=\"streetFrom\" name=\"streetFrom\" type=\"text\" placeholder=\"вул\">\n" +
                "<input id=\"houseFrom\"  name=\"houseFrom\"  type=\"text\" placeholder=\"буд.\">\n" +
                "<input id=\"blockFrom\"  name=\"blockFrom\"  type=\"text\" placeholder=\"під'їзд\">\n" +
                "<input id=\"notes\"      name=\"notes\"      type=\"text\" placeholder=\"коментар (за бажанням)\">\n" +
                "<label id=\"palaceTo\" for=\"palaceTo\">   Місце призначення</label>\n" +
                "<input id=\"streetTo\"   name=\"streetTo\"   type=\"text\" placeholder=\"вул.\">\n" +
                "<input id=\"houseTo\"    name=\"houseTo\"    type=\"text\" placeholder=\"буд.\">\n" +
                "<input id=\"blockTo\"    name=\"blockTo\"    type=\"text\" placeholder=\"під'їзд\">\n" +
                "<button id=\"setOrder\"   name=\"setOrder\" disabled> Замовити</button>\n" +
                "</div>" +
                "<div id=\"taxiGirlDivId\"><img id=\"girlImg\" src=\"taxi_girl.png\">" +
                "</div>" +
                "</form>" +
                "</div>" +
                "<div id=\"totalLoginClockDateDivId\" name=\"totalLoginClockDateDivName\">" +
                "<div id=\"loginClockDateDivId\" name=\"loginClockDateDivName\">" +
                "<div id=\"loginDiv\">" +
                "<input name=\"inputLogin\" id=\"inputIdLogin\" type=\"text\" maxlength=\"25\" size=\"25\" placeholder=\"Добрий день: " + login + "\">" +
                "</div>" +
                "<div id=\"Date\">" + "</div>" +
                "<div class=\"clock\">" +
                " <ul>\n" +
                " <li id=\"hours\"></li>\n" +
                " <li id=\"point\">:</li>\n" +
                " <li id=\"min\"></li>\n" +
                " <li id=\"point\">:</li>\n" +
                " <li id=\"sec\"></li>\n" +
                "</ul>\n" +
                "</div>" +
                "</div>" +
                "</div>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<div id=\"newsDivID\" name=\"newsDivNAme\"></div>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<div  name=\"lastOrders\" id=\"lastOrders\" \">" +
                "<table name=\"tabLastOrders\" id=\"tabIDLastOrders\">\n" +
                "</table>" +
                "</div>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<div id=\"googleMapDivId\" name=\"googleMapDivName\">" +
                "<iframe id=\"googleMapId\" src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d325515.6816605682!2d30.25250242916304!3d50.402136749218926!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4cf4ee15a4505%3A0x764931d2170146fe!2z0JrQuNC10LIsIDAyMDAw!5e0!3m2!1sru!2sua!4v1469026773237\" width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>" +
                "</div>" +
                "<br>" +
                "<div id=\"footer\"><div id=\"copyRight\" align=\"center\">\n" +
                "        <script language=\"JavaScript\">\n" +
                "            document.write('<FONT COLOR=\"white\">');\n" +
                "            document.write('&copy;');\n" +
                "            document.write(' Kiev 2016 ');\n" +
                "            document.write(' Salva&Co - All Rights Reserved.');\n" +
                "            document.write('</FONT>');\n" +
                "        </script>\n" +
                "    </div>\n" +
                "</div>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
