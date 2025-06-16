package sampleBoard.sampleBoard.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sampleBoard.sampleBoard.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;

    }



    @GetMapping("joinMember")
    public String joinMember(){
        return "member/joinPage";
    }
}
