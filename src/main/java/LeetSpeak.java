import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class LeetSpeak {
  public static void main(String[] args) {

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
