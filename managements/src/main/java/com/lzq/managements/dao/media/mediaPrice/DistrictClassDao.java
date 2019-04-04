package com.lzq.managements.dao.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.DistrictClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */
@Repository
public interface DistrictClassDao {

    /**
     * 查询
     * */
    List<DistrictClass> listDistrictClass(@Param("pageNo") Integer pageNo,
                                          @Param("pageSize") Integer pageSize);

    /**
     * 新增
     * */
    int insertDistrictClass(DistrictClass districtClass);

    /**
     * 删除
     * */
    int deleteDistrictClass(List<String> list);
}
