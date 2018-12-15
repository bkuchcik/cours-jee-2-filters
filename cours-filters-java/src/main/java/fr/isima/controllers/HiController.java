package fr.isima.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/welcome/hi")
public class HiController {

    @GetMapping
    @ResponseBody
    public String hi() {
        return "Hi !";
    }
}
