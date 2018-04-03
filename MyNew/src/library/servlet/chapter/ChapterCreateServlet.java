package library.servlet.chapter;


import library.dto.chapter.CreateNewChapterDto;
import library.service.ChapterService;
import library.util.JspPathUtil;
import library.util.UtilFile;
import library.validator.ChapterValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/createChapter", name = "Create")
public class ChapterCreateServlet extends HttpServlet {

    private static final String FILE_NAME = ".txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("book_id");
        req.setAttribute("book_id", id);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("create-chapter"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("book_id");
        String text = req.getParameter("text");
        String nameFile = "/"+id+req.getParameter("name")+ FILE_NAME;
        UtilFile.writeUsingFiles(text,nameFile);

        CreateNewChapterDto chapterDto = CreateNewChapterDto.builder()
                .name(req.getParameter("name"))
                .url(UtilFile.FILE_PATH+nameFile)
                .bookId(Long.valueOf(id))
                .build();
        List<String> validate = ChapterValidator.getInstance().validate(chapterDto);
        if(validate.isEmpty()) {
            ChapterService.getInstance().save(chapterDto);
            resp.sendRedirect("/bookFullInfo?user_id=" + req.getParameter("user_id") + "&book_id=" + id);

        }else {
            req.setAttribute("errors", validate);
            resp.sendRedirect(req.getHeader("Referer"));
        }

                }


}
