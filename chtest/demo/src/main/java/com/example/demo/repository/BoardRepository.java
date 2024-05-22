package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;

    public void save(BoardDTO boardDTO){
        sql.insert("com.example.demo.mapper.BoardMapper.save", boardDTO);
    }

    public List<BoardDTO> findAll() {

        return sql.selectList("com.example.demo.mapper.BoardMapper.findAll");
    }




}
