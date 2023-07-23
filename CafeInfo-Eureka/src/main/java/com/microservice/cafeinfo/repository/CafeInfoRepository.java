package com.microservice.cafeinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.cafeinfo.model.CafeInfo;

@Repository
public interface CafeInfoRepository extends JpaRepository<CafeInfo, Integer> {

}
