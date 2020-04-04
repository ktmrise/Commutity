package com.ktm.controller;

import com.ktm.dto.QuestionDTO;
import com.ktm.mapper.QuestionMapper;
import com.ktm.mapper.UserMapper;
import com.ktm.model.Question;
import com.ktm.model.User;
import com.ktm.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Resource
    private UserMapper userMapper;

    @Resource
    private QuestionService questionService;

    @GetMapping("/index")
    public String hello(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }

        List<QuestionDTO> questionList=questionService.list();
        model.addAttribute("questions", questionList);
        return "index";
    }
}
