package view;

import controller.empManager.EmpManager;

public class Client {
    public static final ControllerProxy proxy = new ControllerProxy();

    public static void main(String[] args) {
        proxy.displayAllList();
        proxy.addEmp();
        proxy.displayAllList();
        proxy.removeEmpById();
        proxy.displayAllList();
    }

}
