package com.example.myService.service;

import org.springframework.stereotype.Service;

@Service
public class ResultService {
    String answer;
    public void forResult(int kind, int time, int love) {

        answer = "kind";
    }

    public String result() {
        return answer;
    }
}
