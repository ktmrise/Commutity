package com.ktm.mapper;

import com.ktm.model.Question;


public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);


}