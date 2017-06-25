package ru.lesson.lessons.PetClinic.store;

import ru.lesson.lessons.PetClinic.models.Doctor;
import ru.lesson.lessons.PetClinic.models.User;

import java.util.Collection;

/**
 * Created by Andrey on 20.06.2017.
 */
public interface Storage {

    public Collection<User> values();

    public void add(final User user);

    public void editUser(final User user);

    public void editDoctor(final Doctor doctor);

    public void deleteUser(final int id);

    public void deleteDoctor(final int id);

    public User getUser(final int id);

    public Doctor getDoctor(final int id);

    public User findByLogin(final String login);

    public int generateId();

    public void close();
}
