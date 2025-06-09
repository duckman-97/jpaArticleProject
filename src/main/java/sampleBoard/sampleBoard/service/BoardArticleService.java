package sampleBoard.sampleBoard.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import sampleBoard.sampleBoard.entity.BoardArticleEntity;
import sampleBoard.sampleBoard.repository.BoardArticleRepository;
import sampleBoard.sampleBoard.repository.TestRepository;

import java.time.LocalDateTime;
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
        LocalDateTime now = LocalDateTime.now();
        entity.setCreatedDate(now);
        boardArticleRepository.save(entity);
        System.out.println("데이터 저장 성공");
    }

    @Transactional
    public void updateArticle(BoardArticleEntity entity){
        LocalDateTime now = LocalDateTime.now();
        entity.setUpdatedDate(now);
        boardArticleRepository.save(entity);
        System.out.println("데이터 수정 성공");
    }

    @Transactional
    public List<BoardArticleEntity> getArticleList(BoardArticleEntity entity){
        List<BoardArticleEntity> articleList;
        articleList = boardArticleRepository.findAll();
        System.out.println("데이터 리스트 가져오기");
        return articleList;
    }

    @Transactional
    public BoardArticleEntity getArticleData(BoardArticleEntity entity){
        BoardArticleEntity articleData = new BoardArticleEntity();
        articleData = boardArticleRepository.findById(entity.getArticleId()).orElseThrow(() -> new RuntimeException("해당 게시글을 찾을 수 없습니다."));

        System.out.println("데이터 샅세 가져오기");
        return articleData;
    }
    //게시판 리스트 조회

    
    //게시판 상세
    
    //게시판 수정 및 등록
    
    //게시글 삭제
    @Transactional
    public void deleteArticle(BoardArticleEntity entity){
        boardArticleRepository.delete(entity);
        System.out.println("게시글 데이터 삭제");



    }

}
