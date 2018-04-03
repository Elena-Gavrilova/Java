package library.servlet.admin;


import library.entity.Role;
import library.service.RoleService;
import library.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/adminServlet", name = "AdminServlet")
public class AdminServlet extends HttpServlet {

    private static final String ADMIN = "Администратор";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> allRole = RoleService.getInstance().findAll();
        List<Role> allRoleUser = new ArrayList<>();
        for (Role role : allRole) {
            if(!role.equals(ADMIN)){
                allRoleUser.add(role);
            }
        }
        req.setAttribute("roles",allRoleUser);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("profile-admin"))
                .forward(req, resp);
    }


}
