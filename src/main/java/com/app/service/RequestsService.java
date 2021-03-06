package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Requests;
import com.app.repository.RequestsRepository;
import com.app.repository.impl.RequestsRepoImpl;

public class RequestsService {

	private RequestsRepository requestsRepo;
	
	public RequestsService() {
		this.requestsRepo = new RequestsRepoImpl();
	}
	
	public List<Requests> viewRequests(int userId) throws BusinessException{
		return this.requestsRepo.viewRequests(userId);
	}
	
	public void insert(Requests request) {
		this.requestsRepo.insert(request);
	}
	
	public List<Requests> viewRequests() throws BusinessException{
		return this.requestsRepo.viewAllRequests();
	}
	
}
