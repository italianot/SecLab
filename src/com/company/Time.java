package com.company;

public class Time {

    public enum Measure{

        h,
        day,
        week,
        month
    };
    private double value;
    private Measure type;
    public Time(double value, Measure type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        String typeAsString = "";
        switch (this.type) {
            case h:
                typeAsString  = "ч.";
                break;
            case day:
                typeAsString  = "д.";
                break;
            case week:
                typeAsString  = "нед.";
                break;
            case month:
                typeAsString  = "мес.";
                break;
        }
        return String.format("%s %s", this.value, typeAsString);
    }

    public Time add(double number) {
        Time newTime = new Time(this.value + number, this.type);
        return newTime;
    }

    public Time subtract(double number) {
        return new Time(this.value - number, this.type);
    }

    public Time multiply(double number) {
        return new Time(this.value * number, this.type);
    }

    public Time divide(double number) {
        return new Time(this.value / number, this.type);
    }

    public boolean compare(Time otherTime) {

        otherTime = otherTime.to(this.type);

        return otherTime.value > this.value;
    }

    public String convertInDate(Time otherTime) {

        otherTime = otherTime.to(Measure.day);

        int month;
        int number;
        String date = "";


        month = (int) (otherTime.value / 30);
        month = month % 12;
        number = (int) (otherTime.value % 30);

        switch (month){

            case 0:
                date = number + 1 + " января";
                break;
            case 1:
                date = number + 1 + " февраля";
                break;
            case 2:
                date = number + 1 + " марта";
                break;
            case 3:
                date = number + 1 + " апреля";
                break;
            case 4:
                date = number + 1 + " мая";
                break;
            case 5:
                date = number + 1 + " июня";
                break;
            case 6:
                date = number + 1 + " июля";
                break;
            case 7:
                date = number + 1 + " августа";
                break;
            case 8:
                date = number + 1 + " сентября";
                break;
            case 9:
                date = number + 1 + " октября";
                break;
            case 10:
                date = number + 1 + " ноября";
                break;
            case 11:
                date = number + 1 + " декабря";
                break;
        }

        return date;
    }

    public Time to(Measure newType) {
        // по умолчанию новое значение совпадает со старым
        double newValue = this.value;
        // если текущий тип -- час
        if (this.type == Measure.h) {
            // в зависимости от того во что преобразовываем
            switch (newType) {
                case h: // если часы
                    newValue = this.value;
                    break;
                case day: // если дни
                    newValue = this.value / 24;
                    break;
                case week: // если недели
                    newValue = this.value / 168;
                    break;
                case month: // если месяцы
                    newValue = this.value / 720;
                    break;
            }
        }
        else if (newType == Measure.h) {
            // в зависимости от того во что преобразовываем
            switch (this.type) {
                case h:
                    newValue = this.value;
                    break;
                case day: // если дни
                    newValue = this.value * 24;
                    break;
                case week: // если недели
                    newValue = this.value * 168;
                    break;
                case month: // если месяцы
                    newValue = this.value * 720;
                    break;
            }
        }else {
            newValue = this.to(Measure.h).to(newType).value;
        }
        return new Time(newValue, newType);
    }

    public Time add(Time otherTime) {
        Time otherTimeConverted = otherTime.to(this.type);
        return this.add(otherTimeConverted.value);
    }

    public Time subtract(Time otherTime) {
        Time otherTimeConverted = otherTime.to(this.type);
        return this.subtract(otherTimeConverted.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Time)) {
            return false;
        }
        Time objTime = (Time) obj;

        return objTime.to(this.type).value == this.value;
    }
}
