package com.lzq.managements.dao;

import com.lzq.managements.entity.Feedback;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDao {
    int insertFeedback(Feedback feedback);
    int updateFeedback(Feedback feedback);
    List<Feedback> getAllFeedbackByUserNo(@Param("userNo") String userNo);
    Feedback selectFeedbackBycreateTime(@Param("userNo") String userNo);
}
