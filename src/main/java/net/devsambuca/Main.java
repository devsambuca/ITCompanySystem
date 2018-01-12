package net.devsambuca;

import net.devsambuca.view.ViewEntity;
import net.devsambuca.view.ViewMenu;

public class Main {

    public static void main(String[] args) {
        ViewEntity developerView = new ViewEntity();
        ViewMenu viewMenu = new ViewMenu();

        viewMenu.run();
        developerView.run();
    }
}
