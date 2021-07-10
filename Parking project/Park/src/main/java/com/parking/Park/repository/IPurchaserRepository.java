package com.parking.Park.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parking.Park.entities.Purchaser;

@Repository
public interface IPurchaserRepository extends JpaRepository<Purchaser, Integer> {

	@Query("select c from Purchaser c where c.userId =(Select b.userId from BookingPark b where b.pack.packId=:packId)")
	List<Purchaser> findByPackageId(@Param("packId") Integer packId);
}
