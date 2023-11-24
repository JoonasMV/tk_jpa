package application;

import entity.*;
import dao.*;

public class DeviceApp {

    public static void main(String[] args) {
    	
    	Dao dao = new Dao();
    	
        Device l1 = new Device("Dell Latitude 7490");
        dao.saveDevice(l1);
        System.out.println("Device saved.");
        System.out.println(l1.getDeviceId());

        Device d = dao.getDevice(1);
        System.out.println("Device fetched.");
        System.out.println(d);

        dao.updateDeviceDescription(1, "Dell Latitude 7491");
        System.out.println(dao.getDevice(1));

        dao.deleteDevice(1);
    }
}

