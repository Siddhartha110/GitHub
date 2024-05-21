package com.japanch.democh.service;

import org.springframework.stereotype.Service;

import com.japanch.democh.dto.BoardDTO;
import com.japanch.democh.repository.BoardReopsitory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardReopsitory boardReopsitory;

    public void save(BoardDTO boardDTO) {
        
        boardReopsitory.save(boardDTO);

    }

}
