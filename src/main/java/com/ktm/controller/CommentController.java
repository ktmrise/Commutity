package com.ktm.controller;

import com.ktm.Exception.CustomizeErrorCode;
import com.ktm.Exception.CustomizeException;
import com.ktm.dto.CommentDTO;
import com.ktm.dto.ResultDTO;
import com.ktm.mapper.CommentMapper;
import com.ktm.model.Comment;
import com.ktm.model.User;
import com.ktm.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
public class CommentController {



    @Resource
    private CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0l);
        comment.setGmtCreate(System.currentTimeMillis());
        commentService.insert(comment);
        return ResultDTO.okOf();
    }

}
