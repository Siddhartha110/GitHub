package com.japanch.democh.controller;

import org.springframework.stereotype.Controller;

import com.japanch.democh.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // final혹은 @Nonnull이 붙은 필드의 생성자를 생성.
public class BoardController {

    private final BoardService boardService;

}
