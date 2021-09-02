package com.skyinfo.taishantimer.test.dao;

import com.skyinfo.taishantimer.test.entity.Nucleic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author ZZI
 */
public interface INucleicDao extends JpaRepository<Nucleic,String> {
}
