/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraudulentactivitynotifications;

/**
 *
 * @author ginaj
 */
public class FraudulentActivityNotifications {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        int count[] = new int[201];

        for(int i = 0; i < d; i++) {
            count[expenditure[i]]++;
        }

        for(int i = d; i < expenditure.length; i++) {
            int median = getDoubleMedian(expenditure, count, d);
            if(expenditure[i] >= median) {
                notifications++;
            }
            count[expenditure[i]]++;
            count[expenditure[i - d]]--;
        }
        return notifications;
    }

    static int getDoubleMedian(int[] expenditure, int[] count, int d) {
        int[] countFreq = count.clone();

        for(int i = 1; i < countFreq.length; i++) {
            countFreq[i] += countFreq[i - 1];
        }

        int a = 0;
        int b = 0;

        if(d % 2 == 0) {
            int first = d / 2;
            int second = first + 1;
            int i = 0;

            for(i = 0; i < 201; i++) {
                if(first <= countFreq[i]) {
                    a = i;
                    break;
                }
            }
            for(;i < 201; i++) {
                if(second <= countFreq[i]) {
                    b = i;
                    break;
                }
            }
        } else {
            int first = d / 2 + 1;
            for(int i = 0; i < 201; i++) {
                if(first <= countFreq[i]) {
                    a = 2 * i;
                    break;
                }
            }
        }
        return a + b;
    }
    
}
