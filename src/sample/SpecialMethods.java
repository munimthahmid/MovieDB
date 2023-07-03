package sample;

import javafx.scene.control.Button;

public class SpecialMethods {
    private static final long serialVersionUID = 0L;

    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #6bd0ff;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #3fa0ef; -fx-text-fill: #ffffff;";
    public static void hover(Button b){
        b.setStyle(IDLE_BUTTON_STYLE);
        b.setOnMouseEntered(e -> b.setStyle(HOVERED_BUTTON_STYLE));
        b.setOnMouseExited(e -> b.setStyle(IDLE_BUTTON_STYLE));
    }

    public static String capitalizeWord(String str){
        String words[]=str.split("\\s");
        String cWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String after=w.substring(1);
            cWord+=first.toUpperCase()+after.toLowerCase()+" ";
        }
        return cWord.trim();
    }
}