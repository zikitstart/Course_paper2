package task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class AllTask {
    private final Constants repeatability;
    private final Constants type;
    private final String heading;
    private final String description;
    private final LocalDate date;
    private final LocalTime time;
    private static int counter = 1;
    private final int id;

    public AllTask(Constants repeatability, Constants type, String heading, String description, LocalDate date, LocalTime time) {
        this.repeatability = repeatability;
        this.type = type;
        this.heading = heading;
        this.description = description;
        this.date = date;
        this.time = time;
        id = counter++;
    }

    public Constants getRepeatability() {
        return repeatability;
    }
    public Constants getType() {
        return type;
    }
    public String getHeading() {
        return heading;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }
    public int getId() {
        return id;
    }

    public boolean appearsIn(LocalDate localDate){
        switch (getRepeatability()) {
            case ONE_TIME:
                return getDate().equals(localDate);
            case DAILY:
                return getDate().equals(localDate) || getDate().isBefore(localDate);
            case WEEKLY:
                return getDate().equals(localDate) || (getDate().isBefore(localDate) && getDate().getDayOfWeek().equals(localDate.getDayOfWeek()));
            case MONTHLY:
                return getDate().equals(localDate) || (getDate().isBefore(localDate) && getDate().getDayOfMonth() == (localDate.getDayOfMonth()));
            case ANNUAL:
                return getDate().equals(localDate) || (getDate().isBefore(localDate) && getDate().getDayOfYear() == (localDate.getDayOfYear()));
            default:
                return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllTask task = (AllTask) o;
        return id == task.id && Objects.equals(repeatability, task.repeatability) && Objects.equals(type, task.type) && Objects.equals(heading, task.heading) && Objects.equals(description, task.description) && Objects.equals(date, task.date) && Objects.equals(time, task.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repeatability, type, heading, description, date, time, id);
    }

    @Override
    public String toString() {
        return "Задача: { Тип: " + getType() +
                " ; Повторяемость: " + getRepeatability() +
                " ; Заголовок: " + getHeading() +
                " ; Описание: " + getDescription() +
                " ; Первая дата задачи: " + getDate() +
                " ; Время: " + getTime() +
                " ; id: " + getId() + " }";
    }
}