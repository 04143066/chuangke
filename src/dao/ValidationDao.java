package dao;

import java.util.List;

import model.Validation;
import util.Page;

public interface ValidationDao {

	public void addValidation(Validation validation);            //新建招标
	public void deleteValidation(Validation validation);                       //删除招标
	public void tenderValidation(Validation validation ,int tenderer);          //投标
	public void agreeValidation(Validation validation); 
	public void endValidation(Validation validation);                          //完成标
	public Validation findByVid(int vid);                        //根据标的信息查询标
	public List<Validation> findUntendVaList(Page page);                  //查询没有投标的招标信息
	public int countUntendValidation();
	public List<Validation> findAgreeVaList(int uid);                  //查询已经投标的招标信息
	public List<Validation> findEndedVaList(int uid);                   //查询已经结束的招标信息
	public List<Validation> findUntendVaList(int uid);
	public List<Validation> findtendedVaList(int uid);
}
