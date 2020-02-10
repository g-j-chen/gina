#include <stdio.h>
#include <stdlib.h>

int isperfect(int n) {
    int sum = 1;
    int i;
    for (i = 2; i <= (n + 1) / 2; i++) {
        if (n % i == 0) {
            sum += i;
        }
    }
    return sum == n;
}
