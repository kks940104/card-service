package org.anonymous.train;

import org.anonymous.train.entities.TrainData;
import org.anonymous.train.repositories.TrainDataRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles({"default", "ml"})
public class TrainTest {

    @Autowired
    private TrainDataRepository repository;

    @Test
    @DisplayName("금액별로 설정해서 훈련.")
    void test1() {
        List<TrainData> items = new ArrayList<>();
        TrainData item1 = TrainData.builder()
                .item1(1000.0)
                .item2(2000.0)
                .target(0)
                .build();
        items.add(item1);
        TrainData item2 = TrainData.builder()
                .item1(2000.0)
                .item2(3000.0)
                .target(1)
                .build();
        items.add(item2);
        TrainData item3 = TrainData.builder()
                .item1(3000.0)
                .item2(4000.0)
                .target(2)
                .build();
        items.add(item3);
        TrainData item4 = TrainData.builder()
                .item1(4000.0)
                .item2(5000.0)
                .target(3)
                .build();
        items.add(item4);

        repository.saveAllAndFlush(items);
    }

}



















