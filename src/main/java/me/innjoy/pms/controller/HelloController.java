package me.innjoy.pms.controller;

import me.innjoy.pms.pojo.dto.ResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public ResultDto hello() {
        // ResultDto resultDto = new ResultDto();
        // resultDto.setCode(1);
        return ResultDto.failure();
    }
}
