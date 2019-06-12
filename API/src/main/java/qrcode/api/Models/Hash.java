package qrcode.api.Models;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author Fábio Silva 
 *         Daniel Pinto
 *         João Caçote 
 * @version 1.0
 */
public final class Hash {
    private static ConcurrentHashMap<Long, CacheObject> cacheObjectConcurrentHashMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, ConcurrentHashMap<String, Integer>> phoneIDs = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, ConcurrentHashMap<Integer, Aluno>> alunos = new ConcurrentHashMap<>();


    public static ConcurrentHashMap<Long, CacheObject> getCacheObjectConcurrentHashMap() {
        return cacheObjectConcurrentHashMap;
    }

    public static ConcurrentHashMap<Long, ConcurrentHashMap<String, Integer>> getphoneIDs() {
        return phoneIDs;
    }

    public static ConcurrentHashMap<Long, ConcurrentHashMap<Integer, Aluno>> getalunos() {
        return alunos;
    }
}
