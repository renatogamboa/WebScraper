/**
 * Created by RenatoGamboa on 5/2/18.
 */

import java.io.IOException;

//JSOUP Framework
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {

    public static void main(String[] args) {


        // Get path to webpage document and user agent
        try {
            Document doc = Jsoup.connect("http://www.metacritic.com/browse/games/score/metascore/year/all/filtered").userAgent("Mozilla/17.0").get();
            Elements temp = doc.select("div.product_item.product_title");

            // Increment variable for game ranks
            int i = 0;

            // Enhanced For Loop to parse through game titles
            for (Element gameList: temp)
            {

                i++;
                System.out.println(i + ": " + gameList.getElementsByTag("a").first().text());


            }
        } catch (IOException e){
            System.out.println("ERROR");

            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }





}
