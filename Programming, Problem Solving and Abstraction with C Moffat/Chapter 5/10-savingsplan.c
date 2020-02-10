#include <stdio.h>
#include <stdlib.h>

double savings_plan(double balance, double amount, double ann_rate_debit, double ann_rate_credit, int years) {
    int month;
    double monthly_mult;
    double ann_rate;  /*Not sure how interest rates work...just modified program as vaguely described in the textbook*/
    if (balance < 0) {
        ann_rate = ann_rate_credit;
    } else {
        ann_rate = ann_rate_debit;
    }
    monthly_mult = 1.00 + (ann_rate / 100.00 / 12);
    for (month = 1; month <= 12 * years; month++) {
        balance *= monthly_mult;
        balance += amount;
    }
    return balance;
}

int main() {
    double balance, amount, debit_rate, new_balance;
    double credit_rate = 0.0;
    int years;
    /*
    printf("Enter number of years         : ");
    scanf("%d", &years);
    printf("Enter annual interest rate (%%): ");
    scanf("%lf", &debit_rate);
    printf("Enter monthly amount ($)      : ");
    scanf("%lf", &amount);
    printf("Enter initial balance ($)     : ");
    scanf("%lf", &balance);

    new_balance = savings_plan(balance, amount, debit_rate, credit_rate, years);
    printf("Saving %.2lf plus %.2lf per month for %d years = %.2lf\n\n", balance, amount, years, new_balance);
    */
    printf("Enter number of years         : ");
    scanf("%d", &years);
    printf("Enter annual interest rate (%%): ");
    scanf("%lf", &credit_rate);
    printf("Enter monthly amount ($)      : ");
    scanf("%lf", &amount);
    printf("Enter initial balance ($)     : ");
    scanf("%lf", &balance);

    new_balance = savings_plan(balance, amount, debit_rate, credit_rate, years);
    printf("Paying mortgage of %.2lf with %.2lf per month for %d years yields %.2lf", balance, amount, years, new_balance);
    return 0;
}
