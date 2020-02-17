#include <stdio.h>
#include <stdlib.h>

void bubbledown(int[], int);
void int_swap(int*, int*);

int main(int argc, char **argv) {
    int A[] = {4, 2, 8, 3, 1};
    int size = 5;
    bubbledown(A, size);
    for (int i = 0; i < size; i++) {
        printf("%d ", A[i]);
    }
    return 0;
}

void bubbledown(int A[], int n) {
    int didswaps = 1;
    int i;
    while(didswaps) {
        didswaps = 0;
        for (i = n - 1; i > 0; i--) {
            if (A[i] > A[i - 1]) {
                int_swap(&A[i], &A[i - 1]);
                didswaps = 1;
            }
        }
    }
}

void int_swap(int *x, int *y) {
    int t = *x;
    *x = *y;
    *y = t;
}
