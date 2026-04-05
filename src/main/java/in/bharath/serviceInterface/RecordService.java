package in.bharath.serviceInterface;

import in.bharath.entity.FinancialRecord;
import in.bharath.entity.RecordType;

import java.time.LocalDate;
import java.util.List;

public interface RecordService {

    FinancialRecord save(FinancialRecord record);
    List<FinancialRecord> getAll();
    void delete(Long id);
    List<FinancialRecord> getByType(RecordType type);
    List<FinancialRecord> getByCategory(String category);
    List<FinancialRecord> getByDate(LocalDate date);
}