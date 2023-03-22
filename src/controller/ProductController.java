package controller;

import model.Product;
import service.IProductService;
import service.ProductService;

import java.util.List;

public class ProductController {
    IProductService productService = new ProductService();

    public List<Product> showListProduct() {
        return productService.findAll();
    }

    public void createProduct(Product product) {
        productService.save(product);
    }

    public void updateProduct(Product product){
        productService.save(product);
    }

    public void deleteProduct(int id){
        productService.delete(id);
    }
}
