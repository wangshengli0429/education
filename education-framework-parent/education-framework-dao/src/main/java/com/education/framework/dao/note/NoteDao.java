package com.education.framework.dao.note;

import java.util.List;
import java.util.Map;

import com.education.framework.model.note.Note;
/**
 * 
 * <p>NoteDao.java</p>
 * <p>留言</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月11日 下午2:37:21
 * <p>修改者姓名 修改内容说明</p>
 */
public interface NoteDao {
	List<Note> findAllNote(Map<String, Object> map);
	int findNoteCount(Map<String, Object> map);
	 
	int deleteNoteById(String id);
	int insertNote(Note note);
	Note queryNoteById(Map<String, Object> map);
}
