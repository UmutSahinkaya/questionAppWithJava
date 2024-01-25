package JavaApp.questionApp.controllers;

import JavaApp.questionApp.entities.Comment;
import JavaApp.questionApp.entities.Like;
import JavaApp.questionApp.services.LikeService;
import JavaApp.questionApp.services.requests.CommentUpdateRequest;
import JavaApp.questionApp.services.requests.LikeCreateRequest;
import JavaApp.questionApp.services.requests.LikeUpdateRequest;
import JavaApp.questionApp.services.requests.PostCreateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/likes")
public class LikeController {
    private LikeService _service;
    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> postId,@RequestParam Optional<Long> userId){
        return _service.getAllLikesWithParam(postId,userId);
    }
    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId){
        return _service.getOneLikeById(likeId);
    }
    @PostMapping()
    public Like createOneLike(@RequestBody LikeCreateRequest likeCreateRequest){
        return _service.createOneLike(likeCreateRequest);
    }
    @PutMapping("/{likeId}")
    public Like updateOneComment(@PathVariable Long likeId, @RequestBody LikeUpdateRequest likeUpdateRequest){
        return _service.updateOneLikeById(likeId,likeUpdateRequest);
    }
    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId){
        _service.deleteOneLikeById(likeId);
    }
}
