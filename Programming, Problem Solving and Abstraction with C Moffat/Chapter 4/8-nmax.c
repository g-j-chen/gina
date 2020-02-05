#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    printf("Enter max value for n: ");
    scanf("%d", &n);

    int seed = 0;
    int max_cycles = 0;
    for (int i = 1; i <= n; i++) {
        int max = i;
        int curr = i;
        int cycles = 0;
        while (curr > 1) {
            if (curr % 2 == 0) {
                curr /= 2;
            } else {
                curr = curr * 3 + 1;
            }
            if (curr > max) {
                max = curr;
            }
            cycles++;
        }
        if (cycles > max_cycles) {
            max_cycles = cycles;
            seed = i;
        }
    }
    printf("Length of longest cycle is %d\n", max_cycles);
    printf("Seed that started the cycle is %d\n", seed);

    return 0;
}
