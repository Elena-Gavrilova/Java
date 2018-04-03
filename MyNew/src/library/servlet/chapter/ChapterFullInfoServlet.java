package library.servlet.chapter;


import library.dto.chapter.ViewChapterFullInfoDto;
import library.service.ChapterService;
import library.util.JspPathUtil;
import library.util.UtilFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/chapterFullInfo", name = "ChapterFullInfo")
public class ChapterFullInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("chapter_id");
        if (id != null) {
            ViewChapterFullInfoDto chapter = ChapterService.getInstance().findById(Long.valueOf(id));
            req.setAttribute("chapters", chapter);
            String contents = UtilFile.readUsingBufferedReader(chapter.getUrl());
            req.setAttribute("contents",contents);
            req.setAttribute("book_id",req.getParameter("book_id"));
            req.setAttribute("chapter_id",req.getParameter("id"));
            getServletContext()
                    .getRequestDispatcher(JspPathUtil.get("view-full-chapters"))
                    .forward(req, resp);
        }
    }
}
