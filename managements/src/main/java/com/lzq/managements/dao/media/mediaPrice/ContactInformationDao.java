package com.lzq.managements.dao.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.ContactInformation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */
@Repository
public interface ContactInformationDao {

    /**
     * 查询
     * */
    List<ContactInformation> listContactInformation(@Param("pageNo") Integer pageNo,
                                                    @Param("pageSize") Integer pageSize);

    /**
     * 新增
     * */
    int insertContactInformation(ContactInformation contactInformation);

    /**
     * 删除
     * */
    int deleteContactInformation(List<String> list);
}
