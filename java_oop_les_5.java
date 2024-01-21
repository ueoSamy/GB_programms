// TeacherService.java (Модель)
public class TeacherService {
    private List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    // Другие методы для редактирования информации о преподавателях
}

// TeacherView.java (Представление)
public class TeacherView {
    public void printTeacherDetails(Teacher teacher) {
        System.out.println("Teacher Details:");
        System.out.println("Name: " + teacher.getName());
        System.out.println("Subject: " + teacher.getSubject());
        System.out.println("ID: " + teacher.getId());
        System.out.println("---------------------");
    }

    public void printAllTeachers(List<Teacher> teachers) {
        System.out.println("All Teachers:");
        for (Teacher teacher : teachers) {
            printTeacherDetails(teacher);
        }
    }
}

// TeacherController.java (Контроллер)
import java.util.Scanner;

public class TeacherController {
    private TeacherService teacherService;
    private TeacherView teacherView;

    public TeacherController(TeacherService teacherService, TeacherView teacherView) {
        this.teacherService = teacherService;
        this.teacherView = teacherView;
    }

    public void createTeacher(String name, String subject, int id) {
        Teacher teacher = new Teacher(name, subject, id);
        teacherService.addTeacher(teacher);
    }

    public void displayAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        teacherView.printAllTeachers(teachers);
    }

    // Другие методы для взаимодействия с данными о преподавателях
}

// Teacher.java (Класс, представляющий модель преподавателя)
public class Teacher {
    private String name;
    private String subject;
    private int id;

    public Teacher(String name, String subject, int id) {
        this.name = name;
        this.subject = subject;
        this.id = id;
    }

    // Геттеры и сеттеры

    // Пример:
    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public int getId() {
        return id;
    }
}

// Пример использования в Main.java
public class Main {
    public static void main(String[] args) {
        TeacherService teacherService = new TeacherService();
        TeacherView teacherView = new TeacherView();
        TeacherController teacherController = new TeacherController(teacherService, teacherView);

        teacherController.createTeacher("John Doe", "Math", 1);
        teacherController.createTeacher("Jane Doe", "Science", 2);

        teacherController.displayAllTeachers();
    }
}
