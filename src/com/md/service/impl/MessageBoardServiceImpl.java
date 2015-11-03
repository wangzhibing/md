package com.md.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.md.entity.MessageBoard;
import com.md.mapper.MessageBoardMapper;
import com.md.service.MessageBoardService;

/**
 * 留言板业务层
 * @author wzb
 */
@Service
public class MessageBoardServiceImpl implements MessageBoardService {
	
	Logger logger = Logger.getLogger(MessageBoardServiceImpl.class);
	
	@Resource
	private MessageBoardMapper messageBoardMapper;

	/**
	 * 新增留言板信息
	 */
	@Override
	public int addMessageBoard(MessageBoard messageBoard) {
		return messageBoardMapper.insertMessageBoard(messageBoard);
	}
	
	/**
	 * 删除留言信息
	 */
	@Override
	public int delMessageBoard(Long id){
		return messageBoardMapper.deleteMessageBoard(id);
	}

	/**
	 * 修改留言板信息
	 */
	@Override
	public int editMessageBoard(MessageBoard messageBoard) {
		return messageBoardMapper.updateMessageBoard(messageBoard);
	}

	/**
	 * 查询留言板信息(单个)
	 */
	@Override
	public MessageBoard queryMessageBoardByPk(Long id) {
		return messageBoardMapper.selectMessageBoardByPk(id);
	}

	/**
	 * 查询留言板信息，分页
	 */
	@Override
	public List<MessageBoard> queryMessageBoardData(
			Map<String, Object> mapParams) {
		return messageBoardMapper.selectMessageBoardData(mapParams);
	}

	/**
	 * 查询留言板信息，分页
	 */
	@Override
	public Integer queryMessageBoardCount(Map<String, Object> mapParams) {
		return messageBoardMapper.selectMessageBoardCount(mapParams);
	}
}
