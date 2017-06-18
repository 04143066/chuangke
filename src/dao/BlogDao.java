package dao;

import java.util.List;

import model.Blog;
import util.Page;

public interface BlogDao {

	public void addBlog(Blog blog);		//���������Ϣ�ķ���
	public void updateBlog(Blog blog);	//�����޸���Ϣ�ķ���
	public void deleteBlog(int BlogID);		//����ɾ����Ϣ�ķ���
	public List<Blog> findAllBlog(Page page,int uid);		//���尴��ҳ��Ϣ��ѯ������Ϣ�ķ���
	public Blog findBlogById(int BlogID);	//���尴ID��ѯ��Ϣ�ķ���
	public int findAllCount(int uid);					//�����ѯ��Ϣ��¼��
}
