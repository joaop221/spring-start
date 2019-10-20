package br.com.joaop221.helloworld.domain.mapper;

import br.com.joaop221.helloworld.domain.dto.response.SupplierListResponse;
import br.com.joaop221.helloworld.domain.entities.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    @Autowired
    ModelMapper mapper;

    public SupplierListResponse toDto(Supplier input) {

        return  mapper.map(input, SupplierListResponse.class);
    }
}
