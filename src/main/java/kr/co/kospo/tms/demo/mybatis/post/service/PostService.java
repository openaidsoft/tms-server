package kr.co.kospo.tms.demo.mybatis.post.service;

import java.util.List;

public interface PostService {
  List<PostDto> getList(PostDto post);
}
