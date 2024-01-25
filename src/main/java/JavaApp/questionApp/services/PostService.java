package JavaApp.questionApp.services;

import JavaApp.questionApp.entities.Post;
import JavaApp.questionApp.entities.User;
import JavaApp.questionApp.repos.PostRepository;
import JavaApp.questionApp.repos.UserRepository;
import JavaApp.questionApp.services.requests.PostCreateRequest;
import JavaApp.questionApp.services.requests.PostUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository _repository;
    private UserService _userService;
    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent())
            return _repository.findByUserId(userId.get());
        return _repository.findAll();
    }

    public Post getOnePostById(Long postId) {
        return _repository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
        User user=_userService.getOneUserById(newPostRequest.getUserId());
        if(user == null)
            return null;
        Post toSave=new Post();
        toSave.setId(user.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setId(newPostRequest.getId());
        return _repository.save(toSave);
    }

    public void deleteOnePostById(Long postId) {
        _repository.deleteById(postId);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post = _repository.findById(postId);
        if(post.isPresent()){
            Post toUpdate= post.get();
            toUpdate.setText(postUpdateRequest.getText());
            toUpdate.setTitle(postUpdateRequest.getTitle());
            _repository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }
}
