package fr.isima.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

import java.text.NumberFormat

@Controller
@RequestMapping("/maths")
class ArithmeticController {

    @GetMapping("/diviser")
    @ResponseBody
    fun divide(@RequestParam("a") a: Double, @RequestParam("b") b: Double) = (a / b).format()

    @GetMapping("/soustraire")
    @ResponseBody
    fun soustraire(@RequestParam("a") a: Double, @RequestParam("b") b: Double) = (a - b).format()

    @GetMapping("/additionner")
    @ResponseBody
    fun additionner(@RequestParam("a") a: Double, @RequestParam("b") b: Double) =  (a + b).format()

    @GetMapping("/multiplier")
    @ResponseBody
    fun multiplier(@RequestParam("a") a: Double, @RequestParam("b") b: Double) = (a * b).format()
}

private fun Double.format() = NumberFormat.getInstance().apply { maximumFractionDigits = 4 }.run { format(this@format) }