import java.util.HashMap;

/**
 * Created by ivan on 3/21/2017.
 */
public class LocalMemory {

    private HashMap<String, Integer> localHash = new HashMap<>();


    public int load(String x)
    {
        return localHash.get(x);
    }

    public void store(String x, int v)
    {
        localHash.put(x,v);
    }

}
