import java.util.ArrayList;

public class Map {
    final String NOT_INIT = "NULL";
    private int x;
    private int y; //x & y are coordinates
    private String loc; //location, as in city; what is at the x + y coords

    /* with this there are no negatives... need a solution or no map...
    *
    * {
    * {"0,0", "0,1", "0,3"}, {"1,0", "1,1", "1,2"}, {"2,0"}
    * }
    *
    * */

    ArrayList<ArrayList<String>> map = new ArrayList<>();

    public String getLocationAt(int x, int y) {
        return map.get(x).get(y);
    }

    public void setLocationAt(int x, int y, String loc) {

    }
}
