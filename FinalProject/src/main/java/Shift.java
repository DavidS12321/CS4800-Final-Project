public enum Shift {
    FIRST_SHIFT("08:00", "16:00"),
    SECOND_SHIFT("16:00", "00:00"),
    THIRD_SHIFT("00:00", "08:00");

    private final String startTime;
    private final String endTime;

    Shift(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}