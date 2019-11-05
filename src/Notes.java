import java.util.ArrayList;
import java.util.List;

class Notes {
    private static List<String> notesList = new ArrayList<String>();

    static String getNotes() {
        String text = "";
        if (!notesList.isEmpty()) {
            int i = 1;
            for (String note: notesList) {
                text += String.format("%s%n", note);
                i++;
            }
            return text;
        }
        else { return "There is no notes in the list"; }
    }

    static void addNote(String text) {
        notesList.add(text);
    }

    static void deleteNote(String text) {
        notesList.remove(text);
    }
}
