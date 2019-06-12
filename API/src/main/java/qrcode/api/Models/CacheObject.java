package qrcode.api.Models;

import java.time.LocalTime;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author Fábio Silva 
 *         Daniel Pinto
 * @version 1.0
 */
public class CacheObject {

    private long uuid;
    private LocalTime ts;
    private long uuid_old;
    private LocalTime ts_old;

    public CacheObject(long uuid, LocalTime ts) {
        this.uuid = uuid;
        this.ts = ts;
    }

    /**
     * Método que renova os dados deste objecto
     *
     * @param uuid_new passara a ser o uuid
     * @param ts_new   passara a ser o ts
     */
    public void renew(long uuid_new, LocalTime ts_new) {
        this.uuid_old = this.uuid;
        this.ts_old = this.ts;
        this.uuid = uuid_new;
        this.ts = ts_new;
    }

    /**
     *  Método para validar se o qrlido está dentro do tempo aceite
     * @param uuid
     * @param ts
     * @return
     */
    public boolean checkUuid(Long uuid, LocalTime ts) {
        if (this.ts.isBefore(ts) && this.ts.plusSeconds(5).isAfter(ts)) {
            if (uuid == this.uuid)
                return true;
        }
        else if(this.ts_old!=null){
            if (this.ts_old.isBefore(ts) && this.ts_old.plusSeconds(5).isAfter(ts)) {
                if (uuid == this.uuid_old)
                    return true;
            }
        }
        return false;
    }

    public long getUuid() {
        return uuid;
    }

}
