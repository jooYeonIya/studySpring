package org.example.springweb.repository;

import org.example.springweb.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImpl implements PostRepository {
  private static int seq = 1;
  private static Map<Integer, Post> posts = new HashMap<>();

  public PostRepositoryImpl() {
    int id = seq++;
    Post post = new Post(id, "test", "content", 0);
    posts.put(id, post);
  }

  @Override
  public List<Post> findAll() {
     return new ArrayList<>(posts.values());
  }

  @Override
  public Post findById(int id) {
    return posts.get(id);
  }

  @Override
  public int savePost(Post post) {
    seq++;
    post.setId(seq);
    posts.put(seq, post);
    return seq;
  }

  @Override
  public void deletePostById(int id) {
    posts.remove(id);
  }

  @Override
  public void updatePost(Post post) {
    posts.put(post.getId(), post);
  }

  @Override
  public void updateLike(int id) {
    Post post = findById(id);
    int likes = post.getLikes();
    post.setLikes(likes + 1);
  }
}
