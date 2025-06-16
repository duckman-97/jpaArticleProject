package sampleBoard.sampleBoard.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sampleBoard.sampleBoard.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {


}
