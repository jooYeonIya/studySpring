package org.example.springweb.controller;

import org.example.springweb.domain.Post;
import org.example.springweb.domain.PostCreateRequestDTO;
import org.example.springweb.domain.PostDetailResponseDTO;
import org.example.springweb.domain.PostUpdateRequestDTO;
import org.example.springweb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
  private final PostService postService;

  // @Autowired 는 스프링 빈만 사용 가능
  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/posts")
  public List<Post> viewAllPosts() {
    return postService.getAllPosts();
  }

  @GetMapping("/posts/{id}")
  public PostDetailResponseDTO viewPostDetail(@PathVariable("id") int id) {
    return postService.getPostDetail(id);
  }

  @PostMapping("/posts")
  public PostDetailResponseDTO createNewPost(@RequestBody PostCreateRequestDTO post) {
    return postService.createPost(post);
  }

  @DeleteMapping("/posts/{id}")
  public void deletePost(@PathVariable("id") int id) {
    postService.deletePost(id);
  }

  @PatchMapping("/posts/{id}")
  public PostDetailResponseDTO updateBodyPost(@PathVariable("id") int id, @RequestBody PostUpdateRequestDTO post) {
    return postService.updatePost(post);
  }

  @PutMapping("/posts/{id}")
  public int updateLikesPost(@PathVariable("id") int id) {
    return postService.updateLikesPost(id);
  }
}
