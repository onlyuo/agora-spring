package com.demos.agora.service;

import com.demos.agora.model.manner.MannerRepository;
import com.demos.agora.model.mood.MoodRepository;
import com.demos.agora.web.dto.evaluate.EvalRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluateService {
    private final MoodRepository moodRepository;
    private final MannerRepository mannerRepository;



   /* @Transactional(readOnly = true)
    public List<EvalRespDto> 평가해야할분위기(int userId){
        return moodRepository.평가해야할분위기(userId);
    }

    @Transactional(readOnly = true)
    public List<EvalRespDto> 평가해야할매너(int userId){
        return mannerRepository.평가해야할매너(userId);
    }*/


    @Transactional(readOnly = true)
    public List<EvalRespDto> 평가해야할목록(int userId){

        List<EvalRespDto> mood=new ArrayList<>( moodRepository.평가해야할분위기(userId));
        List<EvalRespDto> manner=new ArrayList<>(mannerRepository.평가해야할매너(userId));
        List<EvalRespDto> list=new ArrayList<>();

       /* mood= moodRepository.평가해야할분위기(userId);
        manner=mannerRepository.평가해야할매너(userId);*/

        list.addAll(mood);
        list.addAll(manner);

        return list;
    }


    /*
    * 스터디 가입날짜와 현재날짜를 주기적으로 비교하여 2주가 되었을 경우
    * client로 스터디 평가를 진행해야 된다는 알림을 보내는 서비스 필요
    * @Scheduled라는 어노테이션을 사용하여 DB에서 하루에 한번씩 계산
    * 설문 끝나면 delete하기
    * */
    
}
