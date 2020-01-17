package iplLeague;

import csvFileBuilder.CSVBuilderException;
import csvFileBuilder.CSVBuilderFactory;
import csvFileBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class IPLleagueAnalysis {

    List<IPLleagueAnalysisCSV> list = new ArrayList<>();

    public int loadIplRunCensusData(String csvFilePath) throws IPLException, IOException, CSVBuilderException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.CreateCSVBuilder();
            List playersList = icsvBuilder.getCSVInList(reader, IPLleagueAnalysisCSV.class);
            playersList.stream().filter(CensusData -> list.add((IPLleagueAnalysisCSV) CensusData)).collect(Collectors.toList());
            return playersList.size();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            throw new IPLException(e.getMessage(), e.type.name());
        }
        return 0;
    }

    public List sortingPlayersDataInReverse() throws IPLException {
        if(list == null || list.size() == 0) {
            throw new IPLException("NO_CENSUS_DATA", IPLException.ExceptionType.NO_DATA_AVAIL);
        }
        List sortedList = list.stream().sorted(Comparator.comparing(IPLleagueAnalysisCSV::getAvg).reversed()).collect(Collectors.toList());
        return sortedList;
    }

    public List sortingPlayersForStriker() throws IPLException {
        if (list == null || list.size() == 0){
            throw new IPLException("NO_CENSUS_DATA", IPLException.ExceptionType.NO_DATA_AVAIL);
        }
        List sortedList = list.stream().sorted(Comparator.comparing(IPLleagueAnalysisCSV::getStrikeRate).reversed()).collect(Collectors.toList());
        return sortedList;
    }
}


