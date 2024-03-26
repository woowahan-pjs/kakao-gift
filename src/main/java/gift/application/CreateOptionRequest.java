package gift.application;

public class CreateOptionRequest {
    private String name;
    private int quantity;
    private Long productId;

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getProductId() {
        return productId;
    }
}
