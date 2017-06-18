package factory;

import dao.ReplyDao;
import daoImpl.ReplyDaoImpl;

public class ReplyDaoFactory {
	
	public static ReplyDao getReplyDaoInstance(){	//工厂方法，用来返回DAO实现类实例
		return new ReplyDaoImpl();						//返回DAO实现类实例
	}
}
