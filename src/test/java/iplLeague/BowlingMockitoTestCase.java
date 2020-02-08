package iplLeague;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class BowlingMockitoTestCase {
    private String MOSTWKTDATA = "/home/admin1/Desktop/IPLMatchAnalyser/src/test/resources/IPLMOSTWKTDATA.csv";

    Map<String, IPLLeagueDAO> cricketMap = new HashMap<>();

    @Before
    public void givenPlayersData() {
        Bowlers bowlers = new Bowlers("Harbhajan Singh", 312, 16, 19.5, 7.09, 16.5, 0, 0);
        cricketMap.put("bowling", new IPLLeagueDAO(bowlers));
    }
        @Mock
        MockingFactory mockingFactory;

        @Rule
        public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void WhenGivenBowlingDataList_ShouldReturnDataInMockito() throws IOException {
        try {
            IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis(IPLleagueAnalysis.Cricket.BOWLERS, mockingFactory);
            when(mockingFactory.getData(IPLleagueAnalysis.Cricket.BOWLERS, MOSTWKTDATA)).thenReturn(cricketMap);
            int totalRecords = ipLleagueAnalysis.loadingData(MOSTWKTDATA);
            System.out.printf("total record: " + totalRecords);
            Assert.assertEquals(1, totalRecords);
        } catch (IPLException e) {

        }
    }

    @Test
    public void WhenGivenBowlingData_ShouldReturnMockitoObject() throws IOException, IPLException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis(IPLleagueAnalysis.Cricket.BOWLERS, mockingFactory);
        when(mockingFactory.getData(IPLleagueAnalysis.Cricket.BOWLERS, MOSTWKTDATA)).thenReturn(cricketMap);
        ipLleagueAnalysis.loadingData(MOSTWKTDATA);
        List<Bowlers> bowlersList = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.AVG_WKT);
        Assert.assertEquals(312, bowlersList.get(0).runs, 0.0);
    }

    @Test
    public void WhenGivenBowlingData1_ShouldReturnMockitoObject() throws IOException, IPLException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis(IPLleagueAnalysis.Cricket.BOWLERS, mockingFactory);
        when(mockingFactory.getData(IPLleagueAnalysis.Cricket.BOWLERS, MOSTWKTDATA)).thenReturn(cricketMap);
        ipLleagueAnalysis.loadingData(MOSTWKTDATA);
        List<Bowlers> bowlersList = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.AVG_WKT);
        Assert.assertEquals(16, bowlersList.get(0).wickets, 0.0);
    }
}

