public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
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
    
    public int differenceInYears(MyDate comparedDate) {
        if (this.earlier(comparedDate)) {
            return differenceWhenCurrentIsEarlier(comparedDate);
        }
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
    
    public int differenceWhenCurrentIsEarlier(MyDate comparedDate) {
        int yearDiff = comparedDate.year - this.year;
        boolean fullYear = false;
        if (yearDiff != 0) {
            if (this.month < comparedDate.month) {
                fullYear = true;
            }
            if (this.month == comparedDate.month) {
                if (this.day <= comparedDate.day) {
                    fullYear = true;
                }
            }
            if (fullYear == false){
            yearDiff -= 1;
            }
        }
        return yearDiff;
    }

}
