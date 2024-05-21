package com.japanch.democh.controller;

import org.springframework.stereotype.Controller;

import com.japanch.democh.dto.BoardDTO;
import com.japanch.democh.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequiredArgsConstructor // final혹은 @Nonnull이 붙은 필드의 생성자를 생성.
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")
    public String save() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        //TODO: process POST request
        System.out.println(boardDTO);
        boardService.save(boardDTO);
        return "index";
    }
    
    

}
