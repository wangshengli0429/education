package com.education.framework.service.note;

import java.util.Map;

import com.education.framework.common.base.ApiResult;
import com.education.framework.model.note.Note;

public interface NoteService {
	ApiResult findAllNote(Map<String, Object> map);
	 
	ApiResult deleteNoteById(String id);
	ApiResult insertNote(Note note);
	ApiResult queryNoteById(Map<String, Object> map);
}
