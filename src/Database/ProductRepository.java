package Database;

import Service.ProductException;
import Service.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements Repository<Product> {
    private Map<Integer, Product> databaseOfProduct = new HashMap();
    private int count = -1;


    @Override
    public List<Product> findAll() {
        return new ArrayList(databaseOfProduct.values());
    }

    @Override
    public Product findById(int id) throws ProductException {
        if (databaseOfProduct.containsKey(id)) {
            return databaseOfProduct.get(id);
        } else {
            throw new ProductException(id + " id not found or entered incorrectly");
        }
    }

    @Override
    public void addProduct(Product product) {
        count++;
        product.setId(count);
        databaseOfProduct.put(product.getId(), product);

    }

    @Override
    public void deleteById(int id) throws ProductException {

        if (databaseOfProduct.containsKey(id)) {
            databaseOfProduct.remove(id);
        } else {
            throw new ProductException(id + " id not found or entered incorrectly");
        }
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "databaseOfProduct=" + databaseOfProduct +
                '}';
    }
}
