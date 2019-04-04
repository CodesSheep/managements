package com.lzq.managements.serviceImpl;

import com.lzq.managements.dao.FeedbackDao;
import com.lzq.managements.entity.Feedback;
import com.lzq.managements.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    public int insertFeedback(Feedback feedback) {
        return feedbackDao.insertFeedback(feedback);
    }

    @Override
    public int updateFeedback(Feedback feedback) {
        return feedbackDao.updateFeedback(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbackByUserNo(String userNo) {
        return feedbackDao.getAllFeedbackByUserNo(userNo);
    }

    @Override
    public Feedback selectFeedbackBycreateTime(String userNo) {
        return feedbackDao.selectFeedbackBycreateTime(userNo);
    }

    @Override
    public String findEmpByEmpNo(String empNo) {
        return feedbackDao.findEmpByEmpNo(empNo);
    }

    @Override
    public int deleteFeedback( String userNo) {
        return feedbackDao.deleteFeedback(userNo);
    }
}
