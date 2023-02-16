package kr.co.kospo.tms.demo.mybatis.post.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostDto {
  private String type;
  private int postId;
  private String author;
  private String title;
  private String content;
  private String memo;

  // 첫 단어가 한 글자인 경우 다음 단어와 묶여 한 단어로 변환되므로 변환될 이름을 명시함
  // cDate -> cdate
  // https://unhosted.tistory.com/82
  @JsonProperty("sDate")
  private String sDate;
  
  @JsonProperty("eDate")
  private String eDate;

}
