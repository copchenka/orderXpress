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
        return withTransaction(session -> {
            Product product = new Product(name, description, price);
            session.persist(product);
            return product;
        });
    }

    @Override
    public Product getProductById(int productId) {
        return withSession(session -> session
                .get(Product.class, productId));
    }

    @Override
    public List<Product> getAllProducts() {
        return withSession(session -> session.createQuery("from Product", Product.class)
                .list());
    }
}
