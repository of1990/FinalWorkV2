package Service;

import Database.Category;
import Database.Product;
import Database.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.math.BigDecimal.ROUND_DOWN;

public class ProductService implements Repository<Product> {

    ProductRepository database;

    public ProductService(ProductRepository database) {
        this.database = database;
    }

    @Override
    public List findAll() {
        return database.findAll();
    }

    @Override
    public Product findById(int id) throws ProductException {
        return database.findById(id);
    }

    @Override
    public void addProduct(Product product) {
        database.addProduct(product);
    }

    @Override
    public void deleteById(int id) throws ProductException {
        database.deleteById(id);
    }

    public void addNewProduct(String name, BigDecimal price, Category productCategory, BigDecimal discount, String description) {
        try {
            Product newProduct = new Product(name, price, productCategory, discount, description);
            addProduct(newProduct);
        } catch (ProductException e) {
            System.out.println("field not entered, or entered incorrectly" + e.getMessage());
        }
    }

    public void updateName(int id, String newName) throws ProductException {
        database.findById(id).setName(newName);
    }

    public void updatePrice(int id, BigDecimal newPrice) throws ProductException {
        database.findById(id).setPrice(newPrice.setScale(2, ROUND_DOWN));
    }

    public void updateDiscount(int id, BigDecimal newDiscount) throws ProductException {
        database.findById(id).setDiscount(newDiscount.setScale(2, ROUND_DOWN));
    }

    public void updateDescription(int id, String newDescription) throws ProductException {
        database.findById(id).setDescription(newDescription);
    }

    public List<Category> listCategories() {
        return new ArrayList(Arrays.asList(Category.values()));
    }

    public void updateCategory(int id, Category newProductCategory) throws ProductException {
        database.findById(id).setProductCategory(newProductCategory);
    }

    public List findByCategory(Category productCategory) {
        List<Product> filteredCategory = new ArrayList();
        for (Product product : database.findAll()) {
            if (product.getProductCategory().equals(productCategory)) {
                filteredCategory.add(product);
            }
        }
        return filteredCategory;
    }

    public void setCategoryDiscount(Category productCategory, BigDecimal newDiscount) {
        List<Product> categoryFilteredProduct = findByCategory(productCategory);
        for (Product product : categoryFilteredProduct) {
            product.setDiscount(newDiscount.setScale(2, ROUND_DOWN));
        }
    }
}

