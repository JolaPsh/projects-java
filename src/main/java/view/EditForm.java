package view;

import crudapplication.MainViewUI;
import entity.Book;

/**
 * Created by Joanna Pakosh on 06, 2018
 */

public class EditForm extends AbstractForm {

    public EditForm(MainViewUI mainViewUI) {
        super(mainViewUI);
    }


    /*
     * The main difference between addForm and editForm is binding the data to fields to make them visible
     * to user. The field "Author' is invisible since the creation of the book.
     *
     */
    @Override
    public void setBook(Book book) {

        binder.forField(id).withConverter(Long::valueOf, String::valueOf)
                .bind(Book::getId, Book::setId);
        binder.forField(printYear).withConverter(Integer::valueOf, String::valueOf)
                .bind(Book::getPrintYear, Book::setPrintYear);
        binder.forField(readAlready).withConverter(Boolean::valueOf, String::valueOf)
                .bind(Book::isReadAlready, Book::setReadAlready);
        binder.bindInstanceFields(this);

        this.book = book;
        binder.setBean(book);

        setVisible(true);
        id.setEnabled(false);
        id.setVisible(false);
        author.setVisible(true);
        author.setEnabled(false);

    }

    @Override
    public void save() {
        service.merge(book);
        mainViewUI.updateTable();
        // updating of data using pagination
        mainViewUI.loadItemsPerPage();
        // hide the form after clicking save
        setVisible(false);
        mainViewUI.addButton.setEnabled(true);
    }
}