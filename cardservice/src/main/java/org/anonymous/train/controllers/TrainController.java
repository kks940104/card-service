package org.anonymous.train.controllers;

import lombok.RequiredArgsConstructor;
import org.anonymous.train.entities.TrainData;
import org.anonymous.train.service.PredictService;
import org.anonymous.train.service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TrainController {

    private final TrainService trainService;
    private final PredictService predictService;

    @GetMapping("/train/{mode}") // 훈련데이터
    public List<TrainData> train(@PathVariable("mode") String mode) {
        return trainService.getList(mode.equals("all"));
    }

    @GetMapping("/predict") // 정답데이터
    public List<Integer> predict(@RequestParam("data") List<Double> items) { // RequestParam - 쿼리스트링 까지마라
        return predictService.predict(items);
    }


}



























