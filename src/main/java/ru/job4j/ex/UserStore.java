package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User other = new User("", true);
        for (User user: users) {
            if (user == null) {
                throw new UserNotFoundException("This user does not have access");
            }
            if (user.getUsername().contains(login)) {
                other = user;
            }
        }
        return other;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!(user.isValid()) || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException eu) {
            eu.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
