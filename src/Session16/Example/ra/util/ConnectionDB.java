package Session16.Example.ra.util;

public class ConnectionDB {
    /*
    1. URL cua CSDL can ket noi den
        - address Server cai` CSDL
        - Database name
        - port: 3306
    2. Driver cua CSDL MySQL
    3. Username va Password
    * */

    private static final String URL = "jdbc:mysql://192.168.1.113:3306/EcommerceDB";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";
}
