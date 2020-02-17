#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

int inversions(int[], int);

int main(int argc, char **argv) {
    int n = 0;
    int next;
    int A[MAX_SIZE];
    printf("Enter up to 1000 numbers:\n");
    while (scanf("%d", &next) == 1) {
        A[n] = next;
        n++;
    }
    printf("Number of inversions present is %d", inversions(A, n));
    return 0;
}

int inversions(int A[], int n) {
    int inversions = 0;
    int prev = A[0];
    for (int i = 1; i < n; i++) {
        if (A[i] < prev) {
            int temp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] < A[j]) {
                    temp++;
                } else {
                    break;
                }
            }
            inversions += temp;
        }
        prev = A[i];
    }
    return inversions;
}
