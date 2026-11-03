
package com.cp.service.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cp.customexceptions.FoodOrderManagementServiceException;
import com.cp.dto.PartnerCuisineRequestDto;
import com.cp.dto.PartnerMenuRequestDto;
import com.cp.dto.PartnerOutletRequestDto;
import com.cp.dto.ResponseBean;
import com.cp.entity.CuisineCategory;
import com.cp.entity.CuisineDetails;
import com.cp.entity.FoodOutletDetails;
import com.cp.entity.MenuDetails;
import com.cp.helper.FOMConstants;
import com.cp.helper.FomUtil;
import com.cp.repository.CuisineCategoryRepository;
import com.cp.repository.CuisineDetailsRepository;
import com.cp.repository.OutletDetailsRepository;
import com.cp.service.OutletManagementService;

@Service
@Transactional
public class OutletManagementServiceImp implements OutletManagementService {

	@Autowired
	private OutletDetailsRepository outletDetailsRepository;

	@Autowired
	private CuisineCategoryRepository cuisineCategoryRepository;

	@Autowired
	private CuisineDetailsRepository cuisineDetailsRepository;

	@Autowired
	private FomUtil fomUtil;

	//Food Outlet Registration

	@Override
	public ResponseBean registerOutlet(
			PartnerOutletRequestDto partnerOutletRequestDto) {

		ResponseBean responseBean = new ResponseBean();

		try {

			// Check whether restaurant already exists
			FoodOutletDetails existingOutlet =
					outletDetailsRepository.findByOutletNameAndOutletCode(
							partnerOutletRequestDto.getOutletName(),
							partnerOutletRequestDto.getOutletCode());

			if (existingOutlet != null) {
				throw new FoodOrderManagementServiceException(
						"409", "Restaurant already exists");
			}

			FoodOutletDetails outletDetails = new FoodOutletDetails();

			outletDetails.setOutletName(
					partnerOutletRequestDto.getOutletName());

			outletDetails.setOutletCode(
					partnerOutletRequestDto.getOutletCode());

			outletDetails.setOutletDescription(
					partnerOutletRequestDto.getOutletDescription());

			LocalTime openTime = fomUtil.convertStringtoLocalTime(
					partnerOutletRequestDto.getOutletOpenTime());

			outletDetails.setOpenTime(openTime);

			LocalTime closeTime = fomUtil.convertStringtoLocalTime(
					partnerOutletRequestDto.getOutletCloseTime());

			outletDetails.setCloseTime(closeTime);

			outletDetails.setBranchName(
					partnerOutletRequestDto.getBranch());

			outletDetails.setIsActive(FOMConstants.IS_ACTIVE);

			outletDetails.setMenuDetails(
					getMenuDetailsFromPartnerRequestDto(
							partnerOutletRequestDto));

			outletDetailsRepository.save(outletDetails);

		} catch (FoodOrderManagementServiceException e) {

			throw e;

		} catch (Exception e) {

			e.printStackTrace();

			throw new FoodOrderManagementServiceException(
					"500",
					"Technical Error Occured while registering a restaurant");
		}

		JSONObject jsonObject = new JSONObject();

		jsonObject.put(
				"message",
				"Successfully registered restaurant details");

		responseBean.setStatus("Success");
		responseBean.setPayload(jsonObject.toMap());

		return responseBean;
	}

	//Prepare Menu Details

	private MenuDetails getMenuDetailsFromPartnerRequestDto(
			PartnerOutletRequestDto partnerOutletRequestDto) {

		MenuDetails menuDetails = new MenuDetails();

		PartnerMenuRequestDto partnerMenuRequestDto =
				partnerOutletRequestDto.getPartnerMenuRequestDto();

		menuDetails.setMenuDescription(
				partnerMenuRequestDto.getMenuDescription());

		menuDetails.setMenuName(
				partnerMenuRequestDto.getMenuName());

		menuDetails.setCuisineDetails(
				getCuisineDetailsFromPartnerRequestDto(
						partnerOutletRequestDto, menuDetails));

		menuDetails.setIsActive(FOMConstants.IS_ACTIVE);

		return menuDetails;
	}

	//Prepare Menu Details

	private List<CuisineDetails> getCuisineDetailsFromPartnerRequestDto(
			PartnerOutletRequestDto partnerOutletRequestDto,
			MenuDetails menuDetails) {

		List<PartnerCuisineRequestDto> partnerCuisineRequestDtosList =
				partnerOutletRequestDto.getPartnerCuisineRequestDtos();

		List<CuisineDetails> cuisineDetailsList = new ArrayList<>();

		Map<String, CuisineCategory> categoryMap = new HashMap<>();

		if (partnerCuisineRequestDtosList == null) {
			return cuisineDetailsList;
		}

		for (PartnerCuisineRequestDto cuisine :
				partnerCuisineRequestDtosList) {

			CuisineDetails cuisineDetails =
					prepareCuisineDetails(cuisine, menuDetails, categoryMap);

			if (cuisineDetails != null) {
				cuisineDetailsList.add(cuisineDetails);
			}
		}

		return cuisineDetailsList;
	}

	// Prepare Cuisine Details

