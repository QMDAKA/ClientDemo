import Controller.AppController;
import Controller.RequestController;
import Controller.TokenController;
import model.Application;
import model.Token;
import java.io.IOException;
/**
 * Created by Quang Minh on 5/11/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // tao scope
        //tao application id
        Application app = AppController.RegisterApp();
        //tao application
        AppController.MakeAppId(app.getClient_id());
        //xin cap phat token theo Resource owner password credentials grant
        //make codes
        String code=new String();
        code= TokenController.codeByGrantTypeCodeFlow(app);
        //make token
       // Token token=TokenController.tokenByGrantCodeFlow(app,"minh","123456",code);
        Token token=TokenController.tokenByGrantCodePassword(app,"minh","13456");
        //request len resource server
        RequestController.RequestToRS(token);
    }



}
