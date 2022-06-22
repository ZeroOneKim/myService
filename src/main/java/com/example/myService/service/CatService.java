package com.example.myService.service;

import com.example.myService.entity.Cat;
import com.example.myService.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@Service
public class CatService {
    @Autowired
    private CatRepository catRepository;
    public void catwrite(Cat cat, MultipartFile file, String username) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\catfiles";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, filename);
        file.transferTo(saveFile);
        cat.setCat_filename(filename);
        cat.setCat_filepath("/catfiles/" + filename);

        catRepository.save(cat);

    }
    public Page<Cat> cat(Pageable pageable) {
        return catRepository.findAll(pageable);

    }


    public void catDelete(Long id, String filename) {
        catRepository.deleteById(id); //일단 DB 삭제
        String deleteFile = System.getProperty("user.dir")+ "\\src\\main\\resources\\static\\catfiles\\"+filename;

        try {
            Files.delete(Path.of(deleteFile));
        } catch (NoSuchFileException e) {
            System.out.println("파일이 없음");
        } catch (IOException e) {
            throw new RuntimeException(e);  //자동완성기능 없었으면 구글링 했을듯
        }
    }
}
