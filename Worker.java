import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Worker {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    int id;
    String status;
    String name;
    String experience;
    String education;
    String department;

    public Worker() throws IOException {
    }

    public void setAll() throws IOException {
        System.out.print("Введите id: ");
        String id_user = reader.readLine();
        this.id = Integer.parseInt(id_user);
        System.out.print("Введите статус: ");
        this.status = reader.readLine();
        System.out.print("Введите Имя: ");
        this.name = reader.readLine();
        System.out.print("Введите Опыт работы: ");
        this.experience = reader.readLine();
        System.out.print("Введите Уровень образования: ");
        this.education = reader.readLine();
        System.out.print("Введите Отдел: ");
        this.department = reader.readLine();
    }

    public StringBuilder getAllInfo () {
        StringBuilder info = new StringBuilder();
        info.append(id + "\t").append(status + "\t").append(name + "\t").
                append(experience + "\t").append(education + "\t").append(department);
        return info;
    }
}


