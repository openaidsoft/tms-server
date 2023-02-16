package kr.co.kospo.tms.demo.file;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kospo.tms.demo.file.service.FileService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("demo/file")
public class FileController {
  
  private final FileService fileService;

  @GetMapping("upload")
  public String testUploadForm() {
      return "You should use POST";
  }

  @PostMapping("upload")
  public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("files") List<MultipartFile> files) throws IOException {
      fileService.saveFile(file);

      for (MultipartFile multipartFile : files) {
          fileService.saveFile(multipartFile);
      }

      return "redirect:/";
  }

  @GetMapping("download")
	public ResponseEntity<Object> downloadFile(@RequestParam("filename") String fileName) {
    return fileService.downloadFile(fileName);
	}
}
