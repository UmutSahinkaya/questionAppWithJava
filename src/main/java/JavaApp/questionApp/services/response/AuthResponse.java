package JavaApp.questionApp.services.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthResponse {

    String message;
    Long userId;
    String accessToken;
    String refreshToken;
}