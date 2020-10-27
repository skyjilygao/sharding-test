/**
*
* NewestAdAccountMapper.java
* @author skyjilygao
* @date 20201019
*/
package cn.skyjilygao.shardingsphere.dao;

import cn.skyjilygao.shardingsphere.entity.NewestAdAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface NewestAdAccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NewestAdAccount record);

    int insertSelective(NewestAdAccount record);

    NewestAdAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewestAdAccount record);

    int updateByPrimaryKey(NewestAdAccount record);

    List<NewestAdAccount> selectBySelective(NewestAdAccount record);
    List<NewestAdAccount> selectByGmtModified(@Param("gmtModifiedStart") Date gmtModifiedStart, @Param("gmtModifiedEnd") Date gmtModifiedEnd);
}