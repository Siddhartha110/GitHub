package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.BoardFileDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;

    public BoardDTO save(BoardDTO boardDTO){
        sql.insert("BoardMapper.save", boardDTO);
        //입력한 값이 반환됨.
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");

        System.out.println("repository " + boardDTO.getId());
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");
        
        return boardDTO;
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

    public void saveFile(BoardFileDTO boardFileDTO) {
        sql.insert("BoardMapper.saveFile", boardFileDTO);
    }

    public List<BoardFileDTO> findFile(Long id) {
        return sql.selectList("BoardMapper.findFile", id);
    }




}
