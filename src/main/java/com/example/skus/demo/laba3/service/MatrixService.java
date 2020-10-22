package com.example.skus.demo.laba3.service;

import org.springframework.stereotype.Service;

@Service
public interface MatrixService {
    int[][] getCofactor(int[][] mat, int[][] temp, int p, int q, int n);
    int determinantOfMatrix(int[][] mat, int n);
}
