package br.com.joaop221.helloworld.controller;

import br.com.joaop221.helloworld.domain.dto.response.SupplierListResponse;
import br.com.joaop221.helloworld.domain.entities.Supplier;
import br.com.joaop221.helloworld.domain.mapper.SupplierMapper;
import br.com.joaop221.helloworld.service.SupplierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SupplierControllerTest {

    @Mock
    private SupplierMapper mapper;

    @Mock
    private SupplierService service;

    @InjectMocks
    private SupplierController controller;

    private final Integer Id = 1;
    private final String RString = "Some string";

    Supplier supplier = Supplier.builder().id(Id).city(RString) //
            .companyName(RString).contactName(RString).contactTitle(RString) //
            .country(RString).fax(RString).phone(RString) //
            .build();

    SupplierListResponse supplierResp = SupplierListResponse.builder().id(Id).city(RString) //
            .companyName(RString).country(RString).build();

    @Test
    public void shouldGetSupplier() {
        when(mapper.toDto(any())).thenReturn(supplierResp);
        when(service.findById(any())).thenReturn(supplier);

        ResponseEntity<SupplierListResponse> response = controller.getById(1);
        assertEquals("Unexpected value", supplierResp.getId(), ((SupplierListResponse) response.getBody()).getId());
    }

    @Test
    public void shouldListSupplier() {
        when(mapper.toDto(any())).thenReturn(supplierResp);

        List<Supplier> list = new ArrayList<>();
        list.add(supplier);
        when(service.listAll()).thenReturn(list);

        ResponseEntity<List<SupplierListResponse>> response = controller.listAll();
        int size = ((List<SupplierListResponse> ) response.getBody()).size();

        assertEquals("Unexpected value", list.size(), size);
    }
}
