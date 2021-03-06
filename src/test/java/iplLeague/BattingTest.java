package iplLeague;

import CSVBuilder.CSVBuilderException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class BattingTest {
    private  String MOSTRUNSFILE = "/home/bridgelabz/Desktop/IPLMatchAnalyser/src/test/resources/IPLMOSTRUNDATACSV.csv";
    private String WRONG_RUN_PATH = "./src/main/resources/IndiaStateCensusData.csv";

    @Test
    public void givenMostRunFile_ShouldReturnCorrectData() throws IOException, IPLException, CSVBuilderException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BATSMANS);
        int totalRecords = ipLleagueAnalysis.loadingData(MOSTRUNSFILE);
        Assert.assertEquals(100,totalRecords);
    }

    @Test
    public void givenMostRunFile_ShouldReturnTopRunAverage() throws IPLException, IOException, CSVBuilderException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BATSMANS);
        ipLleagueAnalysis.loadingData(MOSTRUNSFILE);
        List<Batsmans> sortedCensusData = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.AVG_BATTING);
        Assert.assertEquals(83.2,sortedCensusData.get(0).avg,0);
    }

    @Test
    public void givenIncorrectRunsFile_ShouldThroughException() throws IPLException, IOException, CSVBuilderException {
        try {

            IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BATSMANS);
            int numOfplayers = ipLleagueAnalysis.loadingData(WRONG_RUN_PATH);
            Assert.assertEquals(101,numOfplayers);
        }
        catch (IPLException e)
        { }
    }

    @Test
    public void givenMostRunFile_ShouldReturnTopStriker() throws IPLException, IOException, CSVBuilderException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BATSMANS);
        ipLleagueAnalysis.loadingData(MOSTRUNSFILE);
        List<Batsmans> sortedCensusData = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.STRIKING_RATE);
        Assert.assertEquals(333.33,sortedCensusData.get(0).strikeRate,0);
    }

    @Test
    public void givenMostRunFile_ShouldReturnPlayerWithHighestSixAndFour() throws IPLException, IOException, CSVBuilderException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BATSMANS);
        ipLleagueAnalysis.loadingData(MOSTRUNSFILE);
        List<Batsmans> sortedCensusData = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.SIXES_FOURS);
        Assert.assertEquals("Andre Russell",sortedCensusData.get(0).player);
    }

    @Test
    public void givenMostRunFile_ShoulReturnPlayerWithHighest4and6AndHighestStrikes() throws IPLException, IOException, CSVBuilderException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BATSMANS);
        ipLleagueAnalysis.loadingData(MOSTRUNSFILE);
        List<Batsmans> sortedCensusData = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.SIXES_FOUR_STRIKES);
        Assert.assertEquals("Andre Russell",sortedCensusData.get(0).player);
    }

    @Test
    public void givenMostRunFile_ShouldReturnGreatAvgAndHighStikePlayer() throws IPLException, IOException, CSVBuilderException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BATSMANS);
        ipLleagueAnalysis.loadingData(MOSTRUNSFILE);
        List<Batsmans> sortedcensusData = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.GREATAVG_BESTSTRIKE);
        Assert.assertEquals("MS Dhoni",sortedcensusData.get(0).player);
    }

    @Test
    public void givenMostRunFile_ShouldReturnMaxRunAndBestAvg() throws IPLException, IOException, CSVBuilderException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BATSMANS);
        ipLleagueAnalysis.loadingData(MOSTRUNSFILE);
        List<Batsmans> sortedcensusData = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.MAX_RUN_BEST_AVG);
        Assert.assertEquals("David Warner",sortedcensusData.get(0).player);
    }

}
