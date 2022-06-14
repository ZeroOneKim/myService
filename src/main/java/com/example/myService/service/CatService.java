package com.example.myService.service;

import com.example.myService.entity.Cat;
import com.example.myService.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class CatService {
    @Autowired
    public CatRepository catRepository;
    public String catwrite(Cat cat, MultipartFile file) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\catfiles";
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, filename);
        file.transferTo(saveFile);

        cat.setCat_filename(filename);
        cat.setCat_filepath("/catfiles/" + filename);
        catRepository.save(cat);

        String answer = "작업 성공";
        return answer;
    }

    private List<Cat> cat = catRepository.findAll();
}
