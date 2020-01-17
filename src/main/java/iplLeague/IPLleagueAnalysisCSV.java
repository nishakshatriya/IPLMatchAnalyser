package iplLeague;
//POS,PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s
import com.opencsv.bean.CsvBindByName;

public class IPLleagueAnalysisCSV {

    @CsvBindByName(column = "POS", required = true)
    public int position;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int match;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "NO", required = true)
    public int notOut;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public String highScore;

    @CsvBindByName(column = "Avg", required = true)
    public double avg;

    @CsvBindByName(column = "BF", required = true)
    public int ballFest;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int century;

    @CsvBindByName(column = "50", required = true)
    public int halfCentury;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int sixer;


    public double getAvg() {
        return avg;
    }

    @Override
    public String toString() {
        return "IPLleagueAnalysisCSV{" +
                "position='" + position + '\'' +
                ", player=" + player +
                ", match=" + match +
                ", innings=" + innings +
                ", notOut='" + notOut + '\'' +
                ", runs=" + runs +
                ", highScore=" + highScore +
                ", avg=" + avg +
                ", ballFest='" + ballFest + '\'' +
                ", strikeRate=" + strikeRate +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", fours=" + fours +
                ", sixer=" + sixer +
                '}';
    }


}
