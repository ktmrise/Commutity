package com.ktm.controller;

import com.ktm.dto.AccessTokenDTO;
import com.ktm.dto.GithubUser;
import com.ktm.provider.GithubProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class AuthorizeController {

    @Resource
    private GithubProvider githubProvider;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("cb84998b2c611202cf0b");
        accessTokenDTO.setClient_secret("48cda3dd318a0a9153bf2c5fd2843d82eee2c43c");
        accessTokenDTO.setRedirect_url("http://localhost:80/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }

}
