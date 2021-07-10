package com.parking.Park.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.parking.Park.entities.PackagePark;
import com.parking.Park.entities.Purchaser;
import com.parking.Park.exception.PackageNotFoundException;
import com.parking.Park.exception.PurchaserNotFoundException;
import com.parking.Park.repository.IPackageParkRepository;

@Service
public class PackageParkServiceImpl implements IPackageParkService {
	
	Logger log = LoggerFactory.getLogger(PackageParkServiceImpl.class);
	@Autowired
	IPackageParkRepository packageRepository;

	@Override
	@Transactional
	public PackagePark addPackage(PackagePark pack) throws PackageNotFoundException {
		Optional<PackagePark> opt = null;
		try{
			opt = packageRepository.findBybuilding(pack.getBuilding());
			if (opt.isPresent()) {
				throw new PackageNotFoundException("PackageName already exists");
			} else {
				if(pack.getAvailableSlots()==0)
					pack.setStatus(false);
				else
					pack.setStatus(true);
				packageRepository.save(pack);
		}}
		catch (Exception e) {
			log.error("Add package Exception:", e);
		}
		return pack;
	}
	
	

	@Override
	public PackagePark deletePackage(int packageId) throws PackageNotFoundException {
		try {
			Optional<PackagePark> opt =packageRepository.findById(packageId);
			if (opt.isPresent()) {
				packageRepository.deleteById(packageId);
				return opt.get();

			} else {
				throw new PackageNotFoundException("Package not found in delete");
			}

		} catch (Exception e) {
			
			throw new PackageNotFoundException("Package not found in delete");

		}
	}

	@Override
	public List<PackagePark> searchPackagebyLocation(String location) throws PackageNotFoundException {
		List<PackagePark>list=null;
		try {
			list = packageRepository.findBylocation(location);
			if (list.isEmpty()) {
				throw new PackageNotFoundException("Package is not available for this location");
			} 
				return list;
			
		}catch(

	Exception e)
	{   
		throw new PackageNotFoundException("Package Not Found with given loaction");
	}
	}

	@Override
	public PackagePark searchPackagebyBuilding(String building) throws PackageNotFoundException {
		try {
			Optional<PackagePark> opt = packageRepository.findBybuilding(building);
			if (opt.isPresent()) {
				return opt.get();
			} else {
				throw new PackageNotFoundException("Package Not Found in search by building");
			}

		} catch (Exception e) {

			throw new PackageNotFoundException("Package Not Found in search by building");

		}
	}

	@Override
	public List<PackagePark> viewAllPackages() {
		List<PackagePark> list = null;
		try {
			list = packageRepository.findAll();
		} catch (Exception e) {
			log.error("View all Exception:", e);

		}

		return list;
	}



	@Override
	public PackagePark updatePackage(PackagePark pack) throws PackageNotFoundException {
		try {

			Optional<PackagePark> opt =packageRepository.findById(pack.getPackId());
			if (opt.isPresent()) {
				if(pack.getAvailableSlots()==0)
					pack.setStatus(false);
				else
					pack.setStatus(true);
				packageRepository.save(pack);
				return opt.get();
			} else {
				throw new PackageNotFoundException("Package id not found for update.");
			}

		} catch (Exception e) {

			throw new PackageNotFoundException("Package id not found for update.");
		}
	}

}
