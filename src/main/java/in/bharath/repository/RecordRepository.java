package in.bharath.repository;

import in.bharath.entity.FinancialRecord;
import in.bharath.entity.RecordType;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RecordRepository extends JpaRepository<FinancialRecord, Long> {

    // 🔥 Dashboard query
    @Query("SELECT SUM(r.amount) FROM FinancialRecord r WHERE r.type = :type")
    Double getTotalByType(@Param("type") RecordType type);

    // 🔥 Filtering
    List<FinancialRecord> findByType(RecordType type);
    List<FinancialRecord> findByCategory(String category);
    List<FinancialRecord> findByDate(LocalDate date);
}