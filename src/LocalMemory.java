import java.util.HashMap;


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
