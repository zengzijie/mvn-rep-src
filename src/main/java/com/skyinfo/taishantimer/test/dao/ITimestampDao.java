package com.skyinfo.taishantimer.test.dao;

import com.skyinfo.taishantimer.test.entity.DataTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITimestampDao extends JpaRepository<DataTimestamp,String> {
    @Query(value = "select *From (select t.timestamp from T_TIMER_TIMESTAMP t where t.type = ?1 order by t.timestamp desc ) where rownum = 1",nativeQuery = true)
    String getMaxTimestamp(String type);
}
