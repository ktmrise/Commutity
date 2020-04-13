package com.ktm.controller;

import com.ktm.dto.CommentDTO;
import com.ktm.dto.QuestionDTO;
import com.ktm.enums.CommentTypeEnum;
import com.ktm.service.CommentService;
import com.ktm.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @Resource
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Long id, Model model) {

        QuestionDTO questionDTO = questionService.getById(id);
        List<CommentDTO> comments=commentService.listByTargetId(id, CommentTypeEnum.QUESTION);

        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        return "question";
    }


}
