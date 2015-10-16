package org.ekonopaka.crm.service.impl;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.ICommentsDAO;
import org.ekonopaka.crm.model.Comment;
import org.ekonopaka.crm.model.Deal;
import org.ekonopaka.crm.service.interfaces.ICommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentsService implements ICommentsService {

	@Autowired
	ICommentsDAO commentsDAO;
	
	@Override
	@Transactional
	public void add(Comment comment) {
		commentsDAO.add(comment);
	}

	@Override
	@Transactional
	public Comment get(int id) {
		return commentsDAO.get(id);
	}

	@Override
	@Transactional
	public List<Comment> getDealComments(Deal deal) {
		return commentsDAO.getDealComments(deal);
	}

	@Override
	@Transactional
	public void remove(Comment comment) {
		commentsDAO.remove(comment);
	}
	
	@Override
	public Comment create()	{
		return new Comment();
	}

}
