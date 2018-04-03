package library.servlet.book;

import library.dto.book.ViewBookFullInfoDto;
import library.service.BookService;
import library.util.UtilFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/bookDownload", name="BookDownload")
public class BookDownloadServlet extends HttpServlet {

    private static final String FILE_NAME = ".txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("book_id");
        ViewBookFullInfoDto bookFullInfoDto = BookService.getInstance().findById(Long.valueOf(id));
        resp.setContentType("text/plain");
        resp.setHeader("Content-disposition","attachment; filename="+bookFullInfoDto.getName()+ FILE_NAME);
        String text = UtilFile.readUsingBufferedReaderText(BookService.getInstance().findByIdText(Long.valueOf(id)).getUrl());
        resp.getWriter().write(text);
    }
}
