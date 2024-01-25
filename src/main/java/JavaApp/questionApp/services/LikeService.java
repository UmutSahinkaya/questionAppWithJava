package JavaApp.questionApp.services;

import JavaApp.questionApp.entities.Comment;
import JavaApp.questionApp.entities.Like;
import JavaApp.questionApp.entities.Post;
import JavaApp.questionApp.entities.User;
import JavaApp.questionApp.repos.LikeRepository;
import JavaApp.questionApp.services.requests.LikeCreateRequest;
import JavaApp.questionApp.services.requests.LikeUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeService {
    private LikeRepository _repository;
    private UserService _userService;
    private PostService _postService;
    public List<Like> getAllLikesWithParam(Optional<Long> postId, Optional<Long> userId) {
        if(userId.isPresent() && postId.isPresent()){
            return _repository.findByUserIdAndPostId(userId.get(),postId.get());
        }else if(userId.isPresent()){
            return _repository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return _repository.findByPostId(postId.get());
        }
        else return _repository.findAll();
    }

    public Like getOneLikeById(Long likeId) {
        return _repository.findById(likeId).orElse(null);
    }

    public Like createOneLike(LikeCreateRequest likeCreateRequest) {
        User user =_userService.getOneUserById(likeCreateRequest.getUserId());
        Post post=_postService.getOnePostById(likeCreateRequest.getPostId());
        if (user != null && post != null){
            Like likeToSave=new Like();
            likeToSave.setId(likeCreateRequest.getId());
            likeToSave.setPost(post);
            likeToSave.setUser(user);
            return _repository.save(likeToSave);
        }else return null;
    }

    public Like updateOneLikeById(Long likeId, LikeUpdateRequest likeUpdateRequest) {
        Optional<Like> like=_repository.findById(likeId);
        if(like.isPresent()){
            Like likeToUpdate=like.get();
            return _repository.save(likeToUpdate);
        }else return null;
    }
    public void deleteOneLikeById(Long likeId) {
        _repository.deleteById(likeId);
    }
}
