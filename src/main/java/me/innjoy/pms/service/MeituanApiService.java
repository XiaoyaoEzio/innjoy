package me.innjoy.pms.service;

import java.io.IOException;
import java.util.Map;

/**
 *
 */
public interface MeituanApiService {
    void updateRoomInfo() throws IOException;

    String openDoor() throws IOException;

    void enableCustomerPassword() throws IOException;

    Map<String, String> disableCustomerPassword() throws IOException;

    void queryCustomerPassword() throws IOException;

    void setManagerPassword() throws IOException;

    void getManagerPassword() throws IOException;

    void getTemporaryPassword() throws IOException;

    void queryLockStatus() throws IOException;

    void queryOpenDoorLog() throws IOException;
}
