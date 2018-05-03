/**
 * Created by RenatoGamboa on 5/2/18.
 */

import java.io.IOException;

// LINK FOR JSOUP LIBRARY: https://jsoup.org/download

//JSOUP LIBRARY
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {

    public static void main(String[] args) {


        // Get path to webpage document and user agent
        try {

            // Enter Webpage link here
            Document doc = Jsoup.connect("http://www.metacritic.com/browse/games/score/metascore/year/all/filtered").userAgent("Mozilla/17.0").get();

            // Paste Div element containing web content
            Elements temp = doc.select("div.product_item.product_title");

            // Increment variable for game ranks
            int i = 0;

            // Enhanced For Loop to parse through game titles
            for (Element gameList: temp)
            {
                i++;

                // Print out games in order from the anchor tag contained within the desired DIV
                System.out.println(i + ": " + gameList.getElementsByTag("a").first().text());

            }
        } catch (IOException e){

            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
