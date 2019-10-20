package br.com.joaop221.helloworld.repository;

import br.com.joaop221.helloworld.domain.entities.Product;
import br.com.joaop221.helloworld.domain.entities.Supplier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findBySupplier(Supplier supplier);
}
