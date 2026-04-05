package in.bharath.serviceImplementation;

import in.bharath.entity.FinancialRecord;
import in.bharath.entity.RecordType;
import in.bharath.repository.RecordRepository;
import in.bharath.serviceInterface.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository repo;

    @Override
    public FinancialRecord save(FinancialRecord record) {

        // Validation
        if (record.getAmount() <= 0) {
            throw new RuntimeException("Amount must be positive");
        }

        return repo.save(record);
    }

    @Override
    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // 🔥 FILTER METHODS

    @Override
    public List<FinancialRecord> getByType(RecordType type) {
        return repo.findByType(type);
    }

    @Override
    public List<FinancialRecord> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    @Override
    public List<FinancialRecord> getByDate(LocalDate date) {
        return repo.findByDate(date);
    }
}