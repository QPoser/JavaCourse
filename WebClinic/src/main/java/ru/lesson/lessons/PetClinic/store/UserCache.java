package ru.lesson.lessons.PetClinic.store;

import ru.lesson.lessons.PetClinic.models.Doctor;
import ru.lesson.lessons.PetClinic.models.User;

import java.util.Collection;

/**
 * Created by Andrey on 31.05.2017.
 */
public class UserCache implements Storage {
    private static final UserCache INSTANCE = new UserCache();

    //private final Storage storage = new MemoryStorage();

    //private final Storage storage = new JdbcStorage();

    private final Storage storage = new HibernateStorage();

    public static UserCache getInstance() { return INSTANCE; }


    @Override
    public Collection<User> values() {
        return this.storage.values();
    }

    @Override
    public void add(User user) {
        this.storage.add(user);
    }

    @Override
    public void editUser(User user) {
        this.storage.editUser(user);
    }

    @Override
    public void editDoctor(Doctor doctor) {
        this.storage.editDoctor(doctor);
    }

    @Override
    public void deleteUser(int id) {
        this.storage.deleteUser(id);
    }


    @Override
    public User getUser(int id) {
        return this.storage.getUser(id);
    }

    @Override
    public Doctor getDoctor(int id) {
        return this.storage.getDoctor(id);
    }

    @Override
    public User findByLogin(String login) {
        return this.storage.findByLogin(login);
    }

    @Override
    public int generateId() {
        return this.storage.generateId();
    }

    @Override
    public void close() {
        this.storage.close();
    }
}
