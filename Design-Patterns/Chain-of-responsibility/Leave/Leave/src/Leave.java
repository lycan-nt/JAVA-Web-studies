public class Leave {

    private int numberOfDays;
    private int empTier;
    private ReasonType reason;

    public Leave(int numberOfDays, int empTier, ReasonType reason) {
        this.numberOfDays = numberOfDays;
        this.empTier = empTier;
        this.reason = reason;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int getEmpTier() {
        return empTier;
    }

    public ReasonType getReason() {
        return reason;
    }

}
