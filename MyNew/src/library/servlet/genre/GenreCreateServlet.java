package library.servlet.genre;


import library.entity.Genre;
import library.service.GenreService;
import library.util.JspPathUtil;
import library.validator.GenreValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/createGenre", name = "CreateGenre")
public class GenreCreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String genre = req.getParameter("genre");
        genre = GenreValidator.getInstance().validate(genre).get(0);
        Genre genreDto = Genre.builder()
                .name(genre)
                .build();
        Genre save = GenreService.getInstance().save(genreDto);
        List<Genre> allGenre = GenreService.getInstance().findAll();
        for (Genre genre1 : allGenre) {
            if (genre1.getName().equals(genre)){
                save=null;
            }
        }
        if (save!=null){
            req.setAttribute("result", "Жанр \""+save.getName()+"\" успешно сохранен!");
        }else {
            req.setAttribute("result","Жанр есть в базе!");
        }
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("profile-admin"))
                .forward(req, resp);

    }
}
