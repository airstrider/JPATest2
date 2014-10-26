package com.airstrider.service;

import java.util.Map;

public interface ICommonService {
	void batchSave(Map<String, Object> map);
//	void batchSave(Map<String, ArrayList<Department>> map);
	void batchUpdate(Map<String, Object> map);
	Object findById(Object object);
}
