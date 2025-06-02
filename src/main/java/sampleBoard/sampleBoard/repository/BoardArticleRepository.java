package sampleBoard.sampleBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sampleBoard.sampleBoard.entity.BoardArticleEntity;

public interface BoardArticleRepository extends JpaRepository<BoardArticleEntity,Long> {
}
