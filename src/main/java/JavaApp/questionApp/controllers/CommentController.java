package JavaApp.questionApp.controllers;

import JavaApp.questionApp.entities.Comment;
import JavaApp.questionApp.services.CommentService;
import JavaApp.questionApp.services.requests.CommentCreateRequest;
import JavaApp.questionApp.services.requests.CommentUpdateRequest;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Comments;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private CommentService _service;

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return  _service.getAllCommentsWithParam(userId,postId);
    }
    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return _service.getOneCommentById(commentId);
    }
    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return _service.createOneComment(commentCreateRequest);
    }
    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId,@RequestBody CommentUpdateRequest commentUpdateRequest){
        return _service.updateOneCommentById(commentId,commentUpdateRequest);
    }
    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){
        _service.deleteOneCommentById(commentId);
    }
}
