/**
 * 
 */
package com.test.timezone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author jsing522
 *
 */
public class TimeZoneConversion {
    
    public enum OffsetBase {
        GMT, UTC
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] timeZones = new String[] {"GMT", "UTC", "IST", "Asia/Singapore"};
        for (String timeZone : timeZones) {
            TimeZone tz = TimeZone.getTimeZone(timeZone);

            long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
            long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset())
                - TimeUnit.HOURS.toMinutes(hours);

            String timeZoneString = String.format("( GMT %d:%02d ) %s(%s)", hours,
                minutes, tz.getDisplayName(), timeZone);
            System.out.println(timeZoneString);
          }
        

    }
    
    public List<String> getTimeZoneList(OffsetBase base) {
        
        LocalDateTime now = LocalDateTime.now();
        return ZoneId.getAvailableZoneIds()
                .stream()
//          .map(ZoneId::of)
//          .sorted(new ZoneComparator())
//          .map(id -> String.format(
//            "(%s%s) %s", 
//            base, getOffset(now, id), id.getId()))
          .collect(Collectors.toList())
          ;
    }

}
