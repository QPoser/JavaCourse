package ru.lesson.lessons.PetClinic.store;

import ru.lesson.lessons.PetClinic.models.Doctor;
import ru.lesson.lessons.PetClinic.models.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Andrey on 20.06.2017.
 */
public class MemoryStorage implements Storage {

    private final AtomicInteger ids = new AtomicInteger();

    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();


    @Override
    public Collection<User> values() {
        return this.users.values();
    }

    @Override
    public void add(User user) {
        this.users.put(user.getId(), user);
    }

    @Override
    public void editUser(User user) {
        this.users.replace(user.getId(), user);
    }

    @Override
    public void editDoctor(Doctor doctor) {

    }

    @Override
    public void deleteUser(int id) {
        this.users.remove(id);
    }

    @Override
    public void deleteDoctor(int id) {

    }


    @Override
    public Doctor getDoctor(int id) {
        return null;
    }

    @Override
    public User getUser(int id) {
        return this.users.get(id);
    }

    @Override
    public User findByLogin(String login) {
        for (final User user : users.values()) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new IllegalStateException(String.format("Login %s not found", login));
    }

    @Override
    public int generateId() {
        return this.ids.incrementAndGet();
    }

    @Override
    public void close() {

    }
}
