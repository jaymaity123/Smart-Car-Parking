package com.parking.Park.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.parking.Park.entities.PackagePark;
import org.springframework.stereotype.Repository;

@Repository
public interface IPackageParkRepository extends JpaRepository<PackagePark, Integer> {

	@Query("select p from PackagePark p where p.location=:location")
	List<PackagePark> findBylocation(@Param("location") String location);
	@Query("select p from PackagePark p where p.building=:building")
	Optional<PackagePark> findBybuilding(@Param("building") String building);
}
