package cn.skyjilygao.shardingsphere.service.impl;

import cn.skyjilygao.shardingsphere.dao.NewestAdAccountMapper;
import cn.skyjilygao.shardingsphere.entity.NewestAdAccount;
import cn.skyjilygao.shardingsphere.service.NewestAdAccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author skyjilygao
* @sine 2020-10-19T18:03:51.268
* NewestAdAccount service
*/
@Slf4j
@Service
public class NewestAdAccountServiceImpl implements NewestAdAccountService {
    @Autowired
    private NewestAdAccountMapper newestAdAccountMapper;

    @Override
    public List<NewestAdAccount> selectByGmtModified(Date d1, Date d2) {
        return newestAdAccountMapper.selectByGmtModified(d1, d2);
    }

    /**
    * addOrUpdate
    * @param entity 
    * @return
    */
    @Override
    public boolean addOrUpdate(NewestAdAccount entity) {
        int c = 0;
        entity.setGmtModified(new Date());
        if (entity.getId() != null) {
            c = newestAdAccountMapper.updateByPrimaryKeySelective(entity);
        } else {
            entity.setGmtCreate(new Date());
            c = newestAdAccountMapper.insertSelective(entity);
        }
        return c == 1 ? true : false;
    }

    /**
    * delete
    * @param id
    * @return
    */
    @Override
    public boolean delete(Long id) {
        int c = 0;
        c = newestAdAccountMapper.deleteByPrimaryKey(id);
        return c == 1 ? true : false;
    }

    /**
    * get
    * @param id 
    * @return
    */
    @Override
    public NewestAdAccount get(Long id) {
        NewestAdAccount newestAdAccount;
        newestAdAccount = newestAdAccountMapper.selectByPrimaryKey(id);
        return newestAdAccount;
    }

    /**
    * list
    * @param query
    * @return
    */
    @Override
    public List<NewestAdAccount> list(NewestAdAccount query) {
        List<NewestAdAccount> list;
        list = newestAdAccountMapper.selectBySelective(query);
        return list;
    }

    /**
    * list
    * @param pageNum 分页：当前页
    * @param pageSize 分页：每页大小
    * @param sidx 排序字段
    * @param sord desc / asc
    * @param query 查询类
    * @return 查询列表
    */
    @Override
    public List<NewestAdAccount> list(int pageNum, int pageSize, String sidx, String sord, NewestAdAccount query) {
        List<NewestAdAccount> list;
        PageHelper.startPage(pageNum, pageSize, sidx + " " + sord);
        list = newestAdAccountMapper.selectBySelective(query);
        return list;
    }

    /**
    * listOfPaging
    * @param pageNum 分页：当前页
    * @param pageSize 分页：每页大小
    * @param sidx 排序字段
    * @param sord desc / asc
    * @param query 查询类
    * @return 携带分页信息 pageInfo
    */
    @Override
    public PageInfo listOfPaging(int pageNum, int pageSize, String sidx, String sord, NewestAdAccount query) {
        PageHelper.startPage(pageNum, pageSize, sidx + " " + sord);
        List<NewestAdAccount> list = newestAdAccountMapper.selectBySelective(query);
        return PageInfo.of(list);
    }
}