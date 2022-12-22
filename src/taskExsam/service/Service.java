package taskExsam.service;

import java.util.List;

public interface Service <T>{
    String add(List<T>t);
    T getById(long id);
    String removeByName(String name);
    List<T> getAll();
    List<T> sortByName();
    List<T> filterByGender();
    List<T> clear();

}
