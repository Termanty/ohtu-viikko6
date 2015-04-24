
package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    
    private List<Matcher> matchers = new ArrayList<Matcher>();
    
    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder not(Matcher matcher) {
        matchers.add(new Not(matcher));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... ms) {
        matchers.add(new Or(ms));
        return this;
    }
    
    public Matcher build() {
        Matcher m = new And(matchers.toArray(new Matcher[matchers.size()]));
        matchers.clear();
        return m;
    }
}
