package com.lzq.managements.dao.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.PriceCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */
@Repository
public interface PriceCategoryDao {

    /**
     * 查询
     * */
    List<PriceCategory> listPriceCategory(@Param("pageNo") Integer pageNo,
                                          @Param("pageSize") Integer pageSize);

    /**
     * 新增
     * */
    int insertPriceCategory(PriceCategory priceCategory);

    /**
     * 删除
     * */
    int deletePriceCategory(List<String> list);
}
