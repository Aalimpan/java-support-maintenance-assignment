import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: Initializes result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Prevents NullPointerException when accounts list is null
        if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {

            // FIX: dueDate may be null for restructured accounts
            if (account.getDueDate() != null
                    && account.getDueDate().before(new Date())) {

                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }

        return result;
    }
}