package sampleBoard.sampleBoard.service;

import sampleBoard.sampleBoard.entity.TestEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sampleBoard.sampleBoard.repository.TestRepository;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    @Transactional  //insert 테스트
    public void insertTest() {
        TestEntity entity = new TestEntity();
        entity.setTestId(1L);
        testRepository.save(entity);
        entity.setTestName("처음 저장");
    }

    @Transactional //update 테스트
    public void updateTest() {
        TestEntity entity = testRepository.findById(1L).orElseThrow();
        entity.setTestName("이름 수정됨");
        testRepository.save(entity);
    }

    @Transactional // delete 테스트
    public void deleteTest() {
        testRepository.deleteById(1L);
    }


    @Transactional // delete 테스트
    public List<TestEntity> listTest() {
        List<TestEntity> list = testRepository.findAll();
        System.out.println(list.get(0).getTestName());

        return list;

    }

    //쿼리 직접생성 테스트
    @Transactional // delete 테스트
    public List<TestEntity> findByNameCustom(String name) {
        List<TestEntity> list = testRepository.findByNameCustom(name);
        System.out.println(list.get(0).getTestName());

        return list;


    }

    @Transactional  //insert 테스트
    public void insertBoardTest(TestEntity testEntity) {
        TestEntity entity = new TestEntity();
        entity.setTestId(testEntity.getTestId());
        entity.setTestName(testEntity.getTestName());
        testRepository.save(entity);
    }

    @Transactional  //insert 테스트
    public void deleteBoardTest(Long testId) {
        testRepository.deleteById(testId);
    }




}
