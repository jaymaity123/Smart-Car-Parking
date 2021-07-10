package com.parking.Park.service;

import java.util.List;

import com.parking.Park.entities.PackagePark;
import com.parking.Park.exception.PackageNotFoundException;
public interface IPackageParkService {
	
	public  PackagePark  addPackage(PackagePark pack) throws PackageNotFoundException;
	public  PackagePark  updatePackage(PackagePark pack) throws PackageNotFoundException;
	public  PackagePark  deletePackage(int packageId) throws PackageNotFoundException;
	public  List<PackagePark>  searchPackagebyLocation(String location) throws PackageNotFoundException;
	public  PackagePark  searchPackagebyBuilding(String building) throws PackageNotFoundException;
	public  List<PackagePark> viewAllPackages();

}
