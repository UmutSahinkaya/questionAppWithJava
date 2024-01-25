package JavaApp.questionApp.services;

import JavaApp.questionApp.entities.Comment;
import JavaApp.questionApp.entities.Post;
import JavaApp.questionApp.entities.User;
import JavaApp.questionApp.repos.CommentRepository;
import JavaApp.questionApp.services.requests.CommentCreateRequest;
import JavaApp.questionApp.services.requests.CommentUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {
    private CommentRepository _repository;
    private UserService _userService;
    private PostService _postService;
    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent()){
            return _repository.findByUserIdAndPostId(userId.get(),postId.get());
        }else if(userId.isPresent()){
            return _repository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return _repository.findByPostId(postId.get());
        }
        else return _repository.findAll();
    }


    public Comment getOneCommentById(Long commentId) {
        return _repository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {
        User user =_userService.getOneUserById(commentCreateRequest.getUserId());
        Post post=_postService.getOnePostById(commentCreateRequest.getPostId());
        if (user != null && post != null){
            Comment commentToSave=new Comment();
            commentToSave.setId(commentCreateRequest.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(commentCreateRequest.getText());
            return _repository.save(commentToSave);
        }else return null;
    }

    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment=_repository.findById(commentId);
        if(comment.isPresent()){
            Comment commentToUpdate=comment.get();
            commentToUpdate.setText(commentUpdateRequest.getText());
            return _repository.save(commentToUpdate);
        }else return null;
    }

    public void deleteOneCommentById(Long commentId) {
        _repository.deleteById(commentId);
    }
}
