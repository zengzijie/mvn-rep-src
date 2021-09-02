package com.skyinfo.taishantimer.test.dao;

import com.skyinfo.taishantimer.test.entity.UserEnter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserEnterDao  extends JpaRepository<UserEnter,String> {
}
