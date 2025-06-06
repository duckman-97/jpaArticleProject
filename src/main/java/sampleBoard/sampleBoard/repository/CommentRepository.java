package sampleBoard.sampleBoard.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sampleBoard.sampleBoard.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
