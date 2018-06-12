package view;

import crudapplication.MainViewUI;
import entity.Book;
import service.ServiceImpl;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Joanna Pakosh on 06, 2018
 */

public abstract class AbstractForm extends FormLayout {

    protected Book book;
    protected MainViewUI mainViewUI;
    protected TextField id = new TextField("ID");
    protected TextField title = new TextField("Title");
    protected TextField description = new TextField("Description");
    protected TextField author = new TextField("Author");
    protected TextField isbn = new TextField("Isbn");
    protected TextField printYear = new TextField("PrintYear");
    public TextField readAlready = new TextField("ReadAlready");

    protected Button saveButton = new Button("Save");
    protected Button cancelButton = new Button("Cancel");

    ServiceImpl service = new ServiceImpl();
    Binder<Book> binder = new Binder<>(Book.class);

    public AbstractForm(MainViewUI mainViewUI) {
        this.mainViewUI = mainViewUI;
        setMargin(true);
        setSpacing(true);
        setSizeUndefined();
        setStyleName(ValoTheme.COMBOBOX_ALIGN_CENTER);
        addComponents(id, title, description, author, isbn, printYear, readAlready, new HorizontalLayout(saveButton, cancelButton));
        saveButton.addStyleName("save-and-cancel-btn");
        saveButton.focus();
        cancelButton.addStyleName("save-and-cancel-btn");
        saveButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        saveButton.addClickListener(e -> checkValues());
        cancelButton.addClickListener(e -> {
            this.setVisible(false);
              mainViewUI.editButton.setEnabled(true);
              mainViewUI.addButton.setEnabled(true);
            return;
        });

    }

    protected void checkValues() {
        Matcher m = Pattern.compile("\\d{4}").matcher(printYear.getValue());
            if (title.isEmpty() || author.isEmpty() || isbn.isEmpty() || printYear.isEmpty()) {
                Notification.show("Please, fill out all required fields");
                return;
            }
            if (!m.matches()) {
               Notification.show("The field \"PrintYear\" must contain at least four numbers");
               return;
        }

        save();
    }

    public abstract void save();

    public abstract void setBook(Book book);
}
