package dh.tfi.integrador.util;

import java.sql.Timestamp;
import java.util.Date;

public class Time {
    public static Timestamp dateToTimestamp(Date date){
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;

    }

}
