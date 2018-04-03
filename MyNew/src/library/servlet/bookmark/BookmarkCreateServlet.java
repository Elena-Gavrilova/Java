package library.servlet.bookmark;



import library.dto.bookmark.CreateNewBookmarkDto;
import library.service.BookmarkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet(value = "/createBookmark", name = "CreateBookmark")
public class BookmarkCreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateNewBookmarkDto createNewBookmarkDto = CreateNewBookmarkDto.builder()
                .bookId(Long.valueOf(req.getParameter("book_id")))
                .idUser(Long.valueOf(req.getParameter("user_id")))
                .build();
        BookmarkService.getInstance().save(createNewBookmarkDto);
        resp.sendRedirect(req.getHeader("Referer"));
    }


}
