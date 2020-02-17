#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define MAX_SIZE 1000

int max_freq(int[], int);

int cmpfunc(const void * a, const void * b) {
    return (*(int*)a - *(int*)b);
}

int main(int argc, char **argv) {
    int n;
    printf("Enter an integer equal to or less than 1000\n");
    scanf("%d", &n);
    int i = 0;
    int A[MAX_SIZE];
    int next;
    printf("Enter up to 1000 integers:\n");
    while (scanf("%d", &next) == 1) {
        A[i] = next;
        i++;
    }
    if (n > i) {
        n = i;
    }
    int answer = max_freq(A, n);
    printf("The number that appears most frequently (and of lowest value) is %d\n", answer);
    return 0;
}

int max_freq(int A[], int n) {
    int B[n];
    for (int i = 0; i < n; i++) {
        B[i] = A[i];
    }
    qsort(B, n, sizeof(int), cmpfunc);
    int max_frequency = 1;
    int max_freq_value = B[0];
    int curr_freq = 1;
    int curr_value = B[0];
    for (int i = 1; i < n; i++) {
        if (B[i] == curr_value) {
            curr_freq++;
        } else {
            if (curr_freq > max_frequency) {
                max_frequency = curr_freq;
                max_freq_value = curr_value;
            }
            curr_value = B[i];
            curr_freq = 1;
        }
    }
    if (curr_freq > max_frequency) {
        max_frequency = curr_freq;
        max_freq_value = curr_value;
    }
    return max_freq_value;
}

