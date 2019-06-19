package com.tactfactory.vroom.database.converters;

import android.arch.persistence.room.TypeConverter;

import java.time.LocalDate;

public class DbConverter {

    @TypeConverter
    public static LocalDate fromTimestamp(String value) {
        return value == null ? null : LocalDate.parse(value);
    }

    @TypeConverter
    public static String dateToTimestamp(LocalDate date) {
        return date == null ? null : date.toString();
    }
}
