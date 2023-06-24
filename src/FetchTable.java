//load
import java.sql.*;

public class FetchTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Student";
        String uname = "root";
        String pass = "";
        String query = "Select * from record";

        try(Connection con = DriverManager.getConnection(url, uname, pass)){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                String userData = rs.getInt(1) + " " + rs.getString(2);
                System.out.println(userData);
            }
            con.close();
            st.close();
            rs.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
