package br.com.joaop221.helloworld.service;

import br.com.joaop221.helloworld.domain.entities.Supplier;
import br.com.joaop221.helloworld.exception.NoContentException;
import br.com.joaop221.helloworld.repository.SupplierRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SupplierServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private SupplierRepository repositoryMock;

    @InjectMocks
    private SupplierService service;

    private final Integer Id = 1;
    private final String RString = "Some string";

    Supplier supplier = Supplier.builder().id(Id).city(RString) //
            .companyName(RString).contactName(RString).contactTitle(RString) //
            .country(RString).fax(RString).phone(RString) //
            .build();

    @Test
    public void shouldThrowDataNotFoundException() {
        expected.expect(NoContentException.class);
        expected.expectMessage("Supplier Not found");
        service.findById(1);
    }

    @Test
    public void shouldFindSupplier() {

        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(supplier));

        Supplier model = service.findById(anyInt());

        verify(repositoryMock, times(1)).findById(anyInt());

        assertNotNull("Supplier cannot be null!", model);
    }

    @Test
    public void shouldListSupplier() {
        List<Supplier> list = new ArrayList<>();
        list.add(supplier);
        when(repositoryMock.findAll()).thenReturn(list);

        List<Supplier> listR = service.listAll();

        verify(repositoryMock, times(1)).findAll();

        assertEquals("Unexpected array size!", 1, listR.size());
    }

}
