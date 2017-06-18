package dao;

import java.util.List;

import model.Reply;
import util.Page;

public interface ReplyDao {
	
	public void addReplay(Reply replay);			//添加回复
	public List<Reply> findReplayByBlogID(int blogId,Page page);//按文章ID查找回复
	public int findCountByBlogID(int blogId);//查询消息回复记录数
}
