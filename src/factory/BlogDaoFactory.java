package factory;

import dao.*;
import daoImpl.BlogDaoImpl;

public class BlogDaoFactory {

		public static BlogDao getBlogDaoInstance(){	
			return new BlogDaoImpl();						
		}
}
