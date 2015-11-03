package com.md.service;

import java.util.List;
import java.util.Map;

import com.md.entity.MessageBoard;

/**
 * 留言板业务层
 * @author wzb
 */
public interface MessageBoardService {
	
	/**
	 * 新增留言信息
	 * @param messageBoard
	 */
	public int addMessageBoard(MessageBoard messageBoard);
	
	/**
	 * 删除留言信息
	 * @param id
	 * @return
	 */
	public int delMessageBoard(Long id);
	
	/**
	 * 修改留言信息，主要修改状态(把这留言板设置无效--删除)
	 * @param messageBoard
	 */
	public int editMessageBoard(MessageBoard messageBoard);
	
	/**
	 * 查询单个留言信息(根据主键查询)
	 * @param id
	 * @return
	 */
	public MessageBoard queryMessageBoardByPk(Long id);
	
	/**
	 * 查询留言信息(分页)
	 * @param mapParams
	 * @return
	 */
	public List<MessageBoard> queryMessageBoardData(Map<String, Object> mapParams);
	
	/**
	 * 查询留言信息(分页)
	 * @param mapParams
	 * @return
	 */
	public Integer queryMessageBoardCount(Map<String, Object> mapParams);
}
