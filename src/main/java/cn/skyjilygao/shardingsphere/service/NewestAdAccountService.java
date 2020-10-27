package cn.skyjilygao.shardingsphere.service;

import cn.skyjilygao.shardingsphere.entity.NewestAdAccount;

import java.util.Date;
import java.util.List;

public interface NewestAdAccountService extends BaseService<NewestAdAccount> {
    List<NewestAdAccount> selectByGmtModified(Date d1, Date d2);
}