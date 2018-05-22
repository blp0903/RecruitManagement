package com.jcohy.recruit.respository;

import com.jcohy.recruit.model.DeliveryRecord;
import com.jcohy.recruit.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRecordRepository extends JpaRepository<DeliveryRecord,Integer> {

    DeliveryRecord findDeliveryRecordByNum(Integer num);


    List<DeliveryRecord> findDeliveryListRecordByNum(Integer num);

    List<DeliveryRecord> findAllByStatusGreaterThanEqual(Integer status);
}
