/**
 * The Mydate class.
 * @author graffion
 *
 */

class MyDate {
    int _day;
    int _month;
    int _year;

    /**
     * Constructs a date.
     *
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     */
    public MyDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    /**
     * Determines if a given (day, month, year) represents a valid date.
     *
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     * @return true if (day, month, year) represents a valid date, false else
     */
    public static boolean isValidDate(int day, int month, int year) {
        return checkData(day, month, year);
    }

    /**
     * Determines if a given (day, month, year) represents a valid date.
     *
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     * @return true if (day, month, year) represents a valid date, false else
     */
    public static boolean checkData(int day, int month, int year) {
        return checkDay(day) && checkMonth(month) && checkYear(year)
                && checkDayLimits(day, month, year);
    }

    /**
     * Determines if this object represents a valid date.
     *
     * @return true if this object represents a valid date, false else
     */
    public boolean checkData() {
        return checkData(_day, _month, _year);
    }

    /**
     * Determines if a year is bissextile.
     *
     * Une annÈe bissextile est une annÈe de 366 jours au lieu de 365,
     * c'est-‡-dire une annÈe comprenant un 29 fÈvrier.
     * Depuis l'instauration du calendrier grÈgorien, sont bissextiles, les annÈes:
     * - divisibles par 4 mais non divisibles par 100
     * - ou divisibles par 400
     *
     * @param      year   the year.
     * @return true if year is bissextile, false else
     */
    public static boolean isBissextile(int year) {
        if ( year%400 == 0 )
            return true;
        if ( year%4 == 0 && year%100 != 0)
            return true;
        return false;
    }

    /**
     * Get the last day given a month and a year.
     *
     * @param      month   the month.
     * @param      year   the year.
     * @return the last day of (month, year), (should be 28, 29, 30 or 31)
     */
    public static int maxDayOfMonth(int month, int year) {
        int result = 31;
        if ( month == 2 ) {
            result = ( isBissextile(year) ) ? 29 : 28;
        }
        if ( month == 4 || month == 6 || month == 9 || month == 11 )
            result = 30;
        return result;
    }

    public static int maxDayOfMonth(int month) {
        return maxDayOfMonth(month, 2001);
    }

    /**
     * Updates the day, month and year) attributes of this object
     * to the next day (tomorrow).
     *
     * @return this (my)date
     */
    public MyDate nextDay() {
        if ( _month == 2 &&  _day == 28 ) {
            if ( isBissextile(_year) ) // annÈe bissextile
                _day++;
            else {
                _day = 1;
                _month = 3;
            }
            return this;
        }
        if ( _month == 2 &&  _day == 29 ) {
            _day = 1;
            _month = 3;
            return this;
        }
        if ( maxDayOfMonth(_month)== 31 && _day == 31 ) {
            if ( _month == 12 ) {
                _day = _month = 1;
                _year++;
            }
            else {
                _day = 1; _month++;
            }
            return this;
        }
        if ( maxDayOfMonth(_month)== 30 && _day == 30 ) {
            _day = 1; _month++;
            return this;
        }
        // normal flow
        _day++;
        return this;
    }

    /**
     * Allocates a <code>MyDate</code> object and initializes it to represent
     * the day (tomorrow) which follows the provided day, month and a year.
     *
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     * @return a (my)date object initialized to next day of (day, month, year)
     */
    public static MyDate nextDay(int day, int month, int year) {
        MyDate date = new MyDate(day, month, year);
        return date.nextDay();
    }

    private static boolean checkDayLimits(int day, int month, int year) {
        if ( month == 2 )
            return checkFebruaryDayLimits(day, year);
        return day <= maxDayOfMonth(month);
    }

    private static boolean checkFebruaryDayLimits(int day, int year) {
        if ( isBissextile(year ) )
            return day <= 29;
        else
            return day < 29;
    }

    private static boolean checkDay(int day) {
        return day >= 1 && day < 32;
    }

    private static boolean checkMonth(int month) {
        return month > 0 && month < 13;
    }

    private static boolean checkYear(int year) {
        return year > 0;
    }

    public int getYear() {
        return _year;
    }

    private void setYear(int year) {
        this._year = year;
    }

    public int getDay() {
        return _day;
    }

    private void setDay(int jour) {
        this._day = jour;
    }

    public int getMonth() {
        return _month;
    }

    private void setMonth(int month) {
        this._month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyDate myDate = (MyDate) o;

        if (_day != myDate._day) return false;
        if (_month != myDate._month) return false;
        return _year == myDate._year;

    }

    @Override
    public int hashCode() {
        int result = _day;
        result = 31 * result + _month;
        result = 31 * result + _year;
        return result;
    }
}
