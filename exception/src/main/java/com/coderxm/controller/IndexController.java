package com.coderxm.controller;

import com.coderxm.constant.Status;
import com.coderxm.exception.JsonException;
import com.coderxm.exception.PageException;
import com.coderxm.util.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping("/json")
    @ResponseBody
    public Response json() {
        throw new JsonException(Status.SERVER_ERROR);
    }

    @GetMapping("/page")
    public ModelAndView page() {
        throw new PageException(Status.SERVER_ERROR);
    }
}
