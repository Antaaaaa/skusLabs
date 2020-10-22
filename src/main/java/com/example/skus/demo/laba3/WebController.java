package com.example.skus.demo.laba3;


import com.example.skus.demo.laba3.service.MatrixService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.skus.demo.laba3.WebController.LABA3_ENDPOINT;


@Controller
@RequestMapping(LABA3_ENDPOINT)
@RequiredArgsConstructor
public class WebController {
    static final String LABA3_ENDPOINT = "/laba3";

    private final MatrixService matrixService;

    @GetMapping
    public String index(@RequestParam(required = false) Integer digit1, @RequestParam(required = false) Integer digit2,
                        @RequestParam(required = false) Integer digit3, @RequestParam(required = false) Integer digit4,
                        @RequestParam(required = false) Integer digit5, @RequestParam(required = false) Integer digit6,
                        @RequestParam(required = false) Integer digit7, @RequestParam(required = false) Integer digit8,
                        @RequestParam(required = false) Integer digit9, Model model) {
        if (digit1 != null && digit2 != null && digit3 != null &&
            digit4 != null && digit5 != null && digit6 != null &&
            digit7 != null && digit8 != null && digit9 != null){
        Integer result = matrixService.determinantOfMatrix(new int[][]{{digit1,digit2,digit3}, {digit4,digit5,digit6}, {digit7,digit8,digit9}}, 3);
        model.addAttribute("result", result);
        }
        return "laba3";
    }
}
