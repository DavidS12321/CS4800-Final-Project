public enum Shift {
    FIRST_SHIFT("8AM - 4PM"),
    SECOND_SHIFT("4PM - 12AM"),
    THIRD_SHIFT("12AM - 8AM");

    private final String time;

    Shift(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}