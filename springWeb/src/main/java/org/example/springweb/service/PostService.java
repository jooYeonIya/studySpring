package org.example.springweb.service;

import org.example.springweb.domain.Post;
import org.example.springweb.domain.PostCreateRequestDTO;
import org.example.springweb.domain.PostDetailResponseDTO;
import org.example.springweb.domain.PostUpdateRequestDTO;
import org.example.springweb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
  // fanal 이 애플리케이션이 실행되는 동안은 불변
  private final PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public PostDetailResponseDTO getPostDetail(int id) {
    Post post = postRepository.findById(id);
    PostDetailResponseDTO responseDTO = new PostDetailResponseDTO(post.getId(), post.getTitle(), post.getContent(), post.getLikes());
    return responseDTO;
  }

  public PostDetailResponseDTO createPost(PostCreateRequestDTO requestDTO) {
    Post post = new Post(0, requestDTO.getTitle(), requestDTO.getContent(), 0);
    int id = postRepository.savePost(post);
    return getPostDetail(id);
  }

  public void deletePost(int id) {
    postRepository.deletePostById(id);
  }

  public PostDetailResponseDTO updatePost(PostUpdateRequestDTO requestDTO) {
    Post post = postRepository.findById(requestDTO.getId());
    post.setContent(requestDTO.getContent());
    postRepository.updatePost(post);
    return getPostDetail(requestDTO.getId());
  }

  public int updateLikesPost(int id) {
    return postRepository.updateLike(id);
  }
}