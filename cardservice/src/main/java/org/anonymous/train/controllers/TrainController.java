package org.anonymous.train.controllers;

import lombok.RequiredArgsConstructor;
import org.anonymous.train.entities.TrainData;
import org.anonymous.train.service.PredictService;
import org.anonymous.train.service.TrainService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Profile("ml")
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
    public List<Integer> predict(@RequestParam("data") String data) { // RequestParam - 쿼리스트링 까먹지마라
        List<Double> items = Arrays.stream(data.split("_")).map(Double::valueOf
        ).toList();
        System.out.println("items : " + items);
        return predictService.predict(items);
    }


}



























