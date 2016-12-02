package adityajoshee.grab;

/**
 * Created by aditya on 11/10/16.
 */
class GrabProblem {
    private static int ENTRY_CHARGE = 2;
    private static int FIRST_HR_CHARGE = 3;
    private static int HOURLY_CHARGE = 4;

    public int solution(String E, String L) {
        String[] Esplit = E.split(":");
        String[] Lsplit = L.split(":");

        int eHrs = Integer.parseInt(Esplit[0]);
        int eMins = Integer.parseInt(Esplit[1]);

        int lHrs = Integer.parseInt(Lsplit[0]);
        int lMins = Integer.parseInt(Lsplit[1]);

        int cost = 0; //initalize cost.

        // since E is before L, entry and 1st hr is always charge
        cost += ENTRY_CHARGE + FIRST_HR_CHARGE;

        int hrsDiff = lHrs - eHrs;
        int minDiff = lMins - eMins;

        if (hrsDiff==0){ // left at same time hour
            return cost;
        }

        hrsDiff--; // 1st hr already charged.

        cost += hrsDiff * HOURLY_CHARGE;
        if (minDiff>=0){
            return cost + HOURLY_CHARGE;
        }
        else{
            return cost;
        }
    }
}