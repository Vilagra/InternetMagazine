package levenko.com;

/**
 * Created by Vilagra on 28.03.2016.
 */
public class Product {
    private int id;
    private int price;
    private String nameOfProduct;

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public Product(int id, int price, String nameOfProduct) {
        this.id = id;
        this.price = price;
        this.nameOfProduct = nameOfProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (price != product.price) return false;
        return nameOfProduct != null ? nameOfProduct.equals(product.nameOfProduct) : product.nameOfProduct == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + price;
        result = 31 * result + (nameOfProduct != null ? nameOfProduct.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameOfProduct='" + nameOfProduct +
                "', price=" + price +
                '}';
    }
}
