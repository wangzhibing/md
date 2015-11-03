package com.md.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.md.entity.MessageBoard;

@Repository
public interface MessageBoardMapper {
	
	/**
	 * 新增留言信息
	 * @param messageBoard
	 */
	public int insertMessageBoard(MessageBoard messageBoard);
	
	/**
	 * 删除留言板信息
	 * @param id
	 * @return
	 */
	public int deleteMessageBoard(Long id);
	
	/**
	 * 修改留言信息，主要修改状态(把这留言板设置无效--删除)
	 * @param messageBoard
	 */
	public int updateMessageBoard(MessageBoard messageBoard);
	
	/**
	 * 查询单个留言信息(根据主键查询)
	 * @param id
	 * @return
	 */
	public MessageBoard selectMessageBoardByPk(Long id);
	
	/**
	 * 查询留言信息(分页)
	 * @param mapParams
	 * @return
	 */
	public List<MessageBoard> selectMessageBoardData(Map<String, Object> mapParams);
	
	/**
	 * 查询留言信息(分页)
	 * @param mapParams
	 * @return
	 */
	public Integer selectMessageBoardCount(Map<String, Object> mapParams);
}
