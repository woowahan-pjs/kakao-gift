package gift.application;

public class CreateProductRequest {
    private String name;
    private int price;
    private String imageUrl;
    private Long categoryId;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
