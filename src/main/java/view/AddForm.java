package view;

import crudapplication.MainViewUI;
import entity.Book;

/**
 * Created by Joanna Pakosh on 06, 2018
 */

public class AddForm extends AbstractForm {

    public AddForm(MainViewUI mainViewUI) {
        super(mainViewUI);
    }

    @Override
    public void setBook(Book book) {
        this.book = book;
        binder.setBean(book);

        setVisible(true);
        id.setEnabled(false);
        id.setVisible(false);
        title.setVisible(true);
        description.setVisible(true);
        author.setVisible(true);
        isbn.setVisible(true);
        printYear.setVisible(true);
        readAlready.setEnabled(false);
        readAlready.setVisible(false);
    }

    @Override
    public void save() {
        service.add(new Book(title.getValue(), description.getValue(), author.getValue(),
                isbn.getValue(), Integer.valueOf(printYear.getValue()), false));

         mainViewUI.updateTable();
         // updating of data using pagination
        mainViewUI.loadItemsPerPage();
         // hide the form after clicking save
        setVisible(false);
        mainViewUI.editButton.setEnabled(true);
    }


}
