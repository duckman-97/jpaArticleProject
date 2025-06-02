package sampleBoard.sampleBoard.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sampleBoard.sampleBoard.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Long> {

    @Query("SELECT t FROM TestEntity t WHERE t.testName = :name")
    List<TestEntity> findByNameCustom(@Param("name") String name);

}
