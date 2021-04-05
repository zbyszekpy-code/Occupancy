package com.ambit.occupancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OccupancyController {

    @Autowired
    private OccupancyService occupancyService;

    @GetMapping("/calculateUsage")
    UsagePair calculateUsage(@RequestParam long premiumCount, @RequestParam long economyCount, @RequestBody List<Integer> customers) {
        System.out.println(premiumCount);
        return occupancyService.calculateUsage(premiumCount, economyCount, customers);
    }
}
