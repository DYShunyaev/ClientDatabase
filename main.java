import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        try {
            ArrayList<String> companyWorkers = new ArrayList<>();

            Worker worker = new Worker();

            String url = "jdbc:mysql://localhost:3306/crud";
            String user = "root";
            String pass = "Pbvf4820!";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите колличество сотрудников, которое вы хотите добавить: ");
            String worker_n = reader.readLine();
            int number = Integer.parseInt(worker_n);

            for (int i = 0; i < number; i++) {
                System.out.println("Информация о сотруднике № " + (i + 1) + ":");
                worker.setAll();

                try (Connection connection = DriverManager.getConnection(url, user, pass)) {
                    String sql = "INSERT INTO `crud`.`people` (`id`, `status`, `Name`, `Experience`, `Education`, `Departament`) \" +\n" +
                            "                        \"VALUES ('?', '?', '?', '?', '?', '?')";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, worker.id);
                    preparedStatement.setString(2, worker.status);
                    preparedStatement.setString(3, worker.name);
                    preparedStatement.setString(4, worker.experience);
                    preparedStatement.setString(5, worker.education);
                    preparedStatement.setString(6, worker.department);

                    int rows = preparedStatement.executeUpdate();

                }

                worker.getAllInfo();
                companyWorkers.add(worker.getAllInfo().toString());
                System.out.println("\n");
            }

            System.out.println("Список сотрудников: ");
            for (String table : companyWorkers) {
                System.out.println(table);
            }

        }

        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
