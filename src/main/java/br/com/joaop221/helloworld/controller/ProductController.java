package br.com.joaop221.helloworld.controller;

import static br.com.joaop221.helloworld.util.Paths.API_SUPPLIER;
import static br.com.joaop221.helloworld.util.Paths.PRODUCT;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import br.com.joaop221.helloworld.domain.dto.request.ProductCreateRequest;
import br.com.joaop221.helloworld.domain.dto.request.ProductUpdateRequest;
import br.com.joaop221.helloworld.domain.dto.response.ProductListResponse;
import br.com.joaop221.helloworld.domain.entities.Product;
import br.com.joaop221.helloworld.domain.mapper.ProductMapper;
import br.com.joaop221.helloworld.service.ProductService;
import br.com.joaop221.helloworld.component.ApiProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@RestController
@RequestMapping(API_SUPPLIER)
@Api(tags = { "Products" }, value = "Api for return Products")
public class ProductController {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductService service;

    @Autowired
    private ApiProperties properties;

    @ApiOperation(value = "List products of a supplier")
    @ApiResponses(value = { //
            @ApiResponse(code = 200, message = "Return a list of SupplierListResponse"), //
            @ApiResponse(code = 404, message = "Values not found"), //
    })
    @GetMapping(value = "/{supplierId}" + PRODUCT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<ProductListResponse>> listBySupplier(
            @PathVariable @NotEmpty(message = "Request param 'supplierId' is required") Integer supplierId) {
        return ResponseEntity.ok(service.listBySupplier(supplierId) //
                .stream() //
                .map(x -> mapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @ApiOperation(value = "List products of a supplier")
    @ApiResponses(value = { //
            @ApiResponse(code = 200, message = "Return a list of ProductListResponse"), //
            @ApiResponse(code = 404, message = "Values not found"), //
    })
    @GetMapping(value = "/{supplierId}" + PRODUCT + "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductListResponse> getById(
            @PathVariable @NotEmpty(message = "Request param 'supplierId' is required") Integer supplierId,
            @PathVariable @NotEmpty(message = "Request param 'id' is required") Integer id) {
        return ResponseEntity.ok(mapper.toDto(service.findById(id)));
    }

    @ApiOperation(value = "Create product for a supplier")
    @ApiResponses(value = { @ApiResponse(code = HttpServletResponse.SC_CREATED, //
            message = "Resource successfully created", //
            response = Object.class, //
            responseHeaders = { @ResponseHeader(name = "Location", response = String.class, //
                    description = "A URL of the newly created resource") }),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, //
                    message = "An unexpected error occurred!"), //
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, //
                    message = "Bad Request!") //
    })
    @PostMapping(value = "/{supplierId}" + PRODUCT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Void> create(@Valid @RequestBody ProductCreateRequest request,
                                       @PathVariable @NotEmpty(message = "Request param 'supplierId' is required") Integer supplierId) {

        request.setSupplierId(supplierId);
        Product entity = mapper.ToEntity(request);
        service.create(entity);

        URI location = UriComponentsBuilder.fromUriString(properties.getExternalUrl()) //
                .path(API_SUPPLIER + "/{supplierId}" + PRODUCT + "/{id}")
                .buildAndExpand(supplierId, entity.getId()).toUri();
        return ResponseEntity //
                .status(HttpStatus.CREATED) //
                .header("Location", location.toString()) //
                .build();
    }

    @ApiOperation(value = "Update product for a supplier")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Product Updated"), //
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, //
                    message = "An unexpected error occurred!"), //
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, //
                    message = "Bad Request!") //
    })
    @PutMapping(value = "/{supplierId}" + PRODUCT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Void> create(@Valid @RequestBody ProductUpdateRequest request,
                                       @PathVariable @NotEmpty(message = "Request param 'supplierId' is required") Integer supplierId) {

        Product entity = mapper.ToEntity(request);
        service.update(entity);

        return ResponseEntity.ok().build();
    }

}