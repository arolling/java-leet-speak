import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class LeetSpeak {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/leet", (request, response) -> {
      HashMap model = new HashMap();

      model.put("template", "templates/leet.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/leettranslate", (request, response) -> {
      HashMap model = new HashMap();
      String inputPhrase = request.queryParams("englishPhrase");
      String leetedPhrase = LeetSpeak.leetSpeakTranslate(inputPhrase);
      model.put("originalPhrase", inputPhrase);
      model.put("leetPhrase", leetedPhrase);
      model.put("template", "templates/leettranslate.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

  public static String leetSpeakTranslate(String phrase){

    phrase = phrase.replace('e' , '3');
    phrase = phrase.replace('E' , '3');
    phrase = phrase.replace('o' , '0');
    phrase = phrase.replace('O' , '0');
    phrase = phrase.replace('I' , '1');
    String[] phraseArray = phrase.split(" ");
    for(Integer index = 0 ; index < phraseArray.length ; index++) {
      if (phraseArray[index].startsWith("S") || phraseArray[index].startsWith("s")) {
        phraseArray[index] = phraseArray[index].replace('s' , 'z');
        phraseArray[index] = phraseArray[index].replace('S' , 'Z');
        if (phraseArray[index].charAt(0) == 'z') {
          phraseArray[index] = phraseArray[index].replaceFirst("z", "s");
        } else {
          phraseArray[index] = phraseArray[index].replaceFirst("Z", "S");
        }
      } else {
        phraseArray[index] = phraseArray[index].replace('s' , 'z');
        phraseArray[index] = phraseArray[index].replace('S' , 'Z');
      }
    }
    String newPhrase = String.join(" ", phraseArray);
    return newPhrase;
  }
}
