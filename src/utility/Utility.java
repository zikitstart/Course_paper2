package utility;

import task.Constants;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Utility {
    public static Constants checkRepeatability(Scanner scanner) {
        System.out.println("Выберите повторяемость задачи: \n1. Одноразовая.\n2. Ежедневная.\n3. Еженедельная.\n4. Ежемесячная.\n5. Ежегодная.");
        while (true) {
            try {
                System.out.print("Выберите пункт меню: ");
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        return Constants.ONE_TIME;
                    case 2:
                        return Constants.DAILY;
                    case 3:
                        return Constants.WEEKLY;
                    case 4:
                        return Constants.MONTHLY;
                    case 5:
                        return Constants.ANNUAL;
                    default:
                        System.out.println("Выберите пункт меню из списка!");
                }
            } catch (Exception e) {
                System.out.println("Выберите пункт меню из списка!");
                scanner.nextLine();
            }
        }
    }
    public static Constants checkType(Scanner scanner) {
        System.out.println("Выберите тип задачи: \n1. Личная.\n2. Рабочая.");
        while (true) {
            try {
                System.out.print("Выберите пункт меню: ");
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        return Constants.PERSONAL;
                    case 2:
                        return Constants.WORK;
                    default:
                        System.out.println("Введён не правильный тип задачи!");
                }
            } catch (Exception e) {
                System.out.println("Введён не правильный тип задачи!");
                scanner.nextLine();
            }
        }
    }
    public static String checkHeading(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите название задачи: ");
                String heading = scanner.useDelimiter("\n").next();
                if (heading == null || heading.isBlank() || heading.isEmpty()) {
                    throw new IllegalArgumentException("Название обязательно к заполнению!");
                }
                System.out.println("Название задачи: " + heading);
                return heading;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static String checkDescription(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите описание задачи: ");
                String description = scanner.useDelimiter("\n").next();
                if (description == null || description.isBlank() || description.isEmpty()) {
                    throw new IllegalArgumentException("Описание обязательно к заполнению!");
                }
                System.out.println("Описание задачи: " + description);
                return description;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static LocalDate checkDate(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите дату выполнения задачи(в формате: yyyy-MM-dd): ");
                String date = scanner.useDelimiter("\n").next();
                LocalDate.parse(date);
                LocalDate localDate = LocalDate.parse(date);
                System.out.println("Дата выполнения задачи: " + date);
                return localDate;
            } catch (DateTimeParseException e) {
                System.out.println("Введите дату корректно! В формате: yyyy-MM-dd");
            }
        }
    }
    public static LocalTime checkTime(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите время выполнения задачи(в формате: HH:mm): ");
                String time = scanner.useDelimiter("\n").next();
                LocalTime.parse(time);
                LocalTime localTime = LocalTime.parse(time);
                System.out.println("Время выполнения задачи: " + localTime);
                return localTime;
            } catch (DateTimeParseException e) {
                System.out.println("Введите время корректно! В формате: HH:mm");
            }
        }
    }
}