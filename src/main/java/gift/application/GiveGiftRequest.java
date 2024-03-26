package gift.application;

public class GiveGiftRequest {
    private Long optionId;
    private int quantity;
    private Long receiverId;
    private String message;

    public Long getOptionId() {
        return optionId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public String getMessage() {
        return message;
    }
}
