package Work3.H4;

public class MyDate {
    private int year;
    private int month;
    private int date;

    public MyDate(){
        year=0;
        month=0;
        date=0;
    }
    public MyDate(int y,int m,int d){
        year=y;
        month=m;
        date=d;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
