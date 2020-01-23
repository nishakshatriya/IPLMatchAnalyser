package iplLeague;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Sorting {
    public enum sortingFields{
        AVG_BATTING, STRIKING_RATE, SIXES_FOURS, SIXES_FOUR_STRIKES, GREATAVG_BESTSTRIKE, MAX_RUN_BEST_AVG, BEST_RUN, AVG_WKT, BEST_ECO,STRIKE_5W_4W, wkt5_wkt4, BOWL_AVG_STRIKE_RATE, Bowl_SR , MAX_WKT_BEST_BOWLAVG, BOWL_AVG, MAX_WKT,BESTBOWL_BAT_AVG
    }
    static Map<sortingFields, Comparator<IPLLeagueDAO>> comparatorMap = new HashMap<>();

    public Comparator getField(Sorting.sortingFields sortField)
    {
        comparatorMap.put(sortingFields.BEST_RUN,(Player1,Player2) -> (Player2.runs-Player1.runs));
        comparatorMap.put(sortingFields.AVG_BATTING,(Player1,Player2)-> (int) (Player2.avg-Player1.avg));
        comparatorMap.put(sortingFields.STRIKING_RATE,(Player1,Player2)-> (int) (Player2.strikeRate-Player1.strikeRate));
        comparatorMap.put(sortingFields.SIXES_FOURS,(Player1,Player2) -> new Integer((Player1.fours*4 + Player1.sixer*6) > (Player2.fours*4 + Player2.sixer*6) ? -1 : 1));
        comparatorMap.put(sortingFields.SIXES_FOUR_STRIKES, comparatorMap.get(sortingFields.SIXES_FOURS).thenComparing(comparatorMap.get(sortingFields.STRIKING_RATE)));
        comparatorMap.put(sortingFields.GREATAVG_BESTSTRIKE, comparatorMap.get(sortingFields.AVG_BATTING).thenComparing((Player1,Player2) -> Player1.strikeRate - Player2.strikeRate > 0 ? -1 :1));
        comparatorMap.put(sortingFields.MAX_RUN_BEST_AVG, comparatorMap.get(sortingFields.BEST_RUN).thenComparing((Player1, Player2) -> (Player1.avg-Player2.avg) > 0 ? -1 : 1));
        comparatorMap.put(sortingFields.AVG_WKT,(Player1, Player2) -> (int) (Player2.avg-Player1.avg));
        comparatorMap.put(sortingFields.BEST_ECO,(Player1, Player2) -> (Player1.Economy < Player2.Economy ? 1: -1));
        comparatorMap.put(sortingFields.Bowl_SR,(Player1, Player2) -> (Player1.bowlStrikeRate < Player2.bowlStrikeRate ? 1: -1));
        comparatorMap.put(sortingFields.wkt5_wkt4,(Player1, Player2) -> new Integer((Player1.five_wkts + Player1.four_wkts) - (Player2.five_wkts + Player2.four_wkts) ));
        comparatorMap.put(sortingFields.STRIKE_5W_4W, comparatorMap.get(sortingFields.wkt5_wkt4).thenComparing(comparatorMap.get(sortingFields.Bowl_SR)));
        comparatorMap.put(sortingFields.BOWL_AVG,(Player1, Player2) -> (int)(Player2.avg - Player1.avg));
        comparatorMap.put(sortingFields.BOWL_AVG_STRIKE_RATE,comparatorMap.get(sortingFields.BOWL_AVG).thenComparing(comparatorMap.get(sortingFields.Bowl_SR)));
        comparatorMap.put(sortingFields.MAX_WKT,(Player1,Player2) -> (Player2.wickets - Player1.wickets));
        comparatorMap.put(sortingFields.MAX_WKT_BEST_BOWLAVG,comparatorMap.get(sortingFields.MAX_WKT).thenComparing(comparatorMap.get(sortingFields.BOWL_AVG)));
        comparatorMap.put(sortingFields.BESTBOWL_BAT_AVG,comparatorMap.get(sortingFields.AVG_BATTING).thenComparing(comparatorMap.get(sortingFields.BOWL_AVG)));
        Comparator comparator=comparatorMap.get(sortField);
        return comparator;
    }
}
