@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product addProduct(Product p) {
        return repo.save(p);
    }

    public Product updateProduct(Long id, Product p) {
        Product existing = repo.findById(id).orElseThrow();
        existing.setName(p.getName());
        existing.setDescription(p.getDescription());
        existing.setPrice(p.getPrice());
        existing.setCategory(p.getCategory());
        existing.setStockQuantity(p.getStockQuantity());
        return repo.save(existing);
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public List<Product> filterByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> filterByPriceRange(Double min, Double max) {
        return repo.findByPriceBetween(min, max);
    }

    public List<Product> searchByName(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }
}
