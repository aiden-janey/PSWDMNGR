package ca.sheridancollege.janeya.tools;

/**
 *
 * @author Aiden Janey
 */
public class UserIDCreation
{
    private final char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private final char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
    'k', 'l', 'm', 'n', 'o', 'p', 'q','r', 's', 't', 'u', 'v', 'w','x','y','z'};
    
    public UserIDCreation(){}
    
    public String createId(int passLength)
    {
        String password = "";
        for(int i = 0; i<passLength; i++)
        {
            int indexChar = (int)(3*Math.random());
            int arrayIndex;
            switch(indexChar)
            {
                case 0:
                    arrayIndex = (int)(Math.random()*26);
                    password+=letters[arrayIndex];
                    break;
                case 1:
                    arrayIndex = (int)(Math.random()*26);
                    password+=Character.toUpperCase(letters[arrayIndex]);
                    break;
                default:
                    arrayIndex = (int)(Math.random()*10);
                    password+=numbers[arrayIndex];
                    break;  
            }
        }
        return password;
    }
}
