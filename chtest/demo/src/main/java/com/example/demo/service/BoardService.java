package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.BoardFileDTO;
import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO){

        if (boardDTO.getBoardFile().get(0).isEmpty()) {
            
            boardDTO.setFileAttached(0);
            boardRepository.save(boardDTO);
        }else{
            boardDTO.setFileAttached(1);
            BoardDTO saveBoard = boardRepository.save(boardDTO);
            for(MultipartFile boardFile: boardDTO.getBoardFile()){
            
            String originalFilename = boardFile.getOriginalFilename();
            System.out.println(originalFilename);

            System.out.println(System.currentTimeMillis());
            String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
            System.out.println(storedFileName);

            BoardFileDTO boardFileDTO = new BoardFileDTO();
            boardFileDTO.setOriginalFileName(originalFilename);
            boardFileDTO.setStoredFileName(storedFileName);
            boardFileDTO.setBoardId(saveBoard.getId());
            System.out.println("-----------------------------------------------------------");
            System.out.println("-----------------------------------------------------------");

            System.out.println(saveBoard.getId());
            System.out.println("-----------------------------------------------------------");
            System.out.println("-----------------------------------------------------------");
            
            String savePath = "C:/Users/3031003/Desktop/img/" + storedFileName;
            try {
            boardFile.transferTo(new File(savePath));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            boardRepository.saveFile(boardFileDTO);
        }
        }
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        BoardDTO result = boardRepository.findById(id);

        return result;
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public List<BoardFileDTO> findFile(Long id) {
        return boardRepository.findFile(id);
    }
}
