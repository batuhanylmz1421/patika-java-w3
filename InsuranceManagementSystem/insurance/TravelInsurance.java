package insurance;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TravelInsurance extends Insurance {

    public TravelInsurance(String name, double fee, Date startDate, Date dueDate) {
        super(name, fee, startDate, dueDate);
    }

    @Override
    public double calculate() {
        // Calculating remaining Insurance costs (DAY)
        long diff = this.getDueDate().getTime() - this.getStartDate().getTime();
        diff = diff < 0 ? 0 : diff;
        int remainDate = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return (double) (this.getFee() *  remainDate);
    }
}
