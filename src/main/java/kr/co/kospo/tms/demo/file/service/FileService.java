package kr.co.kospo.tms.demo.file.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileService {
  
  @Value("${app.upload-dir}")
  private String fileDir;

  // private final FileRepository fileRepository;

  public Long saveFile(MultipartFile files) throws IOException {
      if (files.isEmpty()) {
          return null;
      }

      // 원래 파일 이름 추출
      String origName = files.getOriginalFilename();

      // 파일 이름으로 쓸 uuid 생성
      String uuid = UUID.randomUUID().toString();

      // 확장자 추출(ex : .png)
      // String extension = origName.substring(origName.lastIndexOf("."));
      String extension = Optional.of(origName).get().substring(Optional.of(origName).get().lastIndexOf("."));

      // uuid와 확장자 결합
      String savedName = uuid + extension;

      // 파일을 불러올 때 사용할 파일 경로
      String savedPath = fileDir + savedName;

      // 파일 엔티티 생성
      // FileEntity file = FileEntity.builder()
      //         .orgNm(origName)
      //         .savedNm(savedName)
      //         .savedPath(savedPath)
      //         .build();

      // 실제로 로컬에 uuid를 파일명으로 저장
      files.transferTo(new File(savedPath));

      // 데이터베이스에 파일 정보 저장 
      // FileEntity savedFile = fileRepository.save(file);

      // return savedFile.getId();

      return 1L;
  }

  // https://jforj.tistory.com/135
  public ResponseEntity<Object> downloadFile(String fileName) {
		try {
			Path filePath = Paths.get(fileDir + fileName);
			Resource resource = new InputStreamResource(Files.newInputStream(filePath)); // 파일 resource 얻기
			
			// File file = new File(fileDir);
			
			HttpHeaders headers = new HttpHeaders();
      // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
			headers.setContentDisposition(ContentDisposition.builder("attachment")
        // .filename(file.getName())
        .filename("image.PNG")
        .build());  
			
			return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
}
