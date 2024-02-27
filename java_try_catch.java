import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class PersonalData {
    private String lastName;
    private String firstName;
    private String middleName;
    private String dateOfBirth;
    private long phoneNumber;
    private char gender;

    public PersonalData(String lastName, String firstName, String middleName, String dateOfBirth, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " + dateOfBirth + " " + phoneNumber + " " + gender;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в следующем порядке, разделенные пробелом: Фамилия Имя Отчество дата_рождения номер_телефона пол");
        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 6) {
            System.out.println("Ошибка: количество данных не соответствует требуемому формату.");
            return;
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String dateOfBirth = data[3];
        long phoneNumber;
        char gender;

        try {
            phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: номер телефона должен быть целым числом.");
            return;
        }

        if (!data[5].equals("f") && !data[5].equals("m")) {
            System.out.println("Ошибка: пол должен быть указан как 'f' или 'm'.");
            return;
        }
        gender = data[5].charAt(0);

        PersonalData personalData = new PersonalData(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
        String fileName = lastName + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(personalData.toString());
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }

        System.out.println("Данные успешно записаны в файл " + fileName);
    }
}
