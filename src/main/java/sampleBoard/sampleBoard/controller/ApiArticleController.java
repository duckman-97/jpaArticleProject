package sampleBoard.sampleBoard.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
    
    
 }
