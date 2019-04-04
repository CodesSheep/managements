package com.lzq.managements.dao.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.IndustryType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */
@Repository
public interface IndustryTypeDao {

    /**
     * 查询
     * */
    List<IndustryType> listIndustryType(@Param("pageNo") Integer pageNo,
                                        @Param("pageSize") Integer pageSize);

    /**
     * 新增
     * */
    int insertIndustryType(IndustryType industryType);

    /**
     * 删除
     * */
    int deleteIndustryType(List<String> list);
}
