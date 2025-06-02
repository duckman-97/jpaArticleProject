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

        return "article/list";

    }


    //게시판 상세

    //게시판 수정 및 등록

    //게시판 삭제


}
