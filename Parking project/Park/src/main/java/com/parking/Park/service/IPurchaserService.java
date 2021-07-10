package com.parking.Park.service;

import java.util.List;

import com.parking.Park.entities.Purchaser;
import com.parking.Park.exception.PackageNotFoundException;
import com.parking.Park.exception.PurchaserNotFoundException;

public interface IPurchaserService {

	public Purchaser addPurchaser(Purchaser purchaser);
	public Purchaser updatePurchaser(Purchaser purchaser) throws PurchaserNotFoundException;
	public Purchaser deletePurchaser(Purchaser purchaser) throws PurchaserNotFoundException;//admin
	public Purchaser viewPurchaser(int purchaserid) throws PurchaserNotFoundException;
	public List<Purchaser> viewAllPurchasers(int packageId)throws PackageNotFoundException;
}
