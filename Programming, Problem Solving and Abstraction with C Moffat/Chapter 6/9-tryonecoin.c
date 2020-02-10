#include <stdio.h>
#include <stdlib.h>

int try_one_coin(int*, int);
void print_change(int);
int round_to_5(int);

int main(int argc, char **argv) {
    int amount;
    printf("Enter amount in cents (up to $10 == 1000c): ");
    scanf("%d", &amount);
    amount = round_to_5(amount);
    printf("Amount after rounding: %d\n", amount);
    print_change(amount);
    return 0;
}

int try_one_coin(int *cents, int coin) {
    int num_coins = 0;
    while(*cents - coin >= 0) {
        *cents -= coin;
        num_coins++;
    }
    return num_coins;
}

void print_change(int cents) {
    printf("The coins required to make %d are:\n", cents);
    int *p_cents = &cents;
    int num_2_dollars = try_one_coin(p_cents, 200);
    if (num_2_dollars > 0) {
        printf("%d x $2 coins\n", num_2_dollars);
    }
    int num_1_dollars = try_one_coin(p_cents, 100);
    if (num_1_dollars > 0) {
        printf("%d x $1 coins\n", num_1_dollars);
    }
    int num_50 = try_one_coin(p_cents, 50);
    if (num_50 > 0) {
        printf("%d x 50c coins\n", num_50);
    }
    int num_20 = try_one_coin(p_cents, 20);
    if (num_20 > 0) {
        printf("%d x 20c coins\n", num_20);
    }
    int num_10 = try_one_coin(p_cents, 10);
    if (num_10 > 0) {
        printf("%d x 10c coins\n", num_10);
    }
    int num_5 = try_one_coin(p_cents, 5);
    if (num_5 > 0) {
        printf("%d x 5c coins\n", num_5);
    }
}

int round_to_5(int cents) {
    int rounding = cents % 5;
    if (rounding <= 2) {
        cents -= rounding;
    } else {
        cents = cents + (5 - rounding);
    }
    return cents;
}
