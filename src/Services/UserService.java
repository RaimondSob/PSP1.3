package Services;

import Entity.User;
import Repositories.UserRepository;
import validation.EmailPolicy;
import validation.PasswordPolicy;
import validation.PhoneNumberPolicy;
import validation.Validation;

public class UserService {
    Validation validate = new Validation();
    PasswordPolicy passwordPolicy = new PasswordPolicy();
    EmailPolicy emailPolicy = new EmailPolicy();
    PhoneNumberPolicy phoneNumberPolicy = new PhoneNumberPolicy();
    UserRepository userRepository = new UserRepository();

    public User CreateUser(User user)
    {
        Integer errorCode = 0;

        if(validate.checkPassword(user.Password,passwordPolicy).length != 0) errorCode = 1;
        if(validate.checkEmail(user.Email,emailPolicy).length != 0) errorCode = 1;
        if(validate.checkPhoneNumber(user.Number, phoneNumberPolicy).length != 0) errorCode = 1;
        if(errorCode == 0)
        {
            user.setId(userRepository.GenerateId());
            userRepository.Add(user);
        }
        if(errorCode == 1)
        {
            return null;
        }
        return user;
    }
    public User GetById(Integer id)
    {
        return userRepository.GetById(id);
    }
    public Boolean DeleteById(Integer id)
    {
        return userRepository.DeleteById(id);
    }
    public Boolean UpdateById(Integer id, User user)
    {
        return userRepository.UpdateById(id, user);
    }
}
