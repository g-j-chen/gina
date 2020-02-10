#include <stdio.h>
#include <stdlib.h>

#define DATE_OK 0
#define DATE_ERROR 1

int shift_to_tomorrow(int*, int*, int*);

int main(int argc, char **argv) {
    int d, m, y;
    printf("Enter date in dd/mm/yyyy format: ");
    scanf("%d/%d/%d", &d, &m, &y);
    int *dp = &d;
    int *mp = &m;
    int *yp = &y;
    if (shift_to_tomorrow(dp, mp, yp) != DATE_OK) {
        printf("Date error, program abort\n");
        exit(EXIT_FAILURE);
    }
    printf("The next date will be: %02d/%02d/%04d\n", *dp, *mp, *yp);

    return 0;
}

int shift_to_tomorrow(int *dd, int *mm, int *yyyy) {
    if (*mm < 1 || *mm > 12 || *dd < 1) {
        return DATE_ERROR;
    }
    if (*dd > 30) {
        if (*mm == 2 || *mm == 4 || *mm == 6 || *mm == 9 || *mm == 11) {
            return DATE_ERROR;
        }
    }
    if (*dd > 31) {
        return DATE_ERROR;
    }
    if (*yyyy % 4 == 0 && (*yyyy % 100 != 0 || *yyyy % 400 == 0)) {
        if (*mm == 2 && *dd > 29) {
            return DATE_ERROR;
        }
    } else {
        if (*mm == 2 && *dd > 28) {
            return DATE_ERROR;
        }
    }

    if (*mm == 2) {
        if (*yyyy % 4 == 0 && (*yyyy % 100 != 0 || *yyyy % 400 == 0)) {
            if (*dd == 29) {
                *dd = 1;
                *mm = 3;
            } else {
                *dd+=1;
            }
        } else {
            if (*dd == 28) {
                *dd = 1;
                *mm = 3;
            } else {
                *dd+=1;
            }
        }
    } else if (*mm == 4 || *mm == 6 || *mm == 9 || *mm == 11) {
        if (*dd == 30) {
            *dd = 1;
            *mm+=1;
        } else {
            *dd+=1;
        }
    } else {
        if (*dd == 31) {
            *dd = 1;
            if (*mm == 12) {
                *mm = 1;
                *yyyy+=1;
            } else {
                *mm+=1;
            }
        } else {
            *dd+=1;
        }
    }
    return DATE_OK;
}
