package org.anonymous.train.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Lazy
@Service
@RequiredArgsConstructor
public class PredictService {

    @Value("${python.path}")
    private String runPath;

    @Value("${python.script}")
    private String scriptPath;

    private final ObjectMapper om;

    public List<Integer> predict(List<Double> items) {
        try {
            String data = om.writeValueAsString(items);

            ProcessBuilder processBuilder = new ProcessBuilder(runPath, runPath + "predict.py", data);

            Process process = processBuilder.start();
            InputStream in = process.getInputStream();



            return om.readValue(in.readAllBytes(), new TypeReference<>() {});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
































