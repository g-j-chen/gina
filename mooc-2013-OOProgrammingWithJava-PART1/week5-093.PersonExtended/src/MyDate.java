
public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate(int dd, int mm, int yy) {
        this.day = dd;
        this.month = mm;
        this.year = yy;
    }

    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(MyDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month
                && this.day < compared.day) {
            return true;
        }

        return false;
    }

    /*
     * In assignment 92 method differneceInYears was added to MyDate 
     * Copy the method here since it eases this assignment considerably.
     */
    public int differenceInYears(MyDate comparedDate) {
        int yearDiff = this.year - comparedDate.year;
        boolean fullYear = false;
        if (yearDiff != 0) {    
            if (comparedDate.month < this.month) {
                fullYear = true;
            }
            if (comparedDate.month == this.month) {
                if (comparedDate.day <= this.day) {
                    fullYear = true;
                }
            }
            if (fullYear == false) {
            yearDiff -= 1;
            }
        }
        return yearDiff;
    }

  
}
