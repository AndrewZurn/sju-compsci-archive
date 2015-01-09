package universities;


public class UserController {
    private String username;
    private String password;
    private boolean valid =false;
    private String type;
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    

    /**
     * @return the valid
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * @param valid the valid to set
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    public boolean login(String username, String password){
        try{
            String[][] users = UniversityDBLibrary.getAllUsers();
            valid =false;
            int i=-1;
            for(i=0;i<users.length;i++){
                if(username.equals(users[i][3]) && password.equals(users[i][4])){
                    valid=true;
                    break;
                }
            }
            if(valid){
                if(users[i][5].equals("a")){
                    this.setType("ADMIN");
                }
                else {
                    this.setType("USER");
                }
                this.setUsername(username);
                this.setPassword(password);
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
             return false;
        }
    } 
}
