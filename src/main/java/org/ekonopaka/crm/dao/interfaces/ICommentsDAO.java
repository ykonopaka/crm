package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.Comment;
import org.ekonopaka.crm.model.Deal;

public interface ICommentsDAO {

	public void add(Comment comment);
	public Comment get(int id);
	public List<Comment> getDealComments(Deal deal);
	public void remove(Comment comment);
	
}
