package jp.jc21.t.yoshizawa.WEB01;



import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;



public class Sentiment {



   public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        Sentiment1 message = getLanguage("子どもたちがいなかったので、 鳥たちは歌いたいと思いませんでしたし、 木々は花を咲かせるのを忘れておりました。");
        if (message != null) {
            System.out.println("Positive : "+message.documents[0].confidenceScores.positive);
            System.out.println("Neutral : " + message.documents[0].confidenceScores.neutral);
            System.out.println("Negative : "+message.documents[0].confidenceScores.negative);
        }
    }



   static Sentiment1 getLanguage(String s) throws IOException, URISyntaxException, InterruptedException {
        Gson gson = new Gson();



       String url = "https://r04jk3b06-text.cognitiveservices.azure.com//" + "text/analytics/v3.0/sentiment";
        Map<String, String> map = new HashMap<>();
        map.put("Ocp-Apim-Subscription-Key", "4e83bb8e3c08410ea01884dbe88565a5");



       Docs2 doc = new Docs2();
        doc.id = "1";
        doc.text = s;



       Source1 src = new Source1();
        src.documents = new Docs2[1];
        src.documents[0] = doc;



       String jsonData = new Gson().toJson(src);



       //InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);



       JsonReader reader = WebApiConnector.postJsonReader(url,  map, jsonData);
        Sentiment1 message = null;
        if (reader != null) {
            message = gson.fromJson(reader, Sentiment1.class);
            reader.close();
        }
        return message;
        
        
    }



}



class Sentiment1 {
    Documents1[] documents;
    String[] errors;
    String modelVersion;
}



class Documents1 {
    ConfidenceScores confidenceScores;
    
}




class ConfidenceScores {
    double negative;
    double neutral;
    double positive;
}



class Source1 {
    Docs2[] documents;
}



class Docs2 {
    String id;
    String text;
}