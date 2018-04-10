package me.innjoy.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 */
@RestController
@RequestMapping("/photo")
public class PhotoController {
    private final JdbcTemplate jdbcTemplate;
    private final ResourceLoader resourceLoader;

    @Autowired
    public PhotoController(JdbcTemplate jdbcTemplate, ResourceLoader resourceLoader) {
        this.jdbcTemplate = jdbcTemplate;
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("/upload")
    public String uploadPhoto(@RequestParam("uploadPhoto") MultipartFile file) throws IOException {
        if (file == null) {
            return "文件不能为空";
        }

        String path = "upload/" + file.getOriginalFilename();

        Files.copy(file.getInputStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
        jdbcTemplate.update("UPDATE room SET upload_photo = ?", path);
        return "上传成功";
    }

    @GetMapping(value = "/upload", produces = "image/png")
    public ResponseEntity<?> getUploadPhoto(HttpServletResponse response) {
        String photoPath = jdbcTemplate.queryForObject("SELECT upload_photo FROM room", String
                .class);
        if (photoPath == null) {
            return ResponseEntity.ok("未找到图片");
        }
        response.setContentType("image/png");
        return ResponseEntity.ok(resourceLoader.getResource("file:" + photoPath));
    }
}
