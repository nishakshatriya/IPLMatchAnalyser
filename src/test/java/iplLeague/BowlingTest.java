package iplLeague;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class BowlingTest {
    private  String MOSTRUNSFILE = "/home/admin1/Desktop/IPLMatchAnalyser/src/test/resources/IPLMOSTRUNDATACSV.csv";
    private String WRONG_RUN_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private String WICKET_FILE_CSV = "/home/admin1/Desktop/IPLMatchAnalyser/src/test/resources/IPLMOSTWKTDATA.csv";
    private String WKT_WRONG_FILE = "./src/main/resources/IndiaStateCensusData.csv";

    @Test
    public void givenWicketFile_ShouldReturnCorrectData() throws IOException, IPLException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BOWLERS);
        int totalRecords = ipLleagueAnalysis.loadingData(WICKET_FILE_CSV);
        Assert.assertEquals(99,totalRecords);
    }


    @Test
    public void givenIncorrectWktRunsFile_ShouldThroughException() throws IPLException, IOException {
        try {

            IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BOWLERS);
            int numOfplayers = ipLleagueAnalysis.loadingData(WKT_WRONG_FILE);
            Assert.assertEquals(99,numOfplayers);
        }
        catch (IPLException e)
        { }
    }

    @Test
    public void givenWktFile_ShouldReturnBowlerAvg() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BOWLERS);
        ipLleagueAnalysis.loadingData(WICKET_FILE_CSV);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.AVG_WKT);
        System.out.println(data);
        Assert.assertEquals("Krishnappa Gowtham",data.get(0).player);
    }

    @Test
    public void givenWktFile_ShouldReturnHighestBowlerStrikeRate() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BOWLERS);
        ipLleagueAnalysis.loadingData(WICKET_FILE_CSV);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.Bowl_SR);
        Assert.assertEquals(120.0,data.get(0).sr,0);

    }

    @Test
    public void givenWktFile_ShouldReturnBestEconomyBowler() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BOWLERS);
        ipLleagueAnalysis.loadingData(WICKET_FILE_CSV);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.BEST_ECO);
        Assert.assertEquals(13.5,data.get(0).Economy,0);
    }

    @Test
    public void givenWktFile_ShouldReturnLeastEconomyBowler() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BOWLERS);
        ipLleagueAnalysis.loadingData(WICKET_FILE_CSV);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.BEST_ECO);
        Assert.assertEquals(4.8,data.get(98).Economy,0);

    }

    @Test
    public void givenWktFile_ShouldReturnHighStrikeAnd5wkt4wkt() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BOWLERS);
        ipLleagueAnalysis.loadingData(WICKET_FILE_CSV);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.STRIKE_5W_4W);
        Assert.assertEquals("Krishnappa Gowtham",data.get(0).player);
    }

    @Test
    public void givenWktFile_ShouldReturnLeastStrikeAnd5wkt4wkt() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BOWLERS);
        ipLleagueAnalysis.loadingData(WICKET_FILE_CSV);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.STRIKE_5W_4W);
        Assert.assertEquals("Kagiso Rabada",data.get(98).player);
    }

    @Test
    public void givenWktFile_ShouldReturnBestBowlingAverageAndStrikeRate() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BOWLERS);
        ipLleagueAnalysis.loadingData(WICKET_FILE_CSV);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.BOWL_AVG_STRIKE_RATE);
        Assert.assertEquals("Krishnappa Gowtham",data.get(0).player);
    }

    @Test
    public void givenWktFile_ShouldReturnMaxWktAndBestBowlAvg() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BOWLERS);
        ipLleagueAnalysis.loadingData(WICKET_FILE_CSV);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.MAX_WKT_BEST_BOWLAVG);
        System.out.println(data);
        Assert.assertEquals("Imran Tahir",data.get(0).player);
    }

    @Test
    public void givenWktFile_ShouldReturnMinWKtAndLeastBowlAvg() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BOWLERS);
        ipLleagueAnalysis.loadingData(WICKET_FILE_CSV,MOSTRUNSFILE);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.MAX_WKT_BEST_BOWLAVG);
        Assert.assertEquals("Yusuf Pathan",data.get(98).player);
    }

    @Test
    public void givenBowlBatFile_ShouldReturnBestBatAndBowlPlayer() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BatsmanBowlersCombo);
        ipLleagueAnalysis.loadingData(MOSTRUNSFILE,WICKET_FILE_CSV);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.BESTBOWL_BAT_AVG);
       Assert.assertEquals("MS Dhoni",data.get(0).player);
    }

    @Test
    public void givenBowlBatFile_ShouldReturnLeastBatAndBowlAvgPlayer() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BatsmanBowlersCombo);
        ipLleagueAnalysis.loadingData(MOSTRUNSFILE,WICKET_FILE_CSV);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.BESTBOWL_BAT_AVG);
        Assert.assertEquals("Harpreet Brar",data.get(99).player);
    }

    @Test
    public void whenGivenTopOfBothRunsAndWickets_shouldReturnAllRounderCricketer() throws IPLException, IOException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis( IPLleagueAnalysis.Cricket.BatsmanBowlersCombo);
        ipLleagueAnalysis.loadingData(MOSTRUNSFILE,WICKET_FILE_CSV);
        List<Bowlers> data = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.ALLROUNDER);
        for(int i=0;i< data.size(); i++){
            System.out.println(" "+data.get(i).player+ " "+ data.get(i).runs);
        }
        Assert.assertEquals("Andre Russell",data.get(0).player);
        Assert.assertEquals("Yuvraj Singh",data.get(99).player);
    }
}

