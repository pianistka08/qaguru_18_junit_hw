package data;

public enum Locale {
    RU ("Русский"),
    EN ("English");

    final String locale;
    Locale(String locale){
        this.locale = locale;
    }
    public String getLocale(){ return locale;}
}