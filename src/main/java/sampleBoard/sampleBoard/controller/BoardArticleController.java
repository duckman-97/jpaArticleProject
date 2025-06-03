package sampleBoard.sampleBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sampleBoard.sampleBoard.entity.BoardArticleEntity;
import sampleBoard.sampleBoard.entity.TestEntity;
import sampleBoard.sampleBoard.service.BoardArticleService;

import java.util.List;
import java.util.Optional;


@Controller
public class BoardArticleController {


    private final BoardArticleService boardArticleService;

    public BoardArticleController(BoardArticleService boardArticleService) {
        this.boardArticleService = boardArticleService;
    }


    //게시글 리스트
    @GetMapping("articleList")
    public String ArticleList(Model model) {

        BoardArticleEntity entity = new BoardArticleEntity();
        List<BoardArticleEntity> articleList = boardArticleService.getArticleList(entity);
        model.addAttribute("articleList",articleList);
        return "article/list";

    }

    //게시판 상세
    @GetMapping("articleView")
    public String ArticleView(Model model, @Param("articleId")Long articleId) {
        System.out.println("게시글 상세 = " + articleId);
        Optional<BoardArticleEntity> articleData;

        //boardArticleService.getArticleData()

        return "article/view";

    }

    //게시판 등록 페이지
    @GetMapping("articleWrite")
    public String ArticleWrite(Model model) {
        System.out.println("게시글 등록");
        return "article/write";

    }

    //게시판 등록 저장
    @PostMapping("/articleWriteAction")
    public String ArticleAction(Model model, BoardArticleEntity entity) {

        System.out.println(entity.toString());
        boardArticleService.insertArticle(entity);

        return "redirect:/articleList";

    }

    //게시판 삭제
    @GetMapping("articleDelete")
    public String ArticleDelete(Model model) {
        System.out.println("게시글 삭제");
        return "redirect:/articleList" ;

    }


}
