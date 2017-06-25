package ru.lesson.lessons.PetClinic.store;

import ru.lesson.lessons.PetClinic.models.Doctor;
import ru.lesson.lessons.PetClinic.models.User;
import ru.lesson.lessons.PetClinic.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Andrey on 20.06.2017.
 */
public class JdbcStorage implements Storage {

    private final Connection connection;

    public JdbcStorage() {
        final Settings settings = Settings.getInstance();

        try {
            Class.forName(settings.value("jdbc.driver_class"));  // ?? ??????? ????????? ??? ?????
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


    @Override
    public Collection<User> values() {
        final List<User> users = new ArrayList();
        try { final Statement statement = this.connection.createStatement();
        final ResultSet rs = statement.executeQuery("SELECT * FROM client");
            {
                while (rs.next()) {
                    users.add(new User(rs.getInt("uid"), rs.getString("name"), rs.getString("email"), rs.getString("password")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void add(User user) {
        try {
            final PreparedStatement statement = this.connection.prepareStatement("insert into client(name, password, email, doctor_id) values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, 1);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editUser(User user) {
        try {
            final PreparedStatement statement = this.connection.prepareStatement("update client as client set name = ?, password = ? where client.uid = ?", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void editDoctor(Doctor doctor) {

    }

    @Override
    public void deleteUser(int id) {
        try {
            final PreparedStatement statement = this.connection.prepareStatement("delete from client where uid = ?", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDoctor(int id) {

    }

    @Override
    public User getUser(int id) {

        try {
            final PreparedStatement statement = this.connection.prepareStatement("select * from client where uid = ?");
            statement.setInt(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("uid"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Doctor getDoctor(int id) {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        try {
            final PreparedStatement statement = this.connection.prepareStatement("select * from client where email = ?");
            statement.setString(1, login);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("uid"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
