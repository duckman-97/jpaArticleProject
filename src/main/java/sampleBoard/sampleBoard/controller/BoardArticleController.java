package sampleBoard.sampleBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String ArticleView(Model model, @RequestParam(value = "articleId")Long articleId) {
        System.out.println("게시글 상세 = " + articleId);
        BoardArticleEntity articleData =  new BoardArticleEntity();
        BoardArticleEntity entity = new BoardArticleEntity();
        entity.setArticleId(articleId);

        articleData = boardArticleService.getArticleData(entity);
        model.addAttribute("articleData", articleData);

        return "article/view";

    }

    //게시판 등록 페이지
    @GetMapping("articleWrite")
    public String ArticleWrite(Model model , @RequestParam(value = "articleId", required = false)Long articleId) {
        System.out.println("게시글 등록");
        BoardArticleEntity entity = new BoardArticleEntity();
        BoardArticleEntity articleData = new BoardArticleEntity();

        if(articleId != null ){
            entity.setArticleId(articleId);
            articleData = boardArticleService.getArticleData(entity);

        }
        model.addAttribute("articleData", articleData);

        return "article/write";

    }

    //게시판 등록 저장
    @PostMapping("/articleWriteAction")
    public String ArticleAction(Model model, BoardArticleEntity entity) {

        System.out.println(entity.toString());

        boardArticleService.insertArticle(entity);



        return "redirect:/articleList";

    }

    //게시글 삭제
    @PostMapping("articleDelete")
    public String ArticleDelete(Model model, BoardArticleEntity entity) {

        if(entity.getArticleId() != null ){

            boardArticleService.deleteArticle(entity);
            System.out.println("게시글 삭제");

        }else{
            System.out.println("게시글 정보를 찾을 수 없습니다.");
        }



        return "redirect:/articleList" ;

    }


}
