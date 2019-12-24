import Database.Category;
import Database.Product;
import Database.ProductRepository;
import Service.ProductException;
import Service.ProductService;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static java.math.BigDecimal.ROUND_DOWN;
import static org.junit.Assert.*;

public class ProductServiceTest {
    Product product1 = new Product("apple", new BigDecimal(0.70), Category.FRUITS,
            new BigDecimal(0.05), "apples from Latvia");
    Product product2 = new Product("milk", new BigDecimal(1.50), Category.MILK,
            new BigDecimal(0.05), "cold milk");
    ProductRepository database = new ProductRepository();

    ProductService db = new ProductService(database);

    public ProductServiceTest() throws ProductException {
    }

    @Test
    public void findAll() throws ProductException {
        db.addProduct(product1);
        db.addProduct(product2);
        ArrayList<Product> product = new ArrayList();
        product.add(product1);
        product.add(product2);
        assertEquals(product, db.findAll());

    }

    @Test
    public void findById() throws ProductException {
        db.addProduct(product1);
        db.addProduct(product2);
        assertEquals(product2, db.findById(1));
    }

    @Test
    public void addProduct() throws ProductException {
        db.addProduct(product1);
        assertEquals(product1, db.findById(0));
    }

    @Test
    public void deleteById() throws ProductException {
        db.addProduct(product1);
        db.addProduct(product2);
        db.deleteById(0);
        try {
            findById();
        } catch (ProductException e) {
            assertEquals(product1.getId() + " id not found or entered incorrectly", e.getMessage());
        }
    }

    @Test
    public void addNewProduct() throws ProductException {
        db.addNewProduct("kiwi", new BigDecimal(0.50), Category.FRUITS, new BigDecimal(0.10), "green kiwi");
        assertEquals("kiwi", db.findById(0).getName());
    }

    @Test
    public void updateName() throws ProductException {
        db.addProduct(product1);
        db.updateName(0, "banana");
        assertEquals("banana", db.findById(0).getName());
    }

    @Test
    public void updatePrice() throws ProductException {
        db.addProduct(product1);
        db.updatePrice(0, new BigDecimal(0.75));
        assertEquals(new BigDecimal(0.75), db.findById(0).getPrice());
    }

    @Test
    public void updateDiscount() throws ProductException {
        db.addProduct(product1);
        db.updateDiscount(0, new BigDecimal(0.40));
        assertEquals(new BigDecimal(0.40).setScale(2, ROUND_DOWN), db.findById(0).getDiscount());
    }

    @Test
    public void updateDescription() throws ProductException {
        db.addProduct(product1);
        db.updateDescription(0, "apples from Latvia");
        assertEquals("apples from Latvia", db.findById(0).getDescription());
    }

    @Test
    public void listCategories() throws ProductException {
        db.addProduct(product1);
        db.addProduct(product2);
        assertEquals(new ArrayList<Category>(Arrays.asList(Category.values())), db.listCategories());
    }

    @Test
    public void updateCategory() throws ProductException {
        db.addProduct(product1);
        db.updateCategory(0, Category.MEAT);
        assertEquals(Category.MEAT, db.findById(0).getProductCategory());
    }

    @Test
    public void findByCategory() throws ProductException {
        db.addProduct(product1);
        db.addProduct(product2);
        ArrayList<Product> product = new ArrayList();
        product.add(product2);
        assertEquals(product, db.findByCategory(Category.MILK));
    }

    @Test
    public void setCategoryDiscount() throws ProductException {
        db.addProduct(product1);
        db.setCategoryDiscount(Category.FRUITS, new BigDecimal(0.45));
        assertEquals(new BigDecimal(0.45).setScale(2, ROUND_DOWN), product1.getDiscount());
    }
}