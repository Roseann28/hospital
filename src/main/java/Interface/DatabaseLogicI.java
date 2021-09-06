package Interface;

import java.util.List;

public interface DatabaseLogicI<T> {
    void add(T t);
    List<T> view();
    int update(T t);
    void delete(int id);
}
