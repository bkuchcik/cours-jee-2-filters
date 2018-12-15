package fr.isima.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/goodbye")
public class GoodByeController {

    @GetMapping
    @ResponseBody
    public String goodBye() {
        return "GoodBye !";
    }
}
