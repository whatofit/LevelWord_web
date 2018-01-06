package com.level.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.level.model.Word;

public interface WordRepository extends JpaRepository<Word, Long> {

    @Query("select u from Word u")
    Page<Word> findList(Pageable pageable);

    Word findById(long id);

    Word findBySpelling(String spelling);

    Long deleteById(Long id);
}