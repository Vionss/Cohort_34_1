package ait.user.model;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        setEmail(email);
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isEmailValid(email)) {
            this.email = email;
        } else {
            System.out.println(email + " invalid");
        }


    }
    /*
    1) @ exists and only one (done)
    2) dot after @ (done)
    3) 2 or more symbols after last dot (done)
    4) alphabetic, digits, '_', '-', '.', '@'
     */

    private boolean isEmailValid(String email) {
        int indexAt = email.indexOf('@');
        if (indexAt == -1 || email.indexOf('@', indexAt + 1) >= 0) {
            return false;
        }
        if (email.indexOf(".", indexAt) == -1) {
            return false;
        }
        if (email.lastIndexOf('.') > email.length() - 3) {
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!(Character.isAlphabetic(c) || Character.isDigit(c) || c == '_' || c == '-' || c == '.' || c == '@')) {
                return false;
            }
        }
        return true;

    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        if (isPasswordValid(password)) {
            this.password = password;
        } else {
            System.out.println(password + " invalid");
        }
    }

    /*
       1) length >=8(done)
       2) min one digit (done)
       3) min one symbol in upperCase (done)
       4) min one symbol in lowerCase(done)
       5) min one special symbol (!%@$&) (done)
        */
    private boolean isPasswordValid(String password) {
        boolean hasDigits = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialSymbols = false;

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isDigit(c)) {
                hasDigits = true;
            }
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
            if (c == '!' || c == '%' || c == '$' || c == '@' || c == '&') {
                hasSpecialSymbols = true;
            }
        }
        return hasDigits && hasUpperCase && hasLowerCase && hasSpecialSymbols;



    }
//    private boolean passwordIsValid(String password) {
//        boolean numberPresent = false;
//        boolean upperCasePresent = false;
//        boolean lowerCasePresent = false;
//        boolean specialCharacterPresent = false;
//        String specialChars = "!%@*&";
//
//
//        if(password.length() < 8) {
//            return false;
//        }
//
//        for (int i = 0; i < password.length(); i++) {
//            char c = password.charAt(i);
//
//            if (Character.isDigit(c)) {
//                numberPresent = true;
//            } else if (Character.isUpperCase(c)) {
//                upperCasePresent = true;
//            } else if (Character.isLowerCase(c)) {
//                lowerCasePresent = true;
//            } else if (specialChars.contains(String.valueOf(c))) {
//                specialCharacterPresent = true;
//            }
//        }
//        return
//                numberPresent && upperCasePresent && lowerCasePresent && specialCharacterPresent;
//    }




    @Override

    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

}
