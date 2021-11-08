package oit.is.z1314.kaizi.janken.model;

public class Janken {

  public String judge(String YourHand) {
    if (YourHand.equals("gu")) {
      return "あいこ";
    }
    if (YourHand.equals("choki")) {
      return "まけ";
    }
    if (YourHand.equals("pa")) {
      return "かち";
    }
    return "やらかしてる";
  }

  public String ChangeStr(String Hand) {
    if (Hand.equals("gu")) {
      return "グー";
    }
    if (Hand.equals("choki")) {
      return "チョキ";
    }
    if (Hand.equals("pa")) {
      return "パー";
    }
    return "やらかしてる";
  }
}
