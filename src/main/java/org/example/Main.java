package org.example;

import org.example.entity.Worker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/crud";
    private static final String USER = "root";
    private static final String PASS = "password";
    private static final String INSERT_STATEMENT = " INSERT INTO `crud`.`people` (`id`, `status`, `Name`, `Experience`, `Education`, `Departament`) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = " SELECT * FROM `crud`.`people`";


    public static void main(String[] args) {
        try {
            ArrayList<Worker> companyWorkers = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите колличество сотрудников, которое вы хотите добавить: ");
            String worker_n = reader.readLine();
            int number = Integer.parseInt(worker_n);

            try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);

                for (int i = 1; i <= number; i++) {
                    System.out.print("Информация о сотруднике № " + i + ":");

                    System.out.print("Введите статус: ");
                    String status = reader.readLine();

                    System.out.print("Введите Имя: ");
                    String name = reader.readLine();

                    System.out.print("Введите Опыт работы: ");
                    String experience = reader.readLine();

                    System.out.print("Введите Уровень образования: ");
                    String education = reader.readLine();

                    System.out.print("Введите Отдел: ");
                    String department = reader.readLine();

                    Worker worker = new Worker(i,
                            status,
                            name,
                            experience,
                            education,
                            department);

                    companyWorkers.add(worker);
                }

                for (Worker worker : companyWorkers) {
                    setValuesInPreparedStatement(preparedStatement, worker);
                    preparedStatement.executeUpdate();
                }

                companyWorkers.clear();
                System.out.println("Список сотрудников: ");
                preparedStatement = connection.prepareStatement(SELECT_STATEMENT);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getResultSet();

                while (resultSet.next()) {
                    Worker worker = new Worker();
                    worker.setId(resultSet.getInt("id"));
                    worker.setStatus(resultSet.getString("status"));
                    worker.setName(resultSet.getString("Name"));
                    worker.setEducation(resultSet.getString("Education"));
                    worker.setExperience(resultSet.getString("Experience"));
                    worker.setDepartment(resultSet.getString("Departament"));
                    companyWorkers.add(worker);
                }

                companyWorkers.forEach(System.out::println);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void setValuesInPreparedStatement(PreparedStatement preparedStatement, Worker worker) throws SQLException {
        preparedStatement.setInt(1, worker.getId());
        preparedStatement.setString(2, worker.getStatus());
        preparedStatement.setString(3, worker.getName());
        preparedStatement.setString(4, worker.getExperience());
        preparedStatement.setString(5, worker.getEducation());
        preparedStatement.setString(6, worker.getDepartment());
    }
}
