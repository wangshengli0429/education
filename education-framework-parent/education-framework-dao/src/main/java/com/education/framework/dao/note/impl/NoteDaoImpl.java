package com.education.framework.dao.note.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.dao.note.NoteDao;
import com.education.framework.model.note.Note;

@Repository
public class NoteDaoImpl extends SqlSessionDaoSupport implements NoteDao{

	@Override
	public List<Note> findAllNote(Map<String, Object> map) {
		return this.getSqlSession().selectList("note.findAllNote", map);
	}

	@Override
	public int findNoteCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("note.findNoteCount",map);
	}

	@Override
	public int deleteNoteById(String id) {
		return this.getSqlSession().delete("note.deleteNoteById", id);
	}

	@Override
	public int insertNote(Note note) {
		return this.getSqlSession().insert("note.insertNote", note);
	}

	@Override
	public Note queryNoteById(Map<String, Object> map) {
		return this.getSqlSession().selectOne("note.queryNoteById",map);
	}
	
}
