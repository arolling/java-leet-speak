import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class LeetSpeakTest {

  @Test
  public void leetSpeakTranslate_returnsAStringAsIsWhenNoLeetspeakIsPresent_wordDoesntChange() {
    LeetSpeak testApp = new LeetSpeak();
    assertEquals("happy", testApp.leetSpeakTranslate("happy"));
  }

  @Test
  public void leetSpeakTranslate_replacesEveryEInAStringWithA3_wordChanges() {
    LeetSpeak testApp = new LeetSpeak();
    assertEquals("3l3phant", testApp.leetSpeakTranslate("Elephant"));
  }

  @Test
  public void leetSpeakTranslate_replacesEveryOInAStringWithA0_wordChanges() {
    LeetSpeak testApp = new LeetSpeak();
    assertEquals("b00 b00", testApp.leetSpeakTranslate("boo boo"));
  }

  @Test
  public void leetSpeakTranslate_replacesEveryIInAStringWithA1_wordChanges() {
    LeetSpeak testApp = new LeetSpeak();
    assertEquals("1 lik3 1k3", testApp.leetSpeakTranslate("I like Ike"));
  }

  @Test
  public void leetSpeakTranslate_replacesEverySInAStringWithAZ_wordChanges() {
    LeetSpeak testApp = new LeetSpeak();
    assertEquals("r0z3z ar3 r3d", testApp.leetSpeakTranslate("roses are red"));
  }

  @Test
  public void leetSpeakTranslate_doesNotReplaceSWhenFirstLetter_wordChanges() {
    LeetSpeak testApp = new LeetSpeak();
    assertEquals("Suzi3z Sunzhin3", testApp.leetSpeakTranslate("Susies Sunshine"));
  }

  @Test
  public void leetSpeakTranslate_makesCorrectReplacementsRegardlessOfCase_ignoresUppercase() {
    LeetSpeak testApp = new LeetSpeak();
    assertEquals( "1 Scr3amz y0u scr3amz w3 all scr3am f0r razpb3rry ic3 cr3am!", testApp.leetSpeakTranslate("I Screams you screams we all scream for raspberry ice cream!"));
  }

}
