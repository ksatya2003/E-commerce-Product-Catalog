@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;
    private String description;
    private Double price;
    private String category;
    private Integer stockQuantity;

    // Getters and Setters
}
