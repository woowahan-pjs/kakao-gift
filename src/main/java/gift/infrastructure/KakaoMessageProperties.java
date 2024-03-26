package gift.infrastructure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kakao.message")
public class KakaoMessageProperties {
    private final String token;
    private final String url;

    public KakaoMessageProperties(String token, String url) {
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
