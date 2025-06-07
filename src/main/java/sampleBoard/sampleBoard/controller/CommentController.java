package sampleBoard.sampleBoard.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sampleBoard.sampleBoard.entity.CommentEntity;
import sampleBoard.sampleBoard.service.CommentService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/insertComment")
    @ResponseBody
    public String insertComment(@RequestBody CommentEntity entity){
        LocalDateTime now = LocalDateTime.now();
        entity.setCreatedDate(now);
        commentService.saveComment(entity);
        return "success";


    }

    @PostMapping("/getCommentList")
    @ResponseBody
    public List<CommentEntity> getCommentList(@RequestBody CommentEntity entity){

        List<CommentEntity> result = commentService.findByArticleId(entity);

        return result;

    }



}
