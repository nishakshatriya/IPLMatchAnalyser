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

    List<Batsmans> list = new ArrayList<>();

    public List<Batsmans> loadIplRunCensusData(String csvFilePath) throws IPLException, IOException, CSVBuilderException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.CreateCSVBuilder();
            List playersList = icsvBuilder.getCSVInList(reader, Batsmans.class);
            playersList.stream().filter(CensusData -> list.add((Batsmans) CensusData)).collect(Collectors.toList());
            return playersList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            throw new IPLException(e.getMessage(), e.type.name());
        }
        return null;
    }

    public List<Batsmans> sortingPlayersDataInReverse() throws IPLException {
        if(list == null || list.size() == 0) {
            throw new IPLException("NO_CENSUS_DATA", IPLException.ExceptionType.NO_DATA_AVAIL);
        }
        List sortedList = list.stream().sorted(Comparator.comparing(Batsmans::getAvg).reversed()).collect(Collectors.toList());
        return sortedList;
    }

    public List<Batsmans> sortingPlayersForStriker() throws IPLException {
        if (list == null || list.size() == 0){
            throw new IPLException("NO_CENSUS_DATA", IPLException.ExceptionType.NO_DATA_AVAIL);
        }
        List sortedList = list.stream().sorted(Comparator.comparing(Batsmans::getStrikeRate).reversed()).collect(Collectors.toList());
        return sortedList;
    }

    public List<Batsmans> sortingPlayersSixsAndFour() throws IPLException {
        if (list == null || list.size() == 0){
            throw new IPLException("NO_CENSUS_DATA", IPLException.ExceptionType.NO_DATA_AVAIL);
        }
        List sortedList = list.stream().collect(Collectors.toList());
        Comparator<Batsmans> codeCsvComparator = (player1, player2) -> new Integer((player1.fours*4 + player1.sixer*6) > (player2.fours*4 + player2.sixer*6) ? -1 : 1);
        Collections.sort(sortedList,codeCsvComparator);
        return sortedList;
    }

    public List<Batsmans> sortingPlayersByStrikeRates() throws IPLException {
        if (list == null || list.size() == 0){
            throw new IPLException("NO_CENSUS_DATA", IPLException.ExceptionType.NO_DATA_AVAIL);
        }
        List sortedList = list.stream().collect(Collectors.toList());
        Comparator<Batsmans> codeCsvComparator = (player1, player2) -> new Integer((player1.fours*4 + player1.sixer*6) > (player2.fours*4 + player2.sixer*6) ? -1 : 1);
        codeCsvComparator = codeCsvComparator.thenComparing(Batsmans::getStrikeRate);
        Collections.sort(sortedList,codeCsvComparator);
        return sortedList;
    }
}


