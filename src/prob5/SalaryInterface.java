package prob5;

import java.time.LocalDate;

public interface SalaryInterface {
	default double computeBonus() {
		int hireYear = getHireDate().getYear();
		int thisYear = LocalDate.now().getYear();
		return 400 * (thisYear - hireYear);
	}

	LocalDate getHireDate();
	
	
}
