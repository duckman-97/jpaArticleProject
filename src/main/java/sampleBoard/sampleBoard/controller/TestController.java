package sampleBoard.sampleBoard.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sampleBoard.sampleBoard.entity.TestEntity;
import sampleBoard.sampleBoard.service.TestService;

import java.util.List;

@RestController
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/insert")
    public String insert() {
        testService.insertTest();
        System.out.println("insert 테스트!!!!");
        return "insert 완료";
    }

    @GetMapping("/update")
    public String update() {
        testService.updateTest();
        return "update 완료";
    }

    @GetMapping("/delete")
    public String delete() {
        testService.deleteTest();
        return "delete 완료";
    }




}
