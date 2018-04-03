package library.servlet.admin;

import library.dto.user.LoginUserDto;
import library.dto.user.RoleUserDto;
import library.entity.User;
import library.service.*;
import library.util.JspPathUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet(value = "/removeRole", name = "RemoveRole")
public class AdminCreateRoleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoleUserDto roleUserDto = new RoleUserDto(Long.valueOf(req.getParameter("user")), Integer.valueOf(req.getParameter("role")));
        RoleService.getInstance().save(roleUserDto);
        LoginUserDto user = UserService.getInstance().findByIdUser(Long.valueOf(req.getParameter("user")));
        User userFull = UserService.getInstance().findByLogin(req.getParameter("user"));
        req.setAttribute("user", userFull);
        if(user.getRole().equals(RoleService.getInstance().findById(Integer.parseInt(req.getParameter("role"))).getName())){
            req.setAttribute("result","Операция проведена успешно!");
            getServletContext()
                    .getRequestDispatcher(JspPathUtil.get("profile-admin"))
                    .forward(req, resp);
        }else {
            req.setAttribute("result","Ошибка записи!");
            getServletContext()
                    .getRequestDispatcher(JspPathUtil.get("profile-admin"))
                    .forward(req, resp);
        }
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("profile-admin"))
                .forward(req, resp);
    }
}
