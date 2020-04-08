package com.ktm.controller;

import com.ktm.dto.QuestionDTO;
import com.ktm.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

@Controller
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Long id, Model model) {

        QuestionDTO questionDTO = questionService.getById(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }

}
