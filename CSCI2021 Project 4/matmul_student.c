#include "matrix.h"

void matmul_student(const matrix_t *A, const matrix_t *B, matrix_t *C) {
     long Bn = B->ncols;
     long Am = A->nrows;
     long An = A->ncols;
     long Cn = C->ncols;
     int *Ad = A->data;
     int *Bd = B->data;
     int *Cd = C->data;
     for (int i = 0; i < Am; i++) {
        for (int j = 0; j < An; j++) {
            for (int k = 4; k < Bn; k += 5) {
                int sum = (Cd[(i*(Cn)) + (k - 4)]);
                int sum1 = (Cd[(i*(Cn)) + (k - 3)]);
                int sum2 = (Cd[(i*(Cn)) + (k - 2)]);
                int sum3 = (Cd[(i*(Cn)) + (k - 1)]); 
                int sum4 = (Cd[(i*(Cn)) + (k)]); 
                sum += (Ad[(i*(An)) + (j)]) * (Bd[(j*(Bn)) + (k - 4)]);
                sum1 += (Ad[(i*(An)) + (j)]) * (Bd[(j*(Bn)) + (k - 3)]);
                sum2 += (Ad[(i*(An)) + (j)]) * (Bd[(j*(Bn)) + (k - 2)]);
                sum3 += (Ad[(i*(An)) + (j)]) * (Bd[(j*(Bn)) + (k - 1)]);
                sum4 += (Ad[(i*(An)) + (j)]) * (Bd[(j*(Bn)) + (k)]);
                (Cd[(i*(Cn)) + (k - 4)]) = sum;
                (Cd[(i*(Cn)) + (k - 3)]) = sum1;
                (Cd[(i*(Cn)) + (k - 2)]) = sum2;
                (Cd[(i*(Cn)) + (k - 1)]) = sum3; 
                (Cd[(i*(Cn)) + (k)]) = sum4;
            }
            int r = Bn - (Bn % 5);
            for (int l = r; l < Bn; l++) {
                int sum5 = (Cd[(i*(Cn)) + (l)]);
                sum5 += (Ad[(i*(An)) + (j)]) * (Bd[(j*(Bn)) + (l)]);
                (Cd[(i*(Cn)) + (l)]) = sum5;
            } 
        }
    }
}
