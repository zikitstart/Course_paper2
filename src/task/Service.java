package task;

import utility.Utility;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
public class Service {
    public static void takeMenu() {
        Map<Integer, AllTask> taskMap = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            Service.putTask(taskMap,scanner);
                            break;
                        case 2:
                            Service.removeTasks(taskMap,scanner);
                            break;
                        case 3:
                            Service.getTasksForDay(taskMap,scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }
    public static void getTasksForDay(Map<Integer, AllTask> taskMap,Scanner scanner) {
        List<AllTask> tasks = new ArrayList<>();
        System.out.print("Укажите дату: ");
        String s = "На указанную дату нет задач.";
        LocalDate date = LocalDate.parse(scanner.useDelimiter("\n").next());
        for (AllTask task : taskMap.values()) {
            if (task.appearsIn(date)) {
                tasks.add(task);
                s = "Список задач на указанную дату: ";
            }
        }
        System.out.println(s);
        for (AllTask task : tasks) {
            System.out.println(task);
        }
    }
    public static void removeTasks(Map<Integer, AllTask> taskMap,Scanner scanner) {
        System.out.print("Укажите id: ");
        int id = scanner.nextInt();
        String i = "Данный id не существует.";
        for (Map.Entry<Integer, AllTask> localDateAllTaskEntry : taskMap.entrySet()) {
            if (localDateAllTaskEntry.getKey() == id){
                taskMap.remove(localDateAllTaskEntry.getKey());
                i = "Данный id удалён.";
                break;
            }
        }
        System.out.println(i);
    }
    public static void putTask(Map<Integer, AllTask> taskMap,Scanner scanner) {
        Constants repeatability = Utility.checkRepeatability(scanner);
        Constants type = Utility.checkType(scanner);
        String heading = Utility.checkHeading(scanner);
        String description = Utility.checkDescription(scanner);
        LocalDate date = Utility.checkDate(scanner);
        LocalTime time = Utility.checkTime(scanner);

        AllTask task = new AllTask(repeatability,type, heading, description, date, time);
        System.out.println(task);
        taskMap.put(task.getId(),task);
    }
    public static void printMenu() {
        System.out.println("########################");
        System.out.println("1. Добавить задачу.");
        System.out.println("2. Удалить задачу.");
        System.out.println("3. Получить задачу на указанный день.");
        System.out.println("0. Выход.");
    }
}