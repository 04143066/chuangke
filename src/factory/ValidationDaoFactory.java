package factory;

import dao.ValidationDao;
import daoImpl.ValidationDaoImpl;

public class ValidationDaoFactory {
	
	public static ValidationDao getValidationDaoInstance(){	
		return new ValidationDaoImpl();						
	}
}
