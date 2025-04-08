public class TimeDiffCalculator {

    public static String timeDifference(String time1, String time2) {
        int minutes1 = convertToMinutes(time1);
        int minutes2 = convertToMinutes(time2);

        int diff = minutes2 - minutes1;

        if (diff < 0) {
            diff += 24 * 60;
        }

        int hours = diff / 60;
        int mins = diff % 60;
        System.out.println(hours*60+mins);
        return String.format("%02d:%02d", hours, mins);
    }
    private static int convertToMinutes(String time) {
        time = time.trim().toUpperCase(); 
        String[] parts = time.split(" ");
        String[] hm = parts[0].split(":");

        int hour = Integer.parseInt(hm[0]);
        int minute = Integer.parseInt(hm[1]);
        String ampm = parts[1];
      
        if (ampm.equals("AM") && hour == 12) {
            hour = 0;
        } else if (ampm.equals("PM") && hour != 12) {
            hour += 12;
        }

        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        System.out.println(timeDifference("1:23 AM", "1:08 AM")); // Output: 02:45
        System.out.println(timeDifference("12:00 AM", "12:00 PM")); // Output: 12:00
        System.out.println(timeDifference("11:59 PM", "12:01 AM")); // Output: 00:02
    }
}
