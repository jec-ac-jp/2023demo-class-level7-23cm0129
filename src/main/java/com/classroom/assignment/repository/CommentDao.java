package com.classroom.assignment.repository;

import java.util.List;
import com.classroom.assignment.entity.Comment;

public interface CommentDao {
  void insertComment(Comment comment);

  int updateComment(Comment comment);

  List<Comment> getAll();

  List<Comment> getCommentSerchByName(String name);

  List<Comment> getCommentSerchById(int id);
}
