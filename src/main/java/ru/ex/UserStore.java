package ru.ex;

import java.util.Objects;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int lengthArray = users.length - 1;
        for (int i = 0; i <= lengthArray; i++) {
            if (Objects.equals(users[i].getUsername(), login)) {
                return users[i];
            } else {
                throw new UserNotFoundException("User not found");
            }
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("The user is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Iva", true)
        };
        try {
            User user = findUser(users, "Iva");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            ei.printStackTrace();
        } catch (UserNotFoundException enf) {
            enf.printStackTrace();
        }
    }
}
