package gift.infrastructure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kakao.social")
public class KakaoSocialProperties {
    private final String token;
    private final String url;

    public KakaoSocialProperties(String token, String url) {
        this.token = token;
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public String getUrl() {
        return url;
    }
}
