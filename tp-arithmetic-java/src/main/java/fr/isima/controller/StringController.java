package fr.isima.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/strings")
public class StringController {

    @GetMapping("/join")
    @ResponseBody
    public String join(@RequestParam("a") String a, @RequestParam("b") String b) {
        return a + b;
    }

    @GetMapping("/substringBefore")
    @ResponseBody
    public String substringBefore(@RequestParam("chain") String chain, @RequestParam("pattern") String pattern) {
        return StringUtils.substringBefore(chain, pattern);
    }

    @GetMapping("/substringAfter")
    @ResponseBody
    public String substringAfter(@RequestParam("chain") String chain, @RequestParam("pattern") String pattern) {
        return StringUtils.substringAfter(chain, pattern);
    }
}
