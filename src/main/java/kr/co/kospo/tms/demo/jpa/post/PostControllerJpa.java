package kr.co.kospo.tms.demo.jpa.post;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("demo/jpa/post")
public class PostControllerJpa {
  
  private final PostService postService;

  @GetMapping
  public ResponseEntity<List<Post>> getPosts(PostDto dto) {
    log.info("[jpa get list]" + dto);
    List<Post> rs = postService.getEntities(dto);
    return new ResponseEntity<>(rs, HttpStatus.OK);
  }
}
