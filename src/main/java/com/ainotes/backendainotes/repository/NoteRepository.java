package com.ainotes.backendainotes.repository;

import com.ainotes.backendainotes.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
