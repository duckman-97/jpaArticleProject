package sampleBoard.sampleBoard.controller;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sampleBoard.sampleBoard.entity.TestEntity;
import sampleBoard.sampleBoard.service.TestService;

import java.util.List;

@Controller
public class TestListBoardController {


    private final TestService testService;

    public TestListBoardController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/list")
    public String list(Model model) {

        List<TestEntity> list = testService.listTest();
        List<TestEntity> list2 = testService.findByNameCustom("자동으로 수정이 되는구나");
        System.out.println("list2 = " + list2);

        model.addAttribute("list", list);





        return "test/list";

    }


    @PostMapping("/testInsert")
    public String testInsert(TestEntity testEntity) {
        testService.insertBoardTest(testEntity);

        return "redirect:/list";
    }

    @PostMapping("/deleteList")
    public String deleteList(@RequestParam(name = "testIdList", required = false) List<Long> testIdList) {
        if (testIdList != null) {
            for (Long id : testIdList) {
                System.out.println("delete test id : " + id);
                testService.deleteBoardTest(id);
            }
        }
        return "redirect:/list";
    }
}
