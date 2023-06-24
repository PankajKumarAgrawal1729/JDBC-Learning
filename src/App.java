import java.sql.*;

class App{
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Student";
        String uname = "root";
        String pass = "";

        //to fetch one record
        String query1 = "select name from record where Roll_No=1";

        //Try-with-resources to ensure resources are closed properly
        try (Connection con = DriverManager.getConnection(url, uname, pass);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query1)) {

            //Check if result set has any records
            if(rs.next()){
                // Process the result
                String name = rs.getString("name");   // column names are case-sensitive
                System.out.println(name);
            } else {
                System.out.println("No records found for Roll_No=2");
            }
            con.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
