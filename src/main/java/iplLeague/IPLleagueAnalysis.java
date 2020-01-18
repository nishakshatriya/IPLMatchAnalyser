package iplLeague;

import csvFileBuilder.CSVBuilderException;
import csvFileBuilder.CSVBuilderFactory;
import csvFileBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class IPLleagueAnalysis {

    List<BatsmansAnalyse> list = new ArrayList<>();

    public List loadIplRunCensusData(String csvFilePath) throws IPLException, IOException, CSVBuilderException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.CreateCSVBuilder();
            List playersList = icsvBuilder.getCSVInList(reader, BatsmansAnalyse.class);
            playersList.stream().filter(CensusData -> list.add((BatsmansAnalyse) CensusData)).collect(Collectors.toList());
            return playersList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            throw new IPLException(e.getMessage(), e.type.name());
        }
        return null;
    }

    public List sortingPlayersDataInReverse() throws IPLException {
        if(list == null || list.size() == 0) {
            throw new IPLException("NO_CENSUS_DATA", IPLException.ExceptionType.NO_DATA_AVAIL);
        }
        List sortedList = list.stream().sorted(Comparator.comparing(BatsmansAnalyse::getAvg).reversed()).collect(Collectors.toList());
        return sortedList;
    }

    public List sortingPlayersForStriker() throws IPLException {
        if (list == null || list.size() == 0){
            throw new IPLException("NO_CENSUS_DATA", IPLException.ExceptionType.NO_DATA_AVAIL);
        }
        List sortedList = list.stream().sorted(Comparator.comparing(BatsmansAnalyse::getStrikeRate).reversed()).collect(Collectors.toList());
        return sortedList;
    }

    public List sortingPlayersSixsAndFour() throws IPLException {
        if (list == null || list.size() == 0){
            throw new IPLException("NO_CENSUS_DATA", IPLException.ExceptionType.NO_DATA_AVAIL);
        }
        List sortedList = list.stream().collect(Collectors.toList());
        Comparator<BatsmansAnalyse> codeCsvComparator = (player1, player2) -> new Integer((player1.fours*4 + player1.sixer*6) > (player2.fours*4 + player2.sixer*6) ? -1 : 1);
        Collections.sort(sortedList,codeCsvComparator);
        return sortedList;
    }

    public List sortingPlayersByStrikeRates() throws IPLException {
        if (list == null || list.size() == 0){
            throw new IPLException("NO_CENSUS_DATA", IPLException.ExceptionType.NO_DATA_AVAIL);
        }
        List sortedList = list.stream().collect(Collectors.toList());
        Comparator<BatsmansAnalyse> codeCsvComparator = (player1, player2) -> new Integer((player1.fours*4 + player1.sixer*6) > (player2.fours*4 + player2.sixer*6) ? -1 : 1);
        codeCsvComparator = codeCsvComparator.thenComparing(BatsmansAnalyse::getStrikeRate);
        Collections.sort(sortedList,codeCsvComparator);
        return sortedList;


    }
}


