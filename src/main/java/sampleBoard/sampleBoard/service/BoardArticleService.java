package sampleBoard.sampleBoard.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sampleBoard.sampleBoard.entity.BoardArticleEntity;
import sampleBoard.sampleBoard.repository.BoardArticleRepository;
import sampleBoard.sampleBoard.repository.TestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BoardArticleService {


    private final BoardArticleRepository boardArticleRepository;

    public BoardArticleService(BoardArticleRepository boardArticleRepository){
        this.boardArticleRepository = boardArticleRepository;

    }

    @Transactional
    public void insertArticle(BoardArticleEntity entity){
        boardArticleRepository.save(entity);
        System.out.println("데이터 저장 성공");
    }

    @Transactional
    public List<BoardArticleEntity> getArticleList(BoardArticleEntity entity){
        List<BoardArticleEntity> articleList;
        articleList = boardArticleRepository.findAll();
        System.out.println("데이터 리스트 가져오기");
        return articleList;
    }

 /*   @Transactional
    public Optional<BoardArticleEntity> getArticleData(Long articleId){
        Optional<BoardArticleEntity> articleData;
        articleData = boardArticleRepository.findById(entity.getArticleId());

        System.out.println("데이터 샅세 가져오기");
        return articleData;
    }
    */
    //게시판 리스트 조회

    
    //게시판 상세
    
    //게시판 수정 및 등록
    
    //게시판 삭제

}
