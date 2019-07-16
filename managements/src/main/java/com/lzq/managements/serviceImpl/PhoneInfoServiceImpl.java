package com.lzq.managements.serviceImpl;

import com.lzq.managements.dao.PhoneInfoDao;
import com.lzq.managements.entity.PhoneInfo;
import com.lzq.managements.service.PhoneInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *      ┌─┐       ┌─┐
 *   ┌──┘ ┴───────┘ ┴──┐
 *   │                 │
 *   │       ───       │
 *   │  ─┬┘       └┬─  │
 *   │                 │
 *   │       ─┴─       │
 *   │                 │
 *   └───┐         ┌───┘
 *       │         │
 *       │         │
 *       │         │
 *       │         └──────────────┐
 *       │                        │
 *       │                        ├─┐
 *       │                        ┌─┘
 *       │                        │
 *       └─┐  ┐  ┌───────┬──┐  ┌──┘
 *         │ ─┤ ─┤       │ ─┤ ─┤
 *         └──┴──┘       └──┴──┘
 *                神兽保佑
 *               代码无BUG!
 *
 *@program: managements
 *@description:
 *@author: lzq
 *@create: 2019-06-03 10:44
 */
@Service
public class PhoneInfoServiceImpl implements PhoneInfoService {
    @Autowired
    private PhoneInfoDao phoneInfoDao;

    @Override
    public int insertPhoneInfo(PhoneInfo record) {
        return phoneInfoDao.insertPhoneInfo(record);
    }

    @Override
    public int updatePhoneInfo(PhoneInfo record) {
        return phoneInfoDao.updatePhoneInfo(record);
    }

    @Override
    public int updatePhone(PhoneInfo phone) {
        return phoneInfoDao.updatePhone(phone);
    }

    @Override
    public List<PhoneInfo> checkPhoneInfo(String phoneNo, String empNo,String qqAccount, String FirstTime, String LastTime,String HZstate, String YXstate,String state, Integer offset, Integer limit) {
        return phoneInfoDao.checkPhoneInfo(phoneNo,empNo,qqAccount,FirstTime,LastTime,HZstate,YXstate,state,offset,limit);
    }

    @Override
    public int getCount(String phoneNo, String empNo,String qqAccount, String FirstTime, String LastTime,String HZstate, String YXstate,String state) {
        return phoneInfoDao.getCount(phoneNo,empNo,qqAccount,FirstTime,LastTime,HZstate,YXstate,state);
    }

    @Override
    public List<PhoneInfo> getPhoneInfo(String phoneNo) {
        return phoneInfoDao.getPhoneInfo(phoneNo);
    }
}
