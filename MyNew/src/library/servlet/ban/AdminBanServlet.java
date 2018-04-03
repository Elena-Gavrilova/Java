package library.servlet.ban;

import library.dto.ban.CreateBanDto;
import library.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet(value = "/ban", name = "Ban")
public class AdminBanServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BanService.getInstance().save(new CreateBanDto(Long.valueOf(req.getParameter("book_id"))));
        resp.sendRedirect("/bookFullInfo?user_id="+req.getParameter("user_id")+"&book_id="+req.getParameter("book_id"));

    }


}
