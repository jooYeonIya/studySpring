package org.example.springweb.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.springweb.domain.Post;

import java.util.List;

@Mapper
public interface PostRepository {

  @Select("select * from post")
  List<Post> findAll();

  Post findById(int id);
  List<Post> findAllWithLikes(@Param("likes") Integer likes, @Param("title") String title);
  int savePost(Post post);
  void deletePostById(int id);
  void updatePost(Post post);
  int updateLike(int id);
}
