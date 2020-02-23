#include <stdio.h>
#include <stdlib.h>

#define SIZE 10

typedef float vector[SIZE];
typedef vector sqmatrix[SIZE];

void vector_add(vector A, vector B, vector C, int n) {
    for(int i = 0; i < n; i++) {
        C[i] = A[i] + B[i];
    }
}

void sqmatrix_add2(vector A[], vector B[], vector C[], int n) {
    for(int i = 0; i < n; i++) {
        vector_add(A[i], B[i], C[i], n);
    }
}

int main(int argc, char **argv) {
    vector A, B;
    sqmatrix C;
    int i;

    for(i = 0; i < SIZE; i++) {
        A[i] = 0.5 * i;
        B[i] = 1.0/(i + 1);
    }
    vector_add(A, B, C[0], SIZE);

    for(i = 1; i < SIZE; i++) {
        vector_add(A, C[i - 1], C[i], SIZE);
    }
    printf("First:\n");
    for(i = 0; i < SIZE; i++) {
        for(int j = 0; j < SIZE; j++) {
            printf("%6.2lf ", C[i][j]);
        }
        printf("\n");
    }

    sqmatrix_add2(C, C, C, SIZE);

    printf("After doubling:\n");
    for(i = 0; i < SIZE; i++) {
        for(int j = 0; j < SIZE; j++) {
            printf("%6.2lf ", C[i][j]);
        }
        printf("\n");
    }

    return 0;
}
