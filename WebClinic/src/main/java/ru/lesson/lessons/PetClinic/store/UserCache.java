package ru.lesson.lessons.PetClinic.store;

import ru.lesson.lessons.PetClinic.models.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Andrey on 31.05.2017.
 */
public class UserCache {
    private static final UserCache INSTANCE = new UserCache();

    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    public static UserCache getInstance() {
        return INSTANCE;
    }

    public Collection<User> values() {
        return this.users.values();
    }

    public void add(User us) {
        this.users.put(us.getId(), us);
    }

    public void delete(Integer id) {
        this.users.remove(id);
    }

    public User getUser(Integer id) {
        return this.users.get(id);
    }


    public void edit(User user) {
        this.users.replace(user.getId(), user);
    }
}
