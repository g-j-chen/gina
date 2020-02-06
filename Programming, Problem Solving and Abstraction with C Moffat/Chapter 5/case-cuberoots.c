#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define CUBE_LOWER 1e-6
#define CUBE_UPPER 1e6
#define INTERATIONS 25

double cuberoot(double);

int main() {
    double next;
    while (scanf("%lf", &next) == 1) {
        double x = cuberoot(next);
        double check = x * x * x;
        printf("Input: %lf, cube root = %lf, ^3 = %lf\n", next, x, check);
    }
    return 0;
}

double cuberoot(double v) {
    double x = 1.0;
    if (fabs(v) < CUBE_LOWER || fabs(v) > CUBE_UPPER) {
        printf("Cube root may be inaccurate.\n");
    }
    for (int i = 0; i < INTERATIONS; i++) {
        x = (2 * x + v / (x * x)) / 3;
    }
    return x;
}
