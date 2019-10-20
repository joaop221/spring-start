package br.com.joaop221.helloworld.service;

import br.com.joaop221.helloworld.domain.entities.Product;
import br.com.joaop221.helloworld.domain.entities.Supplier;
import br.com.joaop221.helloworld.exception.NoContentException;
import br.com.joaop221.helloworld.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> listBySupplier(Integer id) {
        List<Product> list = repository.findBySupplier(Supplier.builder().id(id).build());

        if (list.size() == 0) {
            throw new NoContentException("No Products Found");
        }
        return list;
    }

    public Product findById(Integer id) {
        Optional<Product> product = repository.findById(id);
        return product.orElseThrow(() -> new NoContentException("Product Not found"));
    }

    public Product create(Product entity) {
        return repository.save(entity);
    }

    public void update(Product entity) {

        Product db = repository.findById(entity.getId()).get();

        if(entity.getPackageName() != null){
            db.setPackageName(entity.getPackageName());
        }

        if(entity.getIsDiscontinued() != null){
            db.setIsDiscontinued(entity.getIsDiscontinued());
        }

        if(entity.getProductName() != null){
            db.setProductName(entity.getProductName());
        }

        if(entity.getUnitPrice() != null){
            db.setUnitPrice(entity.getUnitPrice());
        }

        repository.save(db);

    }

}
