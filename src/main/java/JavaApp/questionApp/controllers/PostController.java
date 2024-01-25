package JavaApp.questionApp.controllers;

import JavaApp.questionApp.entities.Post;
import JavaApp.questionApp.services.PostService;
import JavaApp.questionApp.services.requests.PostCreateRequest;
import JavaApp.questionApp.services.requests.PostUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private PostService _service;

    @GetMapping
    public List<Post> getAllPost(@RequestParam Optional<Long> userId){
        return _service.getAllPosts(userId);
    }
    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest){
        return _service.createOnePost(newPostRequest);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest){
        return _service.updateOnePostById(postId,postUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        _service.deleteOnePostById(postId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return _service.getOnePostById(postId);
    }
}
