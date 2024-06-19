package com.fastporte.fastportewebservice.repository;

import com.fastporte.fastportewebservice.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDriverRepository extends JpaRepository<Driver, Long> {

    Driver findByEmailAndPassword(String email, String password);

    @Query("SELECT AVG(c.star) FROM Comment c WHERE c.driver.id = :driverId")
    Float findRatingByDriverId(@Param("driverId") Long driverId);
}
