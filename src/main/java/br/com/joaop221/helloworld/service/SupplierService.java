package br.com.joaop221.helloworld.service;

import br.com.joaop221.helloworld.domain.entities.Supplier;
import br.com.joaop221.helloworld.exception.NoContentException;
import br.com.joaop221.helloworld.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository repository;

    public Supplier findById(Integer id) {
        Optional<Supplier> supplier = repository.findById(id);
        return supplier.orElseThrow(() -> new NoContentException("Supplier Not found"));
    }

    public List<Supplier> listAll() {
        return repository.findAll();
    }

}
