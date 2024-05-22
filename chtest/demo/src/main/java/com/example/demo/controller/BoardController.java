package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")
    public String save() {
        return "save";
    }
    
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        
        System.out.println(boardDTO.toString());
        boardService.save(boardDTO);
        return "index";
    }
    

}
