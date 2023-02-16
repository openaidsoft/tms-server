package kr.co.kospo.tms.demo.jpa.post;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;
  private final JPAQueryFactory queryFactory;

  public Post createEntity(Post post) {
    Post rs = postRepository.save(post);
    return rs;
  }

  public Post updatEntity(Post entity) {
    Optional<Post> rs = getEntity(entity.getPostId());
    log.info("[updatEntity] ", rs);
    if(rs.isPresent()) {
      return postRepository.save(entity);
    } else {
      return new Post();
    }
  }

  public List<Post> getEntities(PostDto dto) {
    QPost post = QPost.post;
    BooleanBuilder builder = new BooleanBuilder();
    if (dto.getPostId() != null) {
      builder.and(post.postId.eq(dto.getPostId()));
    }
    if (StringUtils.hasText(dto.getAuthor())) {
      builder.and(post.author.contains(dto.getAuthor()));
    }
    if (StringUtils.hasText(dto.getContent())) {
      builder.and(post.content.contains(dto.getContent()));
    }
    if (dto.getSdate() != null && dto.getEdate() != null) {
      builder.and(post.cdate.between(dto.getSdate(), dto.getEdate()));
    }
    List<Post> rs = queryFactory.selectFrom(post)
      .where(builder)
      .fetch();
    return rs;
  }

  // public List<Post> getMembers2(PostDto memberDto) {
    // LocalDateTime startDatetime = LocalDateTime.of(2022, 12, 1, 0, 0, 0);
    // LocalDateTime endDatetime = LocalDateTime.of(2023, 1, 10, 0, 0, 0);
    // LocalDateTime startDatetime = LocalDateTime.of(2021, 12, 1, 0, 0, 0);
    // LocalDateTime endDatetime = LocalDateTime.of(2022, 1, 10, 0, 0, 0);
    // return postRepository.findAllByCdateBetween(memberDto.getSdate(), memberDto.getEdate());
  //   return null;
  // }

  public Optional<Post> getEntity(Long id) {
    return postRepository.findById(id);
    // return memberRepository.getReferenceById(id);
    // Optional<Post> member = memberRepository.getReferenceById(id);
  }

  public void deleteEntity(Long id) {
    postRepository.deleteById(id);
  }
}
