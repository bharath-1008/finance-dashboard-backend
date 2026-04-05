package in.bharath.controller;

import in.bharath.entity.*;
import in.bharath.serviceInterface.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService service;

    // CREATE
    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord record) {
        return service.save(record);
    }

    // GET ALL
    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAll();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted Successfully";
    }

    // 🔥 UPDATE
    @PutMapping("/{id}")
    public FinancialRecord update(@PathVariable Long id, @RequestBody FinancialRecord record) {
        record.setId(id);
        return service.save(record);
    }

    // 🔥 FILTER BY TYPE
    @GetMapping("/filter/type")
    public List<FinancialRecord> getByType(@RequestParam RecordType type) {
        return service.getByType(type);
    }

    // 🔥 FILTER BY CATEGORY
    @GetMapping("/filter/category")
    public List<FinancialRecord> getByCategory(@RequestParam String category) {
        return service.getByCategory(category);
    }

    // 🔥 FILTER BY DATE
    @GetMapping("/filter/date")
    public List<FinancialRecord> getByDate(@RequestParam String date) {
        return service.getByDate(LocalDate.parse(date));
    }
}