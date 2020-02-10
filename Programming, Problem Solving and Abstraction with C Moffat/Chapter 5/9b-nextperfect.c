#include <stdio.h>
#include <stdlib.h>

int nextperfect(int n) {
    while (n < 10000) {
        if (isperfect(n)) {
            return n;
        }
        n++;
    }
    printf("Taking too long to compute next perfect number!\n");
    return 0;
}
