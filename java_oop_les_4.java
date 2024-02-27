// — Создать класс УчительСервис и реализовать аналогично проделанному на семинаре;
// — Создать класс УчительВью и реализовать аналогично проделанному на семинаре;
// — Создать класс УчительКонтроллер и реализовать возможность создания, редактирования конкретного учителя и отображения списка учителей, имеющихся в системе.

// Формат сдачи: ссылка на гитхаб проект

public class TeacherService {
    public TeacherService() {
        // Инициализация сервиса
    }

    public void createTeacher(TeacherData teacherData) {
        // создания нового учителя
    }

    public void editTeacher(int teacherId, TeacherData newTeacherData) {
        // редактирования учителя
    }

    public List<TeacherData> getTeachersList() {
        // получения списка учителей
        return new ArrayList<>(); // замена на реальные данные
    }
}


public class TeacherView {
    public TeacherView() {
        // Инициализация вью
    }

    public void displayTeacher(TeacherData teacherData) {
        // отображения данных об учителе
    }

    public void displayTeachersList(List<TeacherData> teachersList) {
        // отображения списка учителей
    }
}


public class TeacherController {
    private TeacherService teacherService;
    private TeacherView teacherView;

    public TeacherController(TeacherService teacherService, TeacherView teacherView) {
        this.teacherService = teacherService;
        this.teacherView = teacherView;
    }

    public void createTeacher(TeacherData teacherData) {
        // создания учителя через сервис и отображение результатов через вью
    }

    public void editTeacher(int teacherId, TeacherData newTeacherData) {
        // редактирования учителя через сервис и отображение результатов через вью
    }

    public void displayTeachersList() {
        // получения списка учителей через сервис и отображение через вью
    }
}
