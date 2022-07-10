package com.example.myService.service;

import org.springframework.stereotype.Service;

@Service
public class ResultService {
    String answer;
    public void forResult(int kind, int time, int love) {
        if(kind==0 && time==0 && love==0) answer="(고양이)페르시안";
        else if(kind==0 && time==0 && love==1) answer="(고양이)아메리칸 숏헤어";
        else if(kind==0 && time==1 && love==0) answer="(고양이)랙돌";
        else if(kind==0 && time==1 && love==1) answer="(고양이)먼치킨";
        else if(kind==1 && time==0 && love==0) answer="(강아지)불독";
        else if(kind==1 && time==0 && love==1) answer="(강아지)말티즈";
        else if(kind==1 && time==1 && love==0) answer="(강아지)푸들";
        else if(kind==1 && time==1 && love==1) answer="(강아지)웰시코기";
    }

    public String result() {
        return answer;
    }
}
