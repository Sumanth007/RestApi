package com.sumanth.RestApi.run;

/**
 * Copyright (c) 2024 Your Company. All rights reserved.
 * This file is licensed under the MIT License.
 * See the LICENSE file for details.
 */
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Copyright (c) 2024 Your Company. All rights reserved.
 * This file is licensed under the MIT License.
 * See the LICENSE file for details.
 */
@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(Integer id){
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()),run);
        }
    }

    void delete(Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.remove(runs.indexOf(existingRun.get()));
        }
    }

    @PostConstruct
    private void init(){
        runs.add(
                new Run(1,
                        "Monday Morning Running",
                        LocalDateTime.now(),
                        LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                        5, Location.OUTDOOR));

        runs.add(
                new Run(2,
                        "Wednesday Morning Running",
                        LocalDateTime.now(),
                        LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                        5, Location.OUTDOOR));
    }
}
