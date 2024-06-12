package orderXpress.repository.hbm;

import orderXpress.domain.Product;
import orderXpress.repository.ProductRepository;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.List;

public class HibernateProductRepository extends AbstractRepository implements ProductRepository {

    public HibernateProductRepository(SessionFactory factory) {
        super(factory);
    }

    @Override
    public Product addProduct(String name, String description, BigDecimal price) {
        return null;
    }

    @Override
    public Product getProductById(int productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
