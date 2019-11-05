import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText(input(update.getMessage().getText()));

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "@simpleblinBot";
    }

    @Override
    public String getBotToken() {
        return "984012995:AAEqybJUmtsl5JbGhmKWdZ5tBzoDm7ISUFM";
    }

    private String input(String text) {
        if(text.contains("Hi") || text.contains("hi") || text.contains("Hello") || text.contains("hello") || text.contains("Привет") || text.contains("привет")) {
            return "Hello, human!";
        }
        else if (text.contains("/list")) {
            return Notes.getNotes();
        }
        else if (text.contains("/add")) {
            String note = text.replace("/add ", "");
            Notes.addNote(note);
            return "The note has been added";
        }
        else if (text.contains("/delete")) {
            String note = text.replace("/delete ", "");
            Notes.deleteNote(note);
            return "The note has been deleted!";
        }
        return "Don't understand";
    }
}
