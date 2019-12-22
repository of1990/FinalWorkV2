package Service;

import java.util.List;

public interface Repository<Product> {
    List<Product> findAll();
    Product findById(int id) throws ProductException;
    void addProduct(Product product) throws ProductException;
    void deleteById(int id) throws ProductException;

}
