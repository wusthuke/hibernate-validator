package org.huke.demo.validator.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author huke
 * @create 22/6/2017
 */
public class User implements Serializable {

    private static final long serialVersionUID = 7275131358453458003L;

    @NotNull
    @Size(min = 2, max = 10)
    private String username;

    private String password;

    @Phone
    private String phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
