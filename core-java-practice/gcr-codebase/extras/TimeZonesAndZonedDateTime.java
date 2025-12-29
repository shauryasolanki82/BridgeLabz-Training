import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZonesAndZonedDateTime {
  public static void main(String[] args) {
    ZonedDateTime now = ZonedDateTime.now();
    //time right now
    System.out.println("Time right now: "+now+"\n");
    //time in GMT time zone
    System.out.println("GMT(Greenwich Mean Time): "+now.withZoneSameInstant(ZoneId.of("UTC"))+"\n");
    //time in IST time zone 
    System.out.println("IST (Indian Standard Time): "+now.withZoneSameInstant(ZoneId.of("Asia/Kolkata"))+"\n");
    //time in PST time zone
    System.out.println("PST (Pacific Standard Time):" +now.withZoneSameInstant(ZoneId.of("America/Los_Angeles")));

  }
}
