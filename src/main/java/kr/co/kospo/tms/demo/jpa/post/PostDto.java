package kr.co.kospo.tms.demo.jpa.post;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDto {
  private Long postId;
  private String author;
  private String content;

  // @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  // private LocalDateTime cdate;

  // @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  // private LocalDateTime udate;

  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime sdate;

  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime edate;
}
