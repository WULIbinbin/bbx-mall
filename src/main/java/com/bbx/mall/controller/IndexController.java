package com.bbx.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        System.out.println("2333");
        return "index.html";
    }

}

