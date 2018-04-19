package com.jcohy.recruit.respository;

import com.jcohy.recruit.model.DeliveryRecord;
import com.jcohy.recruit.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRecordRepository extends JpaRepository<DeliveryRecord,Integer> {

    DeliveryRecord findDeliveryRecordByNum(Integer num);

}
