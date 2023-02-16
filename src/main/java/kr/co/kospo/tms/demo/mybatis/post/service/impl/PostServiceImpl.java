package kr.co.kospo.tms.demo.mybatis.post.service.impl;

import java.util.List;

// import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import kr.co.kospo.tms.demo.mybatis.post.service.PostDto;
import kr.co.kospo.tms.demo.mybatis.post.service.PostService;

@Service
public class PostServiceImpl implements PostService {
// public class PostServiceImpl extends EgovAbstractServiceImpl implements PostService {
  
  private PostMapper postMapper;

  public PostServiceImpl(PostMapper postMapper) {
    super();
    this.postMapper = postMapper;
  }

  @Override
  public List<PostDto> getList(PostDto post) {
    // w_date -> wdate 변환 이슈
    // 매퍼는 정상적으로 w_date -> wDate 변환함
    List<PostDto> rs = postMapper.getList(post);

    return rs;
  }
}
