package ra.controller;


import ra.model.Product;
import ra.service.ProductService;

import java.util.List;

public class ProductController {
    private ProductService productService = new ProductService();
    public List<Product> findAll() {
        return productService.findAll();
    }
    public void save(Product product) {
        productService.save(product);
    }
    public Product findById(Integer integer) {
        return productService.findById(integer);
    }
    // id tự tăng
    public int getNewId(){
        return productService.getNewId();
    }
    public  void delete(Integer integer){

    }
}
