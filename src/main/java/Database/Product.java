package Database;


import Service.ProductException;
import java.math.BigDecimal;
import java.util.Objects;
import static java.math.BigDecimal.ROUND_DOWN;

public class Product {


    public Category productCategory;
    private Integer id;
    private String name;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;

    public Product(String name, BigDecimal price, Category productCategory, BigDecimal discount, String description) throws ProductException {
        if (name == null || name.isEmpty() || price.doubleValue() == 0 || productCategory == null) {
            throw new ProductException("field not entered, or entered incorrectly");
        } else {
            this.productCategory = productCategory;
            this.name = name;
            this.price = price.setScale(2, ROUND_DOWN);
            this.discount = discount.setScale(2, ROUND_DOWN);
            this.description = description;
        }
    }

    private BigDecimal actualPrice() {
        return price.subtract(price.multiply(discount));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                getProductCategory() == product.getProductCategory() &&
                Objects.equals(getDiscount(), product.getDiscount()) &&
                Objects.equals(getDescription(), product.getDescription());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getProductCategory(), getDiscount(), getDescription());
    }

    @Override
    public String toString() {
        String result = "";
        result += "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Category: " + productCategory + "\n";

        if (discount != null && discount.doubleValue() > 0) {
            result +=
                    "Regular price: " + price + "\n" +
                            "Discount: " + discount + "\n" +
                            "Actual price: " + actualPrice().setScale(2, ROUND_DOWN) + "\n";
        } else {
            result +=
                    "Price: " + price + "\n";
        }
        if (description != null && description.length() > 0) {
            result +=
                    "Description: " + description + "\n";
        }
        return result;
    }
}

