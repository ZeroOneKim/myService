package com.example.myService.service;

import com.example.myService.entity.Dog;
import com.example.myService.entity.User;
import com.example.myService.repository.DogRepository;
import com.example.myService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private UserRepository userRepository;

    public void dogwrite(Dog dog, MultipartFile multipartFile, String username) throws Exception {
        String justPath = System.getProperty("user.dir") + "\\src\\main\\resources\\main\\dogfiles";
        UUID randomName = UUID.randomUUID();
        String filename = randomName + "_" + multipartFile.getOriginalFilename();

        File saveFile = new File(justPath, filename);
        multipartFile.transferTo(saveFile);
        dog.setDog_filename(filename);
        dog.setDog_filepath("/dogflies/" + filename);

        User user = userRepository.findByUsername(username);
        dog.setUser(user);
        dogRepository.save(dog);
    }

    public Page<Dog> dog(Pageable pagealbe) {
        return dogRepository.findAll(pagealbe);
    }

    public void dogDelete(Long id, String filename) {
        dogRepository.deleteById(id);
        String deleteFile = System.getProperty("user.dir")+ "\\src\\main\\resources\\static\\dogfiles\\"+filename;
        try {
            Files.delete(Path.of(deleteFile));
        } catch (NoSuchFileException e) {
            System.out.println("파일이 없음");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
