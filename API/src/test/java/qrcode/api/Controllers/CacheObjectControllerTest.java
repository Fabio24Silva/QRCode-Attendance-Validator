package qrcode.api.Controllers;

import org.junit.Test;
import qrcode.api.Models.CacheObject;

import java.time.LocalTime;

import static org.junit.Assert.*;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author João Caçote
 * 
 * @version 1.0
 */

public class CacheObjectControllerTest {

    @Test
    public void checkUuID() {
        CacheObject cacheObject = new CacheObject(1L, LocalTime.of(10,0));
        cacheObject.renew(1L, LocalTime.of(10,0,5));
            assertTrue(cacheObject.checkUuid(1L, LocalTime.of(10,0,6)));
            assertTrue(cacheObject.checkUuid(1L, LocalTime.of(10,0,1)));
            assertTrue(cacheObject.checkUuid(1L, LocalTime.of(10,0,9)));
            assertFalse(cacheObject.checkUuid(1L, LocalTime.of(10,0,11)));
    }
}