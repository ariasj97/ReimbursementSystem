package com.app.repository;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Requests;

public interface RequestsRepository {

	List<Requests> viewRequests(int userId) throws BusinessException;
	void insert(Requests request);
}
