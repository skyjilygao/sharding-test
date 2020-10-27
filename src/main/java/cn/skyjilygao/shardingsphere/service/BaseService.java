package cn.skyjilygao.shardingsphere.service;

import com.github.pagehelper.PageInfo;
import java.util.List;

public interface BaseService<T> {
    boolean addOrUpdate(T entity);

    boolean delete(Long id);

    T get(Long id);

    List<T> list(T query);

    List<T> list(int pageNum, int pageSize, String sidx, String sord, T query);

    PageInfo listOfPaging(int pageNum, int pageSize, String sidx, String sord, T query);
}