package JavaApp.questionApp.controllers;

import JavaApp.questionApp.entities.Comment;
import JavaApp.questionApp.services.CommentService;
import JavaApp.questionApp.services.requests.CommentCreateRequest;
import JavaApp.questionApp.services.requests.CommentUpdateRequest;
import JavaApp.questionApp.services.response.CommentResponse;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Comments;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    @GetMapping
    public List<CommentResponse> getAllComments(@RequestParam Optional<Long> userId,
                                                @RequestParam Optional<Long> postId) {
        return commentService.getAllCommentsWithParam(userId, postId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest request) {
        return commentService.createOneComment(request);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId) {
        return commentService.getOneCommentById(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request) {
        return commentService.updateOneCommentById(commentId, request);
    }

    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId) {
        commentService.deleteOneCommentById(commentId);
    }
}