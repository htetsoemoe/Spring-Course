import java.sql.*;

public class BankTransactionDemo {
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
            PreparedStatement find_saving_amount_by_id = connection.prepareStatement("select amount from saving_account where id = ?");
            PreparedStatement deposit_withdraw_saving_account = connection.prepareStatement("update saving_account set amount = ? where id = ?")
        ) {
            int transferAmount = 1500;

            connection.setAutoCommit(false);
            withdrawSavingAccount(1, find_saving_amount_by_id, deposit_withdraw_saving_account, transferAmount);
            depositSavingAccount(2, find_saving_amount_by_id, deposit_withdraw_saving_account, transferAmount);
            connection.commit();

            System.out.println("LP's amount in saving account : " + findSavingAmountById(1, find_saving_amount_by_id));
            System.out.println("KH's amount i saving account : " + findSavingAmountById(2, find_saving_amount_by_id));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static int withdrawSavingAccount(int id, PreparedStatement find, PreparedStatement update, int amount) throws SQLException {
        int existingAmount = findSavingAmountById(id, find);
        int updateAmount = existingAmount - amount;

        if (updateAmount < 0) {
            throw new IllegalArgumentException(amount + " is insufficient!");
        }

        update.setInt(1, updateAmount);
        update.setInt(2, id);
        update.executeUpdate();

        return updateAmount;
    }


    public static int depositSavingAccount(int id, PreparedStatement find, PreparedStatement update, int amount) throws SQLException {
        int existingAmount = findSavingAmountById(id, find);
        int updateAmount = existingAmount + amount;

        update.setInt(1, updateAmount);
        update.setInt(2, id);
        update.executeUpdate();

        return updateAmount;
    }


    public static int findSavingAmountById(int id, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        int amount = 0;
        while (resultSet.next()) {
            amount = resultSet.getInt("amount");
        }

        return amount;
    }
}
