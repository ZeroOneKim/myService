package com.example.myService.controller.restapi;

public class CatNotFoundException extends RuntimeException {
    public CatNotFoundException(Long id) {
        super("cat에서 찾을수 없어요" + id);
    }
}
