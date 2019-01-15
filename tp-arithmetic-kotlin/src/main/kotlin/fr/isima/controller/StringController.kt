package fr.isima.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/strings")
class StringController {

    @GetMapping("/join")
    @ResponseBody
    fun join(@RequestParam("a") a: String, @RequestParam("b") b: String) = a + b

    @GetMapping("/substringBefore")
    @ResponseBody
    fun substringBefore(@RequestParam("chain") chain: String, @RequestParam("delimiter") delimiter: String) = chain.substringBefore(delimiter = delimiter)

    @GetMapping("/substringAfter")
    @ResponseBody
    fun substringAfter(@RequestParam("chain") chain: String, @RequestParam("delimiter") delimiter: String) =  chain.substringAfter(delimiter = delimiter)
}
