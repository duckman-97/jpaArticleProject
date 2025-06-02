package sampleBoard.sampleBoard.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sampleBoard.sampleBoard.repository.BoardArticleRepository;
import sampleBoard.sampleBoard.repository.TestRepository;

@Service
public class BoardArticleService {


    private final BoardArticleRepository boardArticleRepository;

    public BoardArticleService(BoardArticleRepository boardArticleRepository){
        this.boardArticleRepository = boardArticleRepository;

    }
    
    //게시판 리스트 조회

    
    //게시판 상세
    
    //게시판 수정 및 등록
    
    //게시판 삭제

}
