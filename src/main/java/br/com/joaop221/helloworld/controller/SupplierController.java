package br.com.joaop221.helloworld.controller;

import br.com.joaop221.helloworld.domain.dto.response.SupplierListResponse;
import br.com.joaop221.helloworld.domain.mapper.SupplierMapper;
import br.com.joaop221.helloworld.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.joaop221.helloworld.util.Paths.API_SUPPLIER;

@RestController
@RequestMapping(API_SUPPLIER)
@Api(tags = { " Suppliers " }, value = "Api for return Suppliers")
public class SupplierController {

    @Autowired
    private SupplierMapper mapper;

    @Autowired
    private SupplierService service;

    @ApiResponses(value = { //
            @ApiResponse(code = 200, message = "Return a list of SupplierListResponse"), //

    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SupplierListResponse>> listAll() {
        return ResponseEntity.ok(service.listAll() //
                .stream() //
                .map(x -> mapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @ApiResponses(value = { //
            @ApiResponse(code = 200, message = "Return a list of SupplierListResponse"), //
            @ApiResponse(code = 204, message = "Values not found"), //
    })
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SupplierListResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.toDto(service.findById(id))) ;

    }
}
