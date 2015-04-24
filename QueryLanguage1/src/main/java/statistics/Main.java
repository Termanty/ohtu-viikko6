package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        QueryBuilder query = new QueryBuilder();

        System.out.println("----------------");
        
        m = query.oneOf(
                query.playsIn("PHI")
                .hasAtLeast(5, "goals")
                .hasFewerThan(20, "assists").build(),
                query.playsIn("EDM")
                .hasAtLeast(50, "points").build()
        ).build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("----------------");
        
        
        
    }
}
