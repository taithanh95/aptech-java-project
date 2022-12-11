
package vn.techja.quanlybanhang.dao;

import java.util.List;
import vn.techja.quanlybanhang.utilities.PaginatedResults;


public interface BaseDAO<T> {

    boolean create(T object) throws Exception;

    boolean update(T object) throws Exception;

    boolean deleteById(int id) throws Exception;

    T findById(int id) throws Exception;

    List<T> findAll() throws Exception;

    PaginatedResults<T> select(int page) throws Exception;
}
