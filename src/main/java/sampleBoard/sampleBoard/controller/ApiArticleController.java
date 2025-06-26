package sampleBoard.sampleBoard.controller;


import org.springframework.web.bind.annotation.*;
import sampleBoard.sampleBoard.entity.BoardArticleEntity;
import sampleBoard.sampleBoard.service.BoardArticleService;

import java.util.List;

@RestController
public class ApiArticleController {

    private final BoardArticleService boardArticleService;

    public ApiArticleController(BoardArticleService boardArticleService){
        this.boardArticleService = boardArticleService;

    }

    //리스트 표시
    @GetMapping("/api/articles")
    public List<BoardArticleEntity> getArticles(){
        BoardArticleEntity entity = new BoardArticleEntity();
        return boardArticleService.getArticleList(entity);

    }

    //뷰 표시
    @GetMapping("/api/view/{articleId}")
    public BoardArticleEntity getArticleView(@PathVariable Long articleId){
        BoardArticleEntity entity = new BoardArticleEntity();
        entity.setArticleId(articleId);
        return boardArticleService.getArticleData(entity);

    }

    //폼 입력
    @PostMapping("/api/articleSubmit")
    public String articleSubmit(@RequestBody BoardArticleEntity entity){
        boardArticleService.insertArticle(entity);
        System.out.println("정상적으로 등록이 완료되었습니다.");
        return "success";
    }

    //폼 삭제
    @PostMapping("/api/articleDelete")
    public String articleDelete(@RequestBody BoardArticleEntity entity){
        boardArticleService.deleteArticle(entity);
        System.out.println("정상적으로 삭제가 완료되었습니다.");
        return "success";
    }


    
    
 }
