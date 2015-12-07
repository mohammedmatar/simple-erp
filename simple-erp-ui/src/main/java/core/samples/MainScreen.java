package core.samples;

import core.MyUI;
import core.accounting.AccountingMainScreen;
import core.hr.HRMainScreen;
import core.samples.about.AboutView;
import core.samples.crud.SampleCrudView;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import core.warehouses.WarehousesMainScreen;

/**
 * Content of the UI when the user is logged in.
 * 
 * 
 */
public class MainScreen extends HorizontalLayout {
    private Menu menu;

    public MainScreen(MyUI ui) {

        setStyleName("main-screen");

        CssLayout viewContainer = new CssLayout();
        viewContainer.addStyleName("valo-content");
        viewContainer.setSizeFull();

        final Navigator navigator = new Navigator(ui, viewContainer);
        navigator.setErrorView(ErrorView.class);
        menu = new Menu(navigator);
        menu.addView(new SampleCrudView(), SampleCrudView.VIEW_NAME, SampleCrudView.VIEW_NAME, FontAwesome.EDIT);
        menu.addView(new WarehousesMainScreen(), WarehousesMainScreen.VIEW_NAME, WarehousesMainScreen.VIEW_NAME, FontAwesome.HOME);
        menu.addView(new AccountingMainScreen(), AccountingMainScreen.VIEW_NAME, AccountingMainScreen.VIEW_NAME, FontAwesome.MONEY);
        menu.addView(new HRMainScreen(), HRMainScreen.VIEW_NAME, HRMainScreen.VIEW_NAME, FontAwesome.GROUP);
        menu.addView(new AboutView(), AboutView.VIEW_NAME, AboutView.VIEW_NAME,
                FontAwesome.INFO_CIRCLE);

        navigator.addViewChangeListener(viewChangeListener);

        addComponent(menu);
        addComponent(viewContainer);
        setExpandRatio(viewContainer, 1);
        setSizeFull();
    }
    // notify the view menu about view changes so that it can display which view
    // is currently active
    ViewChangeListener viewChangeListener = new ViewChangeListener() {

        @Override
        public boolean beforeViewChange(ViewChangeEvent event) {
            return true;
        }

        @Override
        public void afterViewChange(ViewChangeEvent event) {
            menu.setActiveView(event.getViewName());
        }

    };
}
