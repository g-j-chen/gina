#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

int kth_element(int[], int, int);

int cmpfunc(const void * a, const void * b) {
    return (*(int*)a - *(int*)b);
}

int main(int argc, char **argv) {
    int i = 0;
    int A[MAX_SIZE];
    int next;
    printf("Enter up to 1000 integers:\n");
    while (scanf("%d", &next) == 1) {
        A[i] = next;
        i++;
    }
    getchar();
    int k;
    printf("Enter value of k: ");
    scanf("\n%d", &k);

    printf("kth smallest value: %d", kth_element(A, i, k - 1));
    return 0;
}

int kth_element(int A[], int n, int k) {
    int B[n];
    for (int i = 0; i < n; i++) {
        B[i] = A[i];
    }
    qsort(B, n, sizeof(int), cmpfunc);
    return B[k];
}