	private CuisineDetails prepareCuisineDetails(
			PartnerCuisineRequestDto cuisine,
			MenuDetails menuDetails,
			Map<String, CuisineCategory> categoryMap) {

		if (cuisine == null) {
			return null;
		}

		CuisineDetails cuisineDetails = new CuisineDetails();

		cuisineDetails.setCuisineName(cuisine.getCuisineName());

		cuisineDetails.setCusineDescription(
				cuisine.getCuisineDescription());

		cuisineDetails.setMenuDetails(menuDetails);

		cuisineDetails.setIsActive(FOMConstants.IS_ACTIVE);

		String inputCategoryCode = cuisine.getCuisineCategoryCode();

		CuisineCategory cuisineCategory =
				categoryMap.get(inputCategoryCode);

		if (cuisineCategory == null) {

			// Check whether category already exists in database
			cuisineCategory =
					cuisineCategoryRepository
							.findByCuisineCateCodeAndIsActive(
									inputCategoryCode,
									FOMConstants.IS_ACTIVE);

			// Create category only when it does not exist
			if (cuisineCategory == null) {

				cuisineCategory = new CuisineCategory();

				cuisineCategory.setCuisineCateCode(inputCategoryCode);

				cuisineCategory.setCategoryDescription(
						cuisine.getCuisineCatDescription());

				cuisineCategory.setIsActive(FOMConstants.IS_ACTIVE);

				cuisineCategory =
						cuisineCategoryRepository.save(cuisineCategory);
			}

			// Store category in map for reuse
			categoryMap.put(inputCategoryCode, cuisineCategory);
		}

		cuisineDetails.setCuisineCategory(cuisineCategory);

		return cuisineDetails;
	}

	// Update Outlet

	@Override
	public ResponseBean updateOutlet(
			PartnerOutletRequestDto partnerOutletRequestDto) {

		ResponseBean responseBean = new ResponseBean();

		try {

			FoodOutletDetails existingOutletDetails =
					outletDetailsRepository
							.findByOutletNameAndBranchNameAndIsActive(
									partnerOutletRequestDto.getOutletName(),
									partnerOutletRequestDto.getBranch(),
									FOMConstants.IS_ACTIVE);

			if (existingOutletDetails == null) {

				throw new FoodOrderManagementServiceException(
						"404", "Outlet not found or is inactive");
			}

			MenuDetails existingMenuDetails =
					existingOutletDetails.getMenuDetails();

			if (existingMenuDetails == null) {

				throw new FoodOrderManagementServiceException(
						"404", "Menu details not found");
			}

			// Update menu details

			PartnerMenuRequestDto partnerMenuRequestDto =
					partnerOutletRequestDto.getPartnerMenuRequestDto();

			existingMenuDetails.setMenuName(
					partnerMenuRequestDto.getMenuName());

			existingMenuDetails.setMenuDescription(
					partnerMenuRequestDto.getMenuDescription());

			// Update outlet description

			existingOutletDetails.setOutletDescription(
					partnerOutletRequestDto.getOutletDescription());

			// Update matching cuisines only

			List<CuisineDetails> existingCuisineDetails =
					existingMenuDetails.getCuisineDetails();

			List<PartnerCuisineRequestDto> partnerCuisineRequestDtos =
					partnerOutletRequestDto.getPartnerCuisineRequestDtos();

			if (existingCuisineDetails != null
					&& partnerCuisineRequestDtos != null) {

				for (CuisineDetails existingCuisine :
						existingCuisineDetails) {

					for (PartnerCuisineRequestDto partnerCuisine :
							partnerCuisineRequestDtos) {

						if (partnerCuisine != null
								&& existingCuisine.getCuisineName()
								.equalsIgnoreCase(
										partnerCuisine.getCuisineName())) {

							updateCuisineDetails(
									existingCuisine, partnerCuisine);

							break;
						}
					}
				}
			}

			// No need to call save() explicitly here.
			// The entities are managed within the transaction.
			// Hibernate dirty checking persists the changes.

		} catch (FoodOrderManagementServiceException e) {

			throw e;

		} catch (Exception e) {

			e.printStackTrace();

			throw new FoodOrderManagementServiceException(
					"500",
					"Technical Error Occured while updating Restaurant");
		}

		JSONObject jsonObject = new JSONObject();

		jsonObject.put(
				"message",
				"Successfully updated outlet details");

		responseBean.setPayload(jsonObject.toMap());
		responseBean.setStatus("Success");

		return responseBean;
	}

	// UPDATE INDIVIDUAL CUISINE

	private CuisineDetails updateCuisineDetails(
			CuisineDetails cuisine,
			PartnerCuisineRequestDto partnerCuisineRequestDto) {

		cuisine.setCuisineName(
				partnerCuisineRequestDto.getCuisineName());

		cuisine.setCusineDescription(
				partnerCuisineRequestDto.getCuisineDescription());

		String status = partnerCuisineRequestDto.getStatus();

		if ("ACTIVE".equalsIgnoreCase(status)
				|| "In-Stock".equalsIgnoreCase(status)) {

			cuisine.setIsActive(FOMConstants.IS_ACTIVE);

		} else {

			cuisine.setIsActive(FOMConstants.IN_ACTIVE);
		}

		return cuisine;
	}
}
