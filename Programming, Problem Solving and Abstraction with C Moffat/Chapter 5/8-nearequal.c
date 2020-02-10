#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define CUBE_LOWER 1e-6
#define CUBE_UPPER 1e6
#define CUBE_ITERATIONS 25

int near_equal(double, double);
double cube_root(double);

int main() {
    double v;
    printf("Enter a double: ");
    scanf("%lf", &v);
    printf("The square root of v is %lf\n", cube_root(v));
    return 0;
}

double cube_root(double v) {
    int negative = 0;
    if (v < 0) {
        negative = 1;
    }
    double next = 1.0;
    double next_cubed = next * next * next;
    if (fabs(v) < CUBE_LOWER || fabs(v) > CUBE_UPPER) {
        printf("Warning: cube root may be inaccurate\n");
    }
    int i = 1;
    if (negative) {
        v *= -1;
    }
    while (!near_equal(v, next_cubed)) {
        next = (2 * next + v / next / next) / 3;
        next_cubed = next * next * next;
        printf("iteration %d: next cubed = %lf\n", i, next_cubed);
        i++;
    }
    if (negative) {
        return next * -1;
    }
    return next;
}

int near_equal(double a, double b) {
    double temp;
    if (a < b) {
        double temp = a;
        a = b;
        b = temp;
    }
    double diff = a - b;
    if (diff != 0) {
        if (diff / a > 0.0001) {
            return 0;
        }
    }
    return 1;
}
