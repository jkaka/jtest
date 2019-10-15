package com.kaka.jtest.aliyun.odps.table;

import com.aliyun.odps.Table;
import com.kaka.jtest.aliyun.odps.OdpsBaseTest;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 11:26
 */
public class TableTest extends OdpsBaseTest {

    @Test
    public void listTableTest() {
        for (Table t : odps.tables()) {
            System.out.println(t.getName());
        }
    }
}
