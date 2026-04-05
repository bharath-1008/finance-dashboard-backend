package in.bharath.controller;

import in.bharath.serviceInterface.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping("/summary")
    public Map<String, Object> summary() {

        Map<String, Object> map = new HashMap<>();

        map.put("totalIncome", service.totalIncome());
        map.put("totalExpense", service.totalExpense());
        map.put("netBalance", service.netBalance());

        return map;
    }
}