package br.com.joaop221.helloworld.domain.mapper;

import br.com.joaop221.helloworld.config.MapperConfig;
import br.com.joaop221.helloworld.domain.dto.response.SupplierListResponse;
import br.com.joaop221.helloworld.domain.entities.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SupplierMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private SupplierMapper mapper;

    @Test
    public void shouldConvertSupplierToSupplierListResponse() {
        Supplier entity = Supplier.builder().id(1).companyName("companyName").city("city").country("country").build();
        SupplierListResponse dto = mapper.toDto(entity);

        assertEquals("Unexpected value found!", dto.getId(), entity.getId());
        assertEquals("Unexpected value found!", dto.getCompanyName(), entity.getCompanyName());
        assertEquals("Unexpected value found!", dto.getCity(), entity.getCity());
        assertEquals("Unexpected value found!", dto.getCountry(), entity.getCountry());
    }
}

