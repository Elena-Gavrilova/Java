package library.servlet.book;


import library.dto.book.CreateNewBookDto;
import library.dto.book.ViewBookBasicInfoDto;
import library.service.BookService;
import library.service.GenreService;
import library.util.JspPathUtil;
import library.util.UtilFile;
import library.validator.BookValidator;;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@MultipartConfig
@WebServlet(value = "/createBook", name = "CreateBook")
public class BookCreateServlet extends HttpServlet {

    private static final String FILE_NAME = ".txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("genres", GenreService.getInstance().findAll());
        req.setAttribute("user_id", req.getParameter("user_id"));
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("create-book"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookWhole = req.getParameter("bookWhole");
        req.setAttribute("genres", GenreService.getInstance().findAll());
        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("description", req.getParameter("description"));
        req.setAttribute("bookWhole", bookWhole);
        if (bookWhole.equals("BookWholeFalse")) {
            CreateNewBookDto bookDto = CreateNewBookDto.builder()
                    .name(req.getParameter("name"))
                    .idUser(Long.valueOf(req.getParameter("user_id")))
                    .bookWhole(Boolean.FALSE)
                    .description(req.getParameter("description"))
                    .url(UtilFile.FILE_PATH)
                    .genreId(Integer.valueOf(req.getParameter("genre")))
                    .build();
            List<String> validate = BookValidator.getInstance().validate(bookDto);
            if (validate.isEmpty()) {
                ViewBookBasicInfoDto book = BookService.getInstance().save(bookDto);
                resp.sendRedirect("/bookFullInfo?user_id=" + req.getParameter("user_id") + "&book_id=" + book.getId());

            } else {
                req.setAttribute("errors", validate);
                getServletContext()
                        .getRequestDispatcher(JspPathUtil.get("create-book"))
                        .forward(req, resp);
            }
        } else if (bookWhole.equals("BookWholeTrue")) {
            String nameFile = "/" + req.getParameter("user_id") + req.getParameter("name") + FILE_NAME;
            Part filePart = req.getPart("file");
            String collect = new BufferedReader(new InputStreamReader(filePart.getInputStream()))
                    .lines().collect(Collectors.joining(System.lineSeparator()));
            UtilFile.writeUsingFiles(collect, nameFile);
            CreateNewBookDto bookDto = CreateNewBookDto.builder()
                    .name(req.getParameter("name"))
                    .idUser(Long.valueOf(req.getParameter("user_id")))
                    .bookWhole(Boolean.TRUE)
                    .description(req.getParameter("description"))
                    .url(UtilFile.FILE_PATH + nameFile)
                    .genreId(Integer.valueOf(req.getParameter("genre")))
                    .build();
            List<String> validate = BookValidator.getInstance().validate(bookDto);
            if (validate.isEmpty()) {
                ViewBookBasicInfoDto book = BookService.getInstance().save(bookDto);
                resp.sendRedirect("/bookFullInfo?user_id=" + req.getParameter("user_id") + "&book_id=" + book.getId());
            } else {
                req.setAttribute("errors", validate);
                getServletContext()
                        .getRequestDispatcher(JspPathUtil.get("create-book"))
                        .forward(req, resp);
            }
        }
    }
}



