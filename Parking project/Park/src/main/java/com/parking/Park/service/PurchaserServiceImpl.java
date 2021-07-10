package com.parking.Park.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.parking.Park.entities.Purchaser;
import com.parking.Park.exception.PackageNotFoundException;
import com.parking.Park.exception.PurchaserNotFoundException;
import com.parking.Park.repository.IBookingParkRepository;
import com.parking.Park.repository.IPackageParkRepository;
import com.parking.Park.repository.IPurchaserRepository;
@Service
public class PurchaserServiceImpl implements IPurchaserService {
	
	Logger log = LoggerFactory.getLogger(PurchaserServiceImpl.class);
	@Autowired
	IPurchaserRepository purchRepository;
	@Autowired
	IBookingParkRepository bookingRepository;
	@Autowired
	IPackageParkRepository packageRepository;

	@Override
	public Purchaser addPurchaser(Purchaser purchaser) {
		if ((purchaser.getPassword() != null)) {
			String securedPasswordHash = BCrypt.hashpw(purchaser.getPassword(), BCrypt.gensalt(12));
			purchaser.setPassword(securedPasswordHash);
		}
		purchaser.setUserType("3");
		purchRepository.save(purchaser);

	
	return purchaser;
	}

	@Override
	public Purchaser updatePurchaser(Purchaser purchaser) throws PurchaserNotFoundException {
		try {

			Optional<Purchaser> opt =purchRepository.findById(purchaser.getUserId());
			if (opt.isPresent()) {
				purchRepository.save(purchaser);
				return opt.get();
			} else {
				throw new PurchaserNotFoundException("Purchaser id not found for update.");
			}

		} catch (Exception e) {

			throw new PurchaserNotFoundException("Purchaser id not found for update.");
		}
	}

	@Override
	public Purchaser deletePurchaser(Purchaser purchaser) throws PurchaserNotFoundException {
		try {
			Optional<Purchaser> opt =  purchRepository.findById(purchaser.getUserId());
	if (opt.isPresent()) {
		purchRepository.delete(purchaser);
		return opt.get();
	} else {
		throw new PurchaserNotFoundException("Purchaser id not found for delete.");
	}
		} catch (Exception e) {

				throw new PurchaserNotFoundException("Purchaser id not found for delete.");
		}
	}

	@Override
	public Purchaser viewPurchaser(int purchaserid) throws PurchaserNotFoundException {
		Purchaser cust = null;
		try {
			Optional<Purchaser> opt = purchRepository.findById(purchaserid);
			if (opt.isPresent()) {
				cust = opt.get();
			} else {
				throw new PurchaserNotFoundException("Purchaser id not found in view cutomer by id");
			}
		} catch (Exception e) {

			throw new PurchaserNotFoundException("Purchaser id not found in view cutomer by id");
		}
		return cust;
	}

	@Override
	public List<Purchaser> viewAllPurchasers(int packageId) throws PackageNotFoundException {
		List<Purchaser> custList = null;

		try {

			custList = purchRepository.findByPackageId(packageId);
			if (custList.isEmpty()) {
				throw new PackageNotFoundException("Package not found");
			}

		} catch (Exception e) {

			throw new PackageNotFoundException("Package not found");
		}
		return custList;
	}

}
