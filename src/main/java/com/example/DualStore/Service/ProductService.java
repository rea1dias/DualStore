package com.example.DualStore.Service;

import com.example.DualStore.Model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public interface ProductService  {

    public Product saveProduct(Product product);


}
