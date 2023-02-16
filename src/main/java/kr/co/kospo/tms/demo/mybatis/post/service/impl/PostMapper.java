package kr.co.kospo.tms.demo.mybatis.post.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.kospo.tms.demo.mybatis.post.service.PostDto;

@Mapper
public interface PostMapper {
  
  List<PostDto> getList(PostDto post);
}
