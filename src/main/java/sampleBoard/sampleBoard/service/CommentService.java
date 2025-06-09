package sampleBoard.sampleBoard.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sampleBoard.sampleBoard.entity.BoardArticleEntity;
import sampleBoard.sampleBoard.entity.CommentEntity;
import sampleBoard.sampleBoard.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }


    @Transactional
    public void saveComment(CommentEntity entity){

        commentRepository.save(entity);
    }


    @Transactional
    public List<CommentEntity> findByArticleId(CommentEntity entity){
        List<CommentEntity> result = commentRepository.findByArticleId(entity.getArticleId());
        return result;
    }

    @Transactional
    public void deleteForArticleId(Long articleId){
        if(articleId != null){
            commentRepository.deleteForArticleId(articleId);
        }else{
            System.out.println("게시글 번호가 조회되지 않습니다.");
        }

    }




}
