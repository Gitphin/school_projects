#include "matrix.h"

void get_every_fifth_student(const matrix_t *matrix, long results[RESULTS_LEN]) {
    // Row / Col len, row #, temp vars to store adding cols
    long m = matrix->nrows; 
    long n = matrix->ncols;
    int i;
    long a0 = 0;
    long a1 = 0;
    long a2 = 0;
    long a3 = 0;
    long a4 = 0;
    for (i = 0; i < m; i++) {
        for (int j = 4; j < n; j += 5) {
            // Instead of accessing from memory each time, put in temp vars
            a0 += MGET(matrix, i, j - 4);
            a1 += MGET(matrix, i, j - 3);
            a2 += MGET(matrix, i, j - 2);
            a3 += MGET(matrix, i, j - 1);
            a4 += MGET(matrix, i, j);
        }
        // Get result index w/ respect to odd case
        int k = n - (n % 5);
        for (int l = k; l < n; l++) {
            results[l - k] += MGET(matrix, i, l);
        }
    }
    // Now put results into memory
    results[0] += a0;
    results[1] += a1;
    results[2] += a2;
    results[3] += a3;
    results[4] += a4;
}

long get_every_student(const matrix_t *matrix) {
     // row + col len, temp vars to store loop unroll adding 
    long m = matrix->nrows;
    long n = matrix->ncols;
    long a0 = 0;
    long a1 = 0;
    long a2 = 0;
    long a3 = 0;
    long a4 = 0;
    long a5 = 0;
    for (int i = 0; i < m; i++) {
        // Unroll & add to temp vars, better because less iterations needed
        for (int j = 4; j < n; j += 5) {
            a0 += MGET(matrix, i, j - 4);
            a1 += MGET(matrix, i, j - 3);
            a2 += MGET(matrix, i, j - 2);
            a3 += MGET(matrix, i, j - 1);
            a4 += MGET(matrix, i, j);
        }
        // Loop unroll clean up the leftovers (same process as get_every_fifth)
        int k = n - (n % 5);
        for (int l = k; l < n; l++) {
            a5 += MGET(matrix, i, l);
        }
    }
    // return all the sums
    return a0 + a1 + a2 + a3 + a4 + a5;
}
