package com.jcohy.recruit.respository;

import com.jcohy.recruit.model.DeliveryRecord;
import com.jcohy.recruit.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryRecordRepository extends JpaRepository<DeliveryRecord,Integer> {

    DeliveryRecord findDeliveryRecordByNum(Integer num);


    List<DeliveryRecord> findDeliveryListRecordByNum(Integer num);

    List<DeliveryRecord> findAllByStatusGreaterThanEqual(Integer status);

    @Query("select d from DeliveryRecord d where d.status between ?1 and ?2 ")
    List<DeliveryRecord> findAllByStatusBetween(Integer min, Integer max);
}
