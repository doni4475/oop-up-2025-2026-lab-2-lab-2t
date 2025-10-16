package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            return; // игнорируем некорректные значения
        }
        this.minutes += minutes;
        this.hours += hours + this.minutes / 60;
        this.minutes %= 60;
    }

    public void addTimeSpan(TimeSpan span) {
        add(span.getHours(), span.getMinutes());
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void subtract(TimeSpan span) {
        int total1 = getTotalMinutes();
        int total2 = span.getTotalMinutes();
        if (total2 > total1) return; // не меняем интервал
        int result = total1 - total2;
        hours = result / 60;
        minutes = result % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) return; // игнорируем некорректные значения
        int total = getTotalMinutes() * factor;
        hours = total / 60;
        minutes = total % 60;
    }
}
