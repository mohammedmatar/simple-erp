package core.warehouses;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import core.MyUI;

/**
 * Created by esdeath on 12/6/15.
 */
public class WarehousesMainScreen extends CssLayout implements View {
   public static String VIEW_NAME = "Warehouses";
    public WarehousesMainScreen(){initComponents();}
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        new Notification("WareH").show(MyUI.getCurrent().getPage());
    }
    private void initComponents(){
        warehouses = new Button("Warehouse");
        supplers   = new Button("Supplers");
        requests   = new Button("Requests");
        receives   = new Button("Receives");

        warehouses.setWidth(200, Unit.PIXELS);
        supplers.setWidth(200, Unit.PIXELS);
        requests.setWidth(200, Unit.PIXELS);
        receives.setWidth(200, Unit.PIXELS);

        warehouses.setHeight(100, Unit.PIXELS);
        supplers.setHeight(100, Unit.PIXELS);
        requests.setHeight(100, Unit.PIXELS);
        receives.setHeight(100, Unit.PIXELS);


        VerticalLayout centeringLayout = new VerticalLayout();
        GridLayout     dashboard   = new GridLayout(2,2);


        dashboard.addComponent(warehouses, 0,0);
        dashboard.addComponent(supplers, 0,1);
        dashboard.addComponent(requests, 1,0);
        dashboard.addComponent(receives, 1,1);


        centeringLayout.addComponent(dashboard);
        addComponent(centeringLayout);

        setSizeFull();
        centeringLayout.setSizeFull();
        centeringLayout.setComponentAlignment(dashboard, Alignment.MIDDLE_CENTER);
//        dashboard.setRowExpandRatio(1, 1f);

    }
    private Button warehouses;
    private Button requests;
    private Button receives;
    private Button supplers;
}
