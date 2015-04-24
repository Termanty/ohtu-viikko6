
package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    
    private static List<Matcher> matchers = new ArrayList<Matcher>();
    
    public static void playsIn(String team) {
        matchers.add(new PlaysIn(team));
    }
    
    public static void hasAtleast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
    }
    
    public static void hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
    }
    
    public static void not(Matcher matcher) {
        matchers.add(new Not(matcher));
    }
    
    public static Matcher build() {
        Matcher m = new And((Matcher[])matchers.toArray());
        matchers.clear();
        return m;
    }
    
    public static Matcher oneOf(Matcher... ms) {
        return new Or(ms);
    }
}
