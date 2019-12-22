package Database;

import Service.ProductException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProductRepositoryTest {
    Product product1 = new Product("apple", new BigDecimal(0.70), Category.FRUITS,
            new BigDecimal(0.05), "apples from Latvia");
    Product product2 = new Product("milk", new BigDecimal(1.50), Category.MILK,
            new BigDecimal(0.05), "cold milk");
    ProductRepository pr = new ProductRepository();

    public ProductRepositoryTest() throws ProductException {
    }

    @Test
    public void addProduct() throws ProductException {
        pr.addProduct(product1);
        assertEquals(product1, pr.findById(0));
    }

    @Test
    public void findAll() {
        pr.addProduct(product1);
        pr.addProduct(product2);
        ArrayList<Product> product = new ArrayList();
        product.add(product1);
        product.add(product2);
        assertEquals(product, pr.findAll());
    }

    @Test
    public void findById() throws ProductException {
        pr.addProduct(product1);
        pr.addProduct(product2);
        assertEquals(product2,pr.findById(1));
    }


    @Test
    public void deleteById() throws ProductException {
        pr.addProduct(product1);
        pr.addProduct(product2);
        pr.deleteById(1);
        try{
            pr.findById(1); }
        catch (ProductException e) {
            assertEquals ( product2.getId() +" id not found or entered incorrectly", e.getMessage());
        }

    }
}