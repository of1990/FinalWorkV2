import Database.Category;
import Database.Product;
import Service.ProductException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_DOWN;
import static org.junit.Assert.*;

public class ProductTest {

    Product victim = new Product("apple", new BigDecimal(0.90), Category.FRUITS, new BigDecimal(0.50), "delicious apples");

    public ProductTest() throws ProductException {
    }


    @Test
    public void getProductCategory() {
        assertEquals(Category.FRUITS, victim.getProductCategory());
    }

    @Test
    public void setProductCategory() {
        victim.setProductCategory(Category.MILK);
        assertEquals(Category.MILK, victim.getProductCategory());
    }

    @Test
    public void getName() {
        assertEquals("apple", victim.getName());
    }

    @Test
    public void setName() {
        victim.setName("milk");
        assertEquals("milk", victim.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(new BigDecimal(0.90).setScale(2, ROUND_DOWN), victim.getPrice());
    }

    @Test
    public void setPrice() {
        victim.setPrice(new BigDecimal(1.90).setScale(2, ROUND_DOWN));
        assertEquals(new BigDecimal(1.90).setScale(2, ROUND_DOWN), victim.getPrice());
    }

    @Test
    public void getDiscount() {
        assertEquals(new BigDecimal(0.50).setScale(2, ROUND_DOWN), victim.getDiscount());
    }

    @Test
    public void setDiscount() {
        victim.setDiscount(new BigDecimal(0.10).setScale(2, ROUND_DOWN));
        assertEquals(new BigDecimal(0.10).setScale(2, ROUND_DOWN), victim.getDiscount());
    }

    @Test
    public void getDescription() {
        assertEquals("delicious apples", victim.getDescription());
    }

    @Test
    public void setDescription() {
        victim.setDescription("apples from Latvia");
        assertEquals("apples from Latvia", victim.getDescription());

    }
}