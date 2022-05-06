package com.jstarcraft.nlp.local;

import java.io.File;
import java.io.IOException;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;

public class IpTestCase {

    public static String getCityInfo(String ip) throws Exception {
        // db
        String dbPath = IpTestCase.class.getClassLoader().getResource("ip2region/ip2region.db").getPath();

        File file = new File(dbPath);
        if (file.exists() == false) {
            System.out.println("Error: Invalid ip2region.db file");
        }

        // 查询算法
        int algorithm = DbSearcher.BTREE_ALGORITHM; // B-tree
        // DbSearcher.BINARY_ALGORITHM //Binary
        // DbSearcher.MEMORY_ALGORITYM //Memory
        DbConfig config = new DbConfig();
        DbSearcher searcher = new DbSearcher(config, dbPath);

        // define the method
        Function<String, DataBlock> method = null;
        switch (algorithm) {
        case DbSearcher.BTREE_ALGORITHM:
            method = text -> {
                try {
                    return searcher.btreeSearch(text);
                } catch (IOException e) {
                    return null;
                }
            };
            break;
        case DbSearcher.BINARY_ALGORITHM:
            method = (text) -> {
                try {
                    return searcher.binarySearch(text);
                } catch (IOException e) {
                    return null;
                }
            };
            break;
        case DbSearcher.MEMORY_ALGORITYM:
            method = text -> {
                try {
                    return searcher.memorySearch(text);
                } catch (IOException e) {
                    return null;
                }
            };
            break;
        }

        DataBlock dataBlock = null;
        if (Util.isIpAddress(ip) == false) {
            System.out.println("Error: Invalid ip address");
        }

        dataBlock = method.apply(ip);

        return dataBlock.getRegion();
    }

    @Test
    public void test() throws Exception {
        String ip = "119.131.76.71";
        String cityIpString = getCityInfo(ip);
        System.out.println(cityIpString);
        String[] splitIpString = cityIpString.split("\\|");
        cityIpString = splitIpString[3].replaceAll("市", "");
        System.out.println(cityIpString);
    }

}
