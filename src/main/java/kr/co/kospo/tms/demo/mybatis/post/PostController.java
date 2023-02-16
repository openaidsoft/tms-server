package kr.co.kospo.tms.demo.mybatis.post;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kospo.tms.demo.mybatis.post.service.PostDto;
import kr.co.kospo.tms.demo.mybatis.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("demo/mybatis/post")
public class PostController {
  
  private final PostService postService;

  @GetMapping
  public List<PostDto> list(PostDto post) {
    log.info("[Post] "+ post);
    return postService.getList(post);
  }

}
