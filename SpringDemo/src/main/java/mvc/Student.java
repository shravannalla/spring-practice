package mvc;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;

    private String country;

    private String favoriteLanguage;

    private String[] operatingSystems;

    private LinkedHashMap<String, String> countryOptions;
    //private LinkedHashMap<String,String> langOptions;
    public Student(){
        //populate country options
        countryOptions=new LinkedHashMap<>();
        countryOptions.put("IN", "India");
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("GE", "Germany");
        countryOptions.put("US", "United States of America");
//        langOptions=new LinkedHashMap<>();
//        langOptions.put("Java","java");
//        langOptions.put("C#","c#");
//        langOptions.put("PHP","php");
//        langOptions.put("Ruby","ruby");
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getCountry(){
        return country;
    }
    public LinkedHashMap<String,String> getCountryOptions(){
        return countryOptions;
    }
//    public LinkedHashMap<String,String> getLangOptions(){
//        return langOptions;
//    }
    public String[] getOperatingSystems(){
        return operatingSystems;
    }
    public String getFavoriteLanguage(){
        return favoriteLanguage;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setCountry(String country){
        this.country=country;
    }
    public void setFavoriteLanguage(String favoriteLanguage){
        this.favoriteLanguage=favoriteLanguage;
    }
    public void setOperatingSystems(String[] operatingSystems){
        this.operatingSystems=operatingSystems;
    }

}
