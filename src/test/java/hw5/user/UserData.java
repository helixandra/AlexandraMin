package hw5.user;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

public class UserData {
    private String login;
    private String password;
    private String fullName;

    private static String changeEncoding(String parameter) throws UnsupportedEncodingException {
        return new String(URLDecoder.decode(parameter, "UTF-8").getBytes("UTF-8"), "UTF-8");
    }

    public UserData() throws UnsupportedEncodingException {
        Properties properties = new Properties();
        String propertiesPath = changeEncoding(getClass().getClassLoader().getResource("config.properties").getPath());

        try (FileInputStream fis = new FileInputStream(propertiesPath)) {
            properties.load(fis);
            login = properties.getProperty("userInfo.login");
            password = properties.getProperty("userInfo.password");
            fullName = properties.getProperty("userInfo.fullName");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
