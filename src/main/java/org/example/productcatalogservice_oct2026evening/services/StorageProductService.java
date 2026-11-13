package org.example.productcatalogservice_oct2026evening.services;

import org.example.productcatalogservice_oct2026evening.models.Product;
import org.example.productcatalogservice_oct2026evening.models.State;
import org.example.productcatalogservice_oct2026evening.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductDetailsById(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()) {
            return null;
        } else {
            return productOptional.get();
        }
    }

    @Override
    public Product replaceProduct(Long id, Product inputProduct) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product with id "+ id+ " is not present");
        } else {
            inputProduct.setId(id); //safe side set
            return productRepo.save(inputProduct);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public void deleteProductById(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            if(product.getState().equals(State.ACTIVE)) {
                product.setState(State.DELETED);
                productRepo.save(product);
            } else {
                productRepo.deleteById(id);
            }
        } else {
            throw new RuntimeException("Product with id "+ id+ " is not present");
        }
    }

    @Override
    public Product addProduct(Product product) {
        Optional<Product> optionalProduct = productRepo.findById(product.getId());
        if(optionalProduct.isPresent()) {
            throw new RuntimeException("Product with id "+product.getId() + " is already available");
        } else {
            return productRepo.save(product);
        }
    }
}
