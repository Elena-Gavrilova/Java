package library.servlet.comment;


import library.dto.comment.CreateNewCommentDto;
import library.dto.comment.ViewCommentFullInfoDto;
import library.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(value = "/createComment", name = "CreateComment")
public class CommentCreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("book_id",req.getParameter("book_id"));
        CreateNewCommentDto createNewCommentDto = CreateNewCommentDto.builder()
                    .bookId(Long.valueOf(req.getParameter("book_id")))
                    .userId(Long.valueOf(req.getParameter("user_id")))
                    .text(req.getParameter("comment"))
                    .build();
        List<ViewCommentFullInfoDto> commentFullInfoDto = CommentService.getInstance().findAllBookId(Long.valueOf(req.getParameter("user_id")));
        req.setAttribute("comments",commentFullInfoDto);
        CommentService.getInstance().save(createNewCommentDto);
        resp.sendRedirect(req.getHeader("Referer"));
    }


}
