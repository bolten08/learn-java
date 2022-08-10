package com.learn.java.repository;


import com.learn.java.entity.UserEntity;
import com.learn.java.exception.NotFoundException;
import com.learn.java.service.DbService;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@Repository
public class UserRepository {

    public void createTable() {
        String sql = "CREATE TABLE USERS " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " email VARCHAR(255), " +
                " password VARCHAR(255), " +
                " first_name VARCHAR(255), " +
                " last_name VARCHAR(255), " +
                " PRIMARY KEY ( id ))";

        try (Statement statement = DbService.getStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Таблица USERS уже существует");
        }
    }

    public Optional<UserEntity> findByEmail(String email) {
        Optional<UserEntity> user = Optional.empty();
        String sql = String.format("SELECT * FROM users WHERE email = '%s'", email);

        try (Statement statement = DbService.getStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                user = Optional.of(
                        new UserEntity(
                                rs.getLong("id"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("first_name"),
                                rs.getString("last_name")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


    public void save(UserEntity user) {
        String sql = String.format("INSERT INTO users(email, password, first_name, last_name) VALUES('%s', '%s', '%s', '%s')",
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName()
        );

        try (Statement statement = DbService.getStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
