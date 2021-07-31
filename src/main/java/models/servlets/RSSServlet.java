package models.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.RSS;
import models.dao.RSSdao;

@WebServlet("/newfeed")
public class RSSServlet extends HttpServlet {

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    log("Starting servlet.");
  }

  public void destroy() {
    super.destroy();
    log("Destroying servlet.");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException {

      PrintWriter out = resp.getWriter();

      String link = req.getParameter("link");

      RSS newRSS = new RSS();
      newRSS.setLink(link);

      RSSdao dao = new RSSdao();
      dao.save(newRSS);

      out.println("<html>");
      out.println("<body>");
      out.println("Contato " + newRSS.getLink() +
              " adicionado com sucesso!");
      out.println("</body>");
      out.println("</html>");
  }

}
