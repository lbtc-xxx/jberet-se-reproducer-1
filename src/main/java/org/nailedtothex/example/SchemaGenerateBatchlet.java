package org.nailedtothex.example;

import javax.batch.api.AbstractBatchlet;
import java.sql.Connection;
import java.sql.Statement;

public class SchemaGenerateBatchlet extends AbstractBatchlet {
    @Override
    public String process() throws Exception {
        try (Connection cn = MyDatabaseUtil.getConnection()) {
            try (Statement st = cn.createStatement()) {
                try {
                    st.executeUpdate("drop table forex");
                } catch (Exception e) {
                    // nop
                }
                st.executeUpdate("CREATE TABLE forex (\n" +
                        "    symbol VARCHAR(6) NOT NULL,\n" +
                        "    ts TIMESTAMP NOT NULL,\n" +
                        "    bid_open NUMERIC(10,3) NOT NULL,\n" +
                        "    bid_high NUMERIC(10,3) NOT NULL,\n" +
                        "    bid_low NUMERIC(10,3) NOT NULL,\n" +
                        "    bid_close NUMERIC(10,3) NOT NULL,\n" +
                        "    volume INTEGER NOT NULL,\n" +
                        "    PRIMARY KEY(symbol, ts)\n" +
                        ")");
            }
        }
        return null;
    }
}
