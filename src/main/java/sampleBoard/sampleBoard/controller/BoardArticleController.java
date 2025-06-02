package sampleBoard.sampleBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sampleBoard.sampleBoard.service.BoardArticleService;


@Controller
public class BoardArticleController {


    private final BoardArticleService boardArticleService;

    public BoardArticleController(BoardArticleService boardArticleService) {
        this.boardArticleService = boardArticleService;
    }


    //게시글 리스트
    @GetMapping("articleList")
    public String ArticleList(Model model) {
        System.out.println("게시글 리스트");
        return "article/list";

    }

    //게시판 상세
    @GetMapping("articleView")
    public String ArticleView(Model model) {
        System.out.println("게시글 상세");
        return "article/view";

    }

    //게시판 등록
    @GetMapping("articleWrite")
    public String ArticleWrite(Model model) {
        System.out.println("게시글 등록");
        return "article/write";

    }

    //게시판 삭제
    @GetMapping("articleDelete")
    public String ArticleDelete(Model model) {
        System.out.println("게시글 삭제");
        return "redirect:/articleList" ;

    }


}
