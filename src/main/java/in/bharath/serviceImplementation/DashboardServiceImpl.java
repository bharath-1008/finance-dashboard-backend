package in.bharath.serviceImplementation;

import in.bharath.entity.RecordType;
import in.bharath.repository.RecordRepository;
import in.bharath.serviceInterface.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private RecordRepository repo;

    @Override
    public Double totalIncome() {
        Double income = repo.getTotalByType(RecordType.INCOME);
        return income == null ? 0.0 : income;
    }

    @Override
    public Double totalExpense() {
        Double expense = repo.getTotalByType(RecordType.EXPENSE);
        return expense == null ? 0.0 : expense;
    }

    @Override
    public Double netBalance() {
        return totalIncome() - totalExpense();
    }
}