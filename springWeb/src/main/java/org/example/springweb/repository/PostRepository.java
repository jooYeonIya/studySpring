package org.example.springweb.repository;

import org.example.springweb.domain.Post;

import java.util.List;

public interface PostRepository {
  List<Post> findAll();
  Post findById(int id);
  int savePost(Post post);
  void deletePostById(int id);
  void updatePost(Post post);
  void updateLike(int id);
}
