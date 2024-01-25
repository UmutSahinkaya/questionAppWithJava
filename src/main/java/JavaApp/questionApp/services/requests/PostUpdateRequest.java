package JavaApp.questionApp.services.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostUpdateRequest {
 String title;
 String text;
}
