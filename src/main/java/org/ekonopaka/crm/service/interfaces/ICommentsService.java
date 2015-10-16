package org.ekonopaka.crm.service.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.Comment;
import org.ekonopaka.crm.model.Deal;

public interface ICommentsService {

	public void add(Comment comment);
	public Comment get(int id);
	public List<Comment> getDealComments(Deal deal);
	public void remove(Comment comment);
	public Comment create();
	
}
