package JavaApp.questionApp.services.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateRequest {
    Long id;
    Long userId;
    Long postId;
    String text;

}
