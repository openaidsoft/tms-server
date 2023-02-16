package kr.co.kospo.tms.demo.jpa.post;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class) // @EnableJpaAuditing 사용시 필요
@Table(name = "post")
public class Post {

  @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "post_id")
  private Long postId;

  @NotNull
  @Column(name = "author")
  private String author;

  @NotNull
  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  // /*
  //   @NotNull과 nullable = false
  //   둘 다 not null을 표현하고 DDL에서 NOT NULL 제약 조건을 추가함
  //   @NotNull 사용시는 DB 쿼리를 보내기 전에 예외 발생
  //   대부분 @NotNull을 사용하면 좋겠지만 이 상황에서는 레코드가 생성될 때 
  //   cdate는 null로 넘어오고 @EnableJpaAuditing에서 cdate를 채울 것이기 때문에
  //   @NotNull을 사용하면 파라미터의 cdate값이 null이란 이유로 cdate 값이 채워지기 전에 예외 발생함

  //   updatable = false는 업데이트 시에는 @EnableJpaAuditing이 값을 채우지 않도록하는 설정
  //  */
  @CreatedDate
  @Column(name = "c_date", nullable = false, updatable = false)
  private LocalDateTime cdate;

  @LastModifiedDate
  @Column(name = "u_date", nullable = false)
  private LocalDateTime udate;

  @Builder
  public Post(Long postId, String author, String title, String content) {
    this.postId = postId;
    this.author = author;
    this.title = title;
    this.content = content;
  }
}
