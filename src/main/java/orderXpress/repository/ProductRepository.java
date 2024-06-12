package orderXpress.repository;

import orderXpress.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository {
    Product addProduct(String name, String description, BigDecimal price);
    Product getProductById(int productId);
    List<Product> getAllProducts();
}
