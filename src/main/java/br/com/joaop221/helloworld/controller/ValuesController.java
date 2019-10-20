package br.com.joaop221.helloworld.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/values")
@Api(tags = { " Values " }, value = "Api for return values")
public class ValuesController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Return a list with values"),
        @ApiResponse(code = 404, message = "Values not found"),
    })
    public ResponseEntity<List<String>> listAll() {
        List<String> list = new ArrayList<>();

        list.add("Some");
        list.add("values");
        list.add("list");
        return ResponseEntity.ok(list);
    }
}
