package com.classroom.assignment.service;

import com.classroom.assignment.entity.Comment;
import java.util.List;

public interface CommentService {
  void save(Comment Comment);

  List<Comment> getAll();

  List<Comment> getCommentSerchByName(String name);

  List<Comment> getCommentSerchById(String id);
}
