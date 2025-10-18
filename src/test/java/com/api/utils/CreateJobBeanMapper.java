package com.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.dataproviders.api.bean.CreateJobBean;

public class CreateJobBeanMapper {
// We will giving the bean and it will create the payload for CreateJobAPI

//Util class

	private CreateJobBeanMapper() {

	}

	public static CreateJobPayload  mapper(CreateJobBean bean) {
		// Bean -----> CreateJobPayLoad Object!
		int mstServiceLocationId = Integer.parseInt(bean.getMst_service_location_id());
		int mstPlatformId = Integer.parseInt(bean.getMst_platform_id());
		int oemId = Integer.parseInt(bean.getMst_oem_id());
		int mstWarrantyStatusId = Integer.parseInt(bean.getMst_warrenty_status_id());
		
		Customer customer = new Customer(bean.getCustomer__first_name(),
				bean.getCustomer__last_name(), 
				bean.getCustomer__mobile_number(), 
				bean.getCustomer__mobile_number_alt(), 
				bean.getCustomer__email_id(), 
				bean.getCustomer__email_id_alt());
		
		CustomerAddress customerAddress = new CustomerAddress(
				bean.getCustomer_address__flat_number(), 
				bean.getCustomer_address__apartment_name(), bean.getCustomer_address__street_name(), 
				
				bean.getCustomer_address__landmark(), bean.getCustomer_address__area(), bean.getCustomer_address__pincode(), 
				bean.getCustomer_address__country(), bean.getCustomer_address__state());

		int productId =Integer.parseInt(bean.getCustomer_product__product_id());
		int modelId =Integer.parseInt(bean.getCustomer_product__mst_model_id());

		
		CustomerProduct customerProduct =new CustomerProduct(bean.getCustomer_product__dop(), 
				bean.getCustomer_product__serial_number(), bean.getCustomer_product__imei1(), bean.getCustomer_product__imei2(), 
				bean.getCustomer_product__popurl(),productId , modelId);
		
		
		List<Problems> problemList = new ArrayList<Problems>();
		int problemId = Integer.parseInt(bean.getProblems__id());
		
		Problems problem = new Problems(problemId, bean.getProblems__remark());
		problemList.add(problem);
		CreateJobPayload payload = new CreateJobPayload(mstServiceLocationId, mstPlatformId, mstWarrantyStatusId,oemId, customer,
				customerAddress, 
				customerProduct, 
				problemList);
		
		return payload;
	}
}
