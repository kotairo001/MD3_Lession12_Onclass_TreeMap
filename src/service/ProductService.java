package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    public static List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getProductId()) != null) {
            int index = productList.indexOf(findById(product.getProductId()));
            productList.set(index, product);
        } else {
            productList.add(product);

        }
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == id) {
                return productList.get(i);
            }

        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == id) {
                productList.remove(i);
            }
        }
    }
}
