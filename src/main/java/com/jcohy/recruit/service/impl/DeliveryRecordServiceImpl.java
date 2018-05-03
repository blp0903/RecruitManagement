package com.jcohy.recruit.service.impl;

import com.jcohy.recruit.exception.ServiceException;
import com.jcohy.recruit.model.DeliveryRecord;
import com.jcohy.recruit.respository.DeliveryRecordRepository;
import com.jcohy.recruit.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {


    @Autowired
    private DeliveryRecordRepository deliveryRecordRepository;

    @Override
    public Page<DeliveryRecord> findAll(Pageable pageable) {
        return deliveryRecordRepository.findAll(pageable);
    }

    @Override
    public List<DeliveryRecord> findAll() {
        return deliveryRecordRepository.findAll();
    }

    @Override
    public List<DeliveryRecord> findListByNum(Integer num) {
        return deliveryRecordRepository.findDeliveryListRecordByNum(num);
    }

    @Override
    public DeliveryRecord findById(Integer id) {
        return deliveryRecordRepository.findById(id).get();
    }

    @Override
    public DeliveryRecord findByNum(Integer num) {
        return deliveryRecordRepository.findDeliveryRecordByNum(num);
    }

    @Override
    public DeliveryRecord saveOrUpdate(DeliveryRecord deliveryRecord) throws ServiceException {
        return deliveryRecordRepository.save(deliveryRecord);
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        deliveryRecordRepository.deleteById(id);
    }
}
