package crudapplication;

import entity.Book;
import service.ServiceImpl;
import view.AddForm;
import view.EditForm;

import com.vaadin.addon.pagination.Pagination;
import com.vaadin.addon.pagination.PaginationResource;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Joanna Pakosh on 06, 2018
 */

@Theme("mytheme")
@SpringUI
public class MainViewUI extends UI {

    private static final long serialVersionUID = 1L;
    private ServiceImpl service = new ServiceImpl();

    private final int page = 1;
    private final int limit = 10;   // number of records on one page
    private final long total = Long.valueOf(service.count()); // total number of records in a table

    private final TextField filter = new TextField();
    private Binder<Book> binder = new Binder<>(Book.class);

    private Book book;
    private AddForm addForm = new AddForm(this);
    private EditForm editForm = new EditForm(this);
    public Button addButton = new Button("Add", VaadinIcons.PLUS_CIRCLE);
    public Button editButton = new Button("Edit", VaadinIcons.PENCIL);
    private Button deleteButton = new Button("Delete", VaadinIcons.TRASH);

    public List<Book> listWithAllBooks = service.findAll();
    private final List<Book> subListWithBooks = listWithAllBooks.subList(0, limit);
    Grid<Book> mTable = createGrid(subListWithBooks);

    final PaginationResource paginationResource = PaginationResource.newBuilder().setTotal(total).setPage(page).setLimit(limit).build();
    final Pagination pagination = new Pagination(paginationResource);


    @Override
    public void init(VaadinRequest vaadinRequest) {

        addForm.setSpacing(true);
        addForm.setMargin(true);
        addForm.setVisible(false);

        editForm.setSpacing(true);
        editForm.setMargin(true);
        editForm.setVisible(false);

        pagination.setItemsPerPageVisible(false);
        addPagination();

        mTable.addSelectionListener(e -> {
            updateForm();
        });


        filter.setPlaceholder("Search..");
        filter.setWidth("300px");

        filter.addValueChangeListener(e -> {
            List<Book> list = service.filterByTitleAndAuthor(e.getValue()).stream().distinct().collect(Collectors.toList());
            mTable.setItems(list);
            setFormVisible(true);

        });

        filter.setValueChangeMode(ValueChangeMode.LAZY);

        addButton.addClickListener(e -> {
                    /*
                     * When a user clicks on 'addButton', then the 'editButton' will be unavailable. After clicking save (see class EditForm)
                     * or cancel (see class AbstractForm), it will be available again.
                     */
                    editButton.setEnabled(false);
                    mTable.asSingleSelect().clear();
                    addForm.setBook(book);
                }
        );


        editButton.addClickListener(e -> {
            if (mTable.getSelectedItems().isEmpty()) {
                return;
            }
            if (!mTable.getSelectedItems().isEmpty()) {
                /*
                 * When a user clicks on 'editButton', then the 'addButton' will be unavailable. After clicking save (see class EditForm)
                 * or cancel (see class AbstractForm), it will be available again.
                 */
                addButton.setEnabled(false);
                Book someBook = mTable.asSingleSelect().getValue();
                /*
                 * If the value of a field 'ReadAlready' is true, the field in not available for editing,
                 * it can be changed only if it is false.
                 */
                if (someBook.isReadAlready()) {
                    editForm.readAlready.setEnabled(false);
                    editForm.setBook(someBook);
                } else {
                    editForm.readAlready.setEnabled(true);
                    editForm.setBook(someBook);
                }
            }

        });

        deleteButton.addClickListener(e -> {
            if (mTable.getSelectedItems().isEmpty()) {
                return;
            }
            if (!mTable.getSelectedItems().isEmpty()) {
                setEnabled(true);
                service.delete(book.getId());

                loadItemsPerPage();
                Notification.show("Deleted: " + "\nTitle: " + book.getTitle() + "\nAuthor:" + book.getAuthor());
            }
        });

        VerticalLayout layout = new VerticalLayout();
        HorizontalLayout toolbar = new HorizontalLayout(filter, addButton, editButton, deleteButton);

        HorizontalLayout horLayout = new HorizontalLayout();
        horLayout.addComponents(mTable, addForm, editForm);
        horLayout.setSizeFull();
        mTable.setSizeFull();
        horLayout.setExpandRatio(mTable, 1);

        layout.addComponents(toolbar, horLayout, pagination);
        setContent(layout);
    }


    public void updateTable() {
        ListDataProvider<Book> dataProvider = new ListDataProvider<>(subListWithBooks);
        mTable.setDataProvider(dataProvider);
        setFormVisible(true);
    }

    private void setFormVisible(boolean visible) {
        mTable.setVisible(visible);
    }


    public Grid createGrid(List<Book> listWithBooks) {
        Grid<Book> grid = new Grid<>(Book.class);
        grid.setItems(listWithBooks);
        grid.setSizeFull();
        grid.setColumns("id", "title", "description", "author", "isbn", "printYear", "readAlready");
        return grid;
    }

    private void updateForm() {
        if (!mTable.asSingleSelect().isEmpty()) {
            book = mTable.asSingleSelect().getValue();
            binder.setBean(book);
            setFormVisible(true);
        }
    }

    public void addPagination() {
        pagination.addPageChangeListener(e -> {
            loadItemsPerPage();
        });

    }

    public void loadItemsPerPage() {
        mTable.setItems(service.displayPage(paginationResource.page(), limit));
    }
}





