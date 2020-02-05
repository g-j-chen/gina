#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *ifp, *ofp;
    ifp = fopen("challengesample.txt", "r");
    ofp = fopen("challengeoutput.txt", "w");
    char temp = '-';
    char ch;
    int comment = 0;
    while (fscanf(ifp, "%c", &ch) != EOF) {
        if (!comment) {
            if (temp == '/') {
                if (ch == '*') {
                    comment = 1;
                    temp = '-';
                } else if (ch == '/') {
                    fprintf(ofp, "%c", temp);
                } else {
                    fprintf(ofp, "%c%c", temp, ch);
                    temp = '-';
                }
            } else {
                if (ch == '/') {
                    temp = '/';
                } else {
                    fprintf(ofp, "%c", ch);
                }
            }
        } else {
            if (temp == '*') {
                if (ch == '/') {
                    comment = 0;
                    temp = '-';
                }
            } else {
                if (ch == '*') {
                    temp = '*';
                }
            }
        }
    }
    fclose(ifp);
    fclose(ofp);
    return 0;
}
