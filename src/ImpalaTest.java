import java.sql.*;

public class ImpalaTest {
    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        //ResultSet resultSet = null;
        PreparedStatement ps = null;
        boolean flag = false;

        String sql = "use default; insert into f_frn_bh_zgfy_sfcx(seq_no,tran_timestamp,cxqq_bdhm,cxqq_lbst,cxqq_xz," +
                "cxqq_xm,cxqq_zjlx,cxqq_dsrzjhm,cxqq_fymc,cxqq_fydm,cxqq_cbr,cxqq_yhdh,cxqq_ah,cxqq_ckkssj,cxqq_ckjssj," +
                "cxqq_wsbh,cxqq_gj,cxqq_result,cxqq_msg,cxqq_gzzbh,cxqq_gwzbh,cxqq_ckh) partition(tran_date) values ('2020012031157308'," +
                "'145654','A220200805110101100003','YH','1','张忠良','01','110110197411251511','北京市西城区人民法院'," +
                "'111','尹建','','(2014)西执字第03147号','','','A2YHYH00002120200805000002','中国（大陆）','','','','','20200805');";

        try {
            Class.forName("com.cloudera.impala.jdbc41.Driver");
            connection = DriverManager.getConnection("jdbc:impala://47.103.79.104:21051/default");
            ps = connection.prepareStatement(sql);

            flag = ps.execute();

            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //resultSet.close();
                //statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        System.out.println(connection != null ? true : false);
    }
}
