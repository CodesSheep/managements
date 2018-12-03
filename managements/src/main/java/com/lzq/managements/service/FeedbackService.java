package com.lzq.managements.service;

import com.lzq.managements.entity.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackService {
    int insertFeedback(Feedback feedback);
    int updateFeedback(Feedback feedback);
    List<Feedback> getAllFeedbackByUserNo( String userNo);
    Feedback selectFeedbackBycreateTime(String userNo);

}
