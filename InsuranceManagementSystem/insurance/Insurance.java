package insurance;

import java.util.Date;

public abstract class Insurance {
    private String name;
    private double fee;
    private Date startDate;
    private Date dueDate;

    public double calculate() {
        return 0;
    }

    public Insurance(String name, double fee, Date startDate, Date dueDate) {
        this.name = name;
        this.fee = fee;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
