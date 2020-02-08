package iplLeague;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class IPLleagueAnalysis {
//    private final MockingFactory mockfactory;
     public MockingFactory mockingFactory = new MockingFactory();
    private Cricket cricket;

    public IPLleagueAnalysis(Cricket cricket, MockingFactory mockingFactory) {
        this.cricket=cricket;
        this.mockingFactory = mockingFactory;
    }

    public IPLleagueAnalysis(Cricket cricket) {
        this.cricket=cricket;
    }
    public enum Cricket {BATSMANS, BOWLERS, BatsmanBowlersCombo}

    Map<String,IPLLeagueDAO> list = new TreeMap<>();
    HashMap <Sorting.sortingFields, Comparator> ComparatorMap = new HashMap<>();


    public int loadingData(String... csvFilePath) throws IPLException, IOException {
        list = mockingFactory.getData(cricket, csvFilePath);
        return list.size();
    }

    public ArrayList getSortedFields(Sorting.sortingFields sortfields) {
        Comparator<IPLLeagueDAO> comparator = new Sorting().getField(sortfields);
        ArrayList iplList = (ArrayList) list.values().stream().sorted(comparator)
                .map(cricketDAO -> cricketDAO.getCricketDTO(cricket))
                .collect(Collectors.toList());
        return iplList;

    }
}


