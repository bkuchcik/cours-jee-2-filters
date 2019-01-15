package fr.isima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;

@Controller
@RequestMapping("/maths")
public class ArithmeticController {

    @GetMapping("/diviser")
    @ResponseBody
    public String divide(@RequestParam("a") double a, @RequestParam("b") double b) {
        return format(a / b);
    }

    private String format(double v) {
        final NumberFormat number = NumberFormat.getInstance();
        number.setMaximumFractionDigits(4);
        return number.format(v);
    }

    @GetMapping("/soustraire")
    @ResponseBody
    public String soustraire(@RequestParam("a") double a, @RequestParam("b") double b) {
        return format(a - b);
    }

    @GetMapping("/additionner")
    @ResponseBody
    public String additionner(@RequestParam("a") double a, @RequestParam("b") double b) {
        return format(a + b);
    }

    @GetMapping("/multiplier")
    @ResponseBody
    public String multiplier(@RequestParam("a") double a, @RequestParam("b") double b) {
        return format(a * b);
    }
}
