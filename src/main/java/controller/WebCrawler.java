package controller;

import dao.CurreXDao;
import model.Currency;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class WebCrawler {


    public static void zim_rate() throws IOException {
        try{
            Document doc = Jsoup.connect("https://www.rate.co.zw/").get();
            Elements newsHeadlines = doc.select(".container");
            for (Element headline : newsHeadlines) {
                int number_of_rates = headline.select(".row").select("h3.col-sm").size();
                for (int i=0;i<number_of_rates;i++){
                    String string = headline.select(".row").select("h3.col-sm").get(i).text();
                    String[] splitted = string.split(" ");
                    Double a = Double.valueOf(splitted[0]);
                    String b = splitted[1].toLowerCase();
                    Double c = Double.valueOf(splitted[3]);
                    String d = splitted[4].toLowerCase();
                    String rate = b + "_" + d;
                    Double the_rate = c/a;
                    Currency currency = new Currency(rate, the_rate);
                    CurreXDao.insertRecord(currency);
                }
            }
        }
        catch (SocketTimeoutException e){
            System.out.println(e);
        }
    }
}
