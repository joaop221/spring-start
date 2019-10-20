package br.com.joaop221.helloworld.domain.mapper;

import br.com.joaop221.helloworld.domain.dto.request.ProductCreateRequest;
import br.com.joaop221.helloworld.domain.dto.request.ProductUpdateRequest;
import br.com.joaop221.helloworld.domain.dto.response.ProductListResponse;
import br.com.joaop221.helloworld.domain.entities.Product;
import br.com.joaop221.helloworld.domain.entities.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    @Autowired
    ModelMapper mapper;

    public ProductListResponse toDto(Product input) {
        return  mapper.map(input, ProductListResponse.class);
    }

    public Product ToEntity(ProductCreateRequest input) {
        Product model = mapper.map(input, Product.class);
        model.setIsDiscontinued(false);
        model.setSupplier(Supplier.builder().id(input.getSupplierId()).build());
        return  model;
    }

    public Product ToEntity(ProductUpdateRequest input) {
        Product model = mapper.map(input, Product.class);
        return  model;
    }
}
