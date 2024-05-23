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
        sql.insert("BoardMapper.save", boardDTO);
    }

    public List<BoardDTO> findAll() {

        return sql.selectList("BoardMapper.findAll");
    }

    public void updateHits(Long id) {

        sql.update("BoardMapper.updateHits", id);
    }

    public BoardDTO findById(Long id) {
        BoardDTO result = sql.selectOne("BoardMapper.findById", id);
        return result;
    }

    public void update(BoardDTO boardDTO) {
        sql.update("BoardMapper.update", boardDTO);
    }

    public void delete(Long id) {
        sql.delete("BoardMapper.delete", id);
    }




}
