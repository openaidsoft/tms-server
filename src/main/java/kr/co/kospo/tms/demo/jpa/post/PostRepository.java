package kr.co.kospo.tms.demo.jpa.post;

// import java.time.LocalDateTime;
// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
  // List<Post> findAllByCdateBetween(LocalDateTime start, LocalDateTime end);
}