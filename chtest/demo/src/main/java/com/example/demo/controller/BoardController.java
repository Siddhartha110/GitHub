package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.BoardFileDTO;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;



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
        return "redirect:/list";
    }
    
    @GetMapping("/list")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        System.out.println(boardDTOList.toString());
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        // 조회수 처리
        boardService.updateHits(id);
        // 상세내용 가져오기
        BoardDTO result = boardService.findById(id);
        System.out.println(result.toString());
        model.addAttribute("board", result);
        if (result.getFileAttached() == 1) {
            List<BoardFileDTO> boardFileDTOList = boardService.findFile(id);
            model.addAttribute("boardFileList", boardFileDTOList);
        }
        return "detail";
    }
    
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {

        BoardDTO result = boardService.findById(id);
        model.addAttribute("board", result);

        return "update";
    }

    @PostMapping("/update/{id}")    
    public String update(BoardDTO boardDTO, Model model) {
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);

        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        boardService.delete(id);

        return "redirect:/list";
    }
        


    
    

}
