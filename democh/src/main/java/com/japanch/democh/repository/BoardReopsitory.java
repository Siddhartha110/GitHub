package com.japanch.democh.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.japanch.democh.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardReopsitory {

    public final SqlSessionTemplate sql;
    
    public void save(BoardDTO boardDTO) {
        sql.insert("board.save", boardDTO);
    }

}
