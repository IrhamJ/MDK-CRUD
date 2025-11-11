package org.mdk.dao;

import org.mdk.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private String jdbcURL = "jdbc:mysql://mysql_db:3306/crud_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_root_password";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT id, name, position, salary FROM employee ORDER BY id ASC";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT id, name, position, salary FROM employee WHERE id = ?";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employee WHERE id = ?";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employee SET name = ?, position = ?, salary = ? WHERE id = ?";

    protected Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found.");
            e.printStackTrace();
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertEmployee(Employee employee) {
        System.out.println(INSERT_EMPLOYEE_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPosition());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public List<Employee> selectAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");
                employees.add(new Employee(id, name, position, salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }


    public Employee selectEmployee(int id) {
        Employee employee = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");
                employee = new Employee(id, name, position, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPosition());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setInt(4, employee.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {

            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}