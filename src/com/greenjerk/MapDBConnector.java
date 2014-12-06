package com.greenjerk;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * Created by greenjerk on 23.11.14
 */
public class MapDBConnector {

    public DB getDB() {
        return DBMaker.newFileDB(new File("mapdb/graphic_editor"))
                .closeOnJvmShutdown()
                .encryptionEnable("password")
                .make();
    }

    public Integer getDefaultTab() {
        DB db = getDB();
        Integer defaultTab = 0;
        ConcurrentNavigableMap<String,Boolean> map = db.getTreeMap("tabs"); // open existing an collection (or create new)
        for(Map.Entry<String,Boolean> entry : map.entrySet()) {
            if(entry.getValue()) {
                return Integer.valueOf(entry.getKey());
            }
        }
        db.close();
        return defaultTab;
    }

    public void setDefaultTab(String id) {
        DB db = getDB();
        ConcurrentNavigableMap<String,Boolean> map = db.getTreeMap("tabs");
        for(Map.Entry<String,Boolean> entry : map.entrySet()) {
            if(entry.getValue()) {
                map.put(entry.getKey(), !entry.getValue());
                break;
            }
        }
        map.put(id, true);
        db.commit();
        db.close();
    }
}
