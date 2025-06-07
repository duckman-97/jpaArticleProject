package sampleBoard.sampleBoard.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sampleBoard.sampleBoard.entity.BoardArticleEntity;
import sampleBoard.sampleBoard.entity.CommentEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    @Query("SELECT c FROM CommentEntity c WHERE c.articleId = :articleId")
    List<CommentEntity> findByArticleId(@Param("articleId") Long articleId);
}
