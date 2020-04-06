package com.ktm.model;

import lombok.Data;

import java.io.Serializable;

/**
 * (Question)实体类
 *
 * @author makejava
 * @since 2020-04-03 20:05:27
 */
@Data
public class Question  {

    
    private Integer id;
    
    private String title;
    
    private String description;
    
    private Long gmtCreate;
    
    private Long gmtModified;
    
    private Integer creator;
    
    private Integer commentCount;
    
    private Integer viewCount;
    
    private Integer likeCount;
    
    private String tag;


}