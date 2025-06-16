package sampleBoard.sampleBoard.controller;


import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/api/articles")
    public List<BoardArticleEntity> getArticles(){
        BoardArticleEntity entity = new BoardArticleEntity();
        return boardArticleService.getArticleList(entity);

    }
 }
