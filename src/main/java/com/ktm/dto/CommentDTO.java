package com.ktm.dto;

import com.ktm.model.User;
import lombok.Data;

/**
 * @description:
 * @Author: rise
 * @create: 2020-04-12 19:51
 **/

@Data
public class CommentDTO {

    private Long id;


    private Long parentId;


    private Integer type;


    private Long gmtCreate;


    private Long commentator;


    private Long gmtModified;


    private Long likeCount;


    private String content;

    private User user;



}
