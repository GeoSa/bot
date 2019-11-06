import java.util.ArrayList;
import java.util.List;

class Notes {
    private static List<String> notesList = new ArrayList<>();

    static String getNotes() {
        StringBuilder text = new StringBuilder();
        if (!notesList.isEmpty()) {
            int i = 1;
            for (String note: notesList) {
                text.append(String.format("%d. %s%n", i, note));
                i++;
            }
            return text.toString();
        }
        else { return "There is no notes in the list"; }
    }

    static void addNote(String text) {
        notesList.add(text);
    }

    static void deleteNote(String text) {
        if (!notesList.isEmpty()) {
            int position = Integer.parseInt(text);
            notesList.remove(position - 1);
        }
    }
}
