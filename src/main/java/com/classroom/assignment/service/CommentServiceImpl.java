package com.classroom.assignment.service;

import com.classroom.assignment.repository.CommentDao;
import org.springframework.stereotype.Service;
import com.classroom.assignment.entity.Comment;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

  private final CommentDao dao;

  public CommentServiceImpl(CommentDao dao) {
    this.dao = dao;
  }

  @Override
  public void save(Comment Comment) {
    dao.insertComment(Comment);
  }

  @Override
  public List<Comment> getAll() {
    List<Comment> list = dao.getAll();
    return list;
  }

  @Override
  public List<Comment> getCommentSerchByName(String name) {
    // STEP7 検索欄に何も入れずに検索した場合、全件検索されるように分岐処理を追加してください。
    List<Comment> list = dao.getCommentSerchByName(name);

    if (name == null || name.trim().isEmpty()) {
      // If the search name is null or empty, retrieve all comments
      list = dao.getAll();
    } else {
      // Otherwise, perform the search by name
      list = dao.getCommentSerchByName(name);
    }
    // List<Comment> list;

    // try {
    // List<Comment> list = dao.getCommentSerchByName(name);
    // } catch (Exception e) {
    // list = dao.getAll();
    // }
    return list;
  }

  @Override
  public List<Comment> getCommentSerchById(String id) {
    List<Comment> list = new ArrayList<Comment>();
    try {
      list = dao.getCommentSerchById(Integer.parseInt(id));
    } catch (NumberFormatException e) {
      list = dao.getAll();
    }
    return list;
  }
}
