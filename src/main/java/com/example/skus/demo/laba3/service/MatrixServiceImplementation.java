package com.example.skus.demo.laba3.service;

import org.springframework.stereotype.Component;

@Component
public class MatrixServiceImplementation implements MatrixService {

    @Override
    public int[][] getCofactor(int[][] mat, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
        return temp;
    }

    @Override
    public int determinantOfMatrix(int[][] mat, int n) {
        int result = 0;
        if (n == 1)
            return mat[0][0];
        int[][] temp = new int[n][n];
        int sign = 1;
        for (int f = 0; f < n; f++)
        {
            temp = getCofactor(mat, temp, 0, f, n);
            result += sign * mat[0][f]
                    * determinantOfMatrix(temp, n - 1);
            sign = -sign;
        }
        return result;
    }
}
