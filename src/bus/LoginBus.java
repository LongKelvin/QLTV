package bus;

import dal.LoginDal;
import dto.LoginAccountDto;

public class LoginBus {

    LoginDal loginDAL = new dal.LoginDal();
    LoginAccountDto accountDto;
    private String currentUsername;
    private String currentPassword;


    public LoginBus() {
        LoginDal loginDAL = new dal.LoginDal();
    }

    public boolean IsValid(String username, String password) {
        accountDto = new LoginAccountDto();
        currentUsername = currentPassword = "";
        accountDto = loginDAL.CheckAccount(username, password);
        if (accountDto.username != null && accountDto.password != null) {
            if (!accountDto.getPassword().isEmpty() && !accountDto.getUsername().isEmpty()) {
                currentUsername = accountDto.getUsername();
                currentPassword = accountDto.getPassword();
                return true;
            }
        }
        return false;
    }

    public final String GetAccountType(String username) {
        return this.loginDAL.GetAccountType(username);
    }
}