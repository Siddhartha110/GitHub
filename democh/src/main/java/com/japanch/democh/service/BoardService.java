package com.japanch.democh.service;

import org.springframework.stereotype.Service;

import com.japanch.democh.repository.BoardReopsitory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardReopsitory boardReopsitory;

}
