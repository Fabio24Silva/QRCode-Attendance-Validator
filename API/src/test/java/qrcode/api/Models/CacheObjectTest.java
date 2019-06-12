package qrcode.api.Models;

import org.junit.Test;
import java.time.LocalTime;
import static org.junit.Assert.*;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author Fábio Silva
 * @version 1.0
 */
public class CacheObjectTest {

    @Test
    public void renew() {
    }

    @Test
    public void checkUuid() {
    CacheObject cacheObject=new CacheObject(1L, LocalTime.now());
        assertTrue(cacheObject.checkUuid(1L,LocalTime.now()));
        assertFalse(cacheObject.checkUuid(1L,LocalTime.of(10,0)));
    }
}