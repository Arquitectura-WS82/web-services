package com.fastporte.fastportewebservice.util;

import java.time.LocalTime;

public class General {

    //Convertir string como 12:00:00 a LocalTime
    public static LocalTime convertStringToLocalTime(String time) {
        String[] timeArray = time.split(":");
        return LocalTime.of(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]), Integer.parseInt(timeArray[2]));
    }

}
