package com.ktm.service;


import com.ktm.dto.QuestionDTO;
import com.ktm.mapper.QuestionMapper;
import com.ktm.mapper.UserMapper;
import com.ktm.model.Question;
import com.ktm.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questionList = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questionList) {
           User user= userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setUser(user);
            BeanUtils.copyProperties(question, questionDTO);
            questionDTOList.add(questionDTO);
        }
            return questionDTOList;
    }
}
