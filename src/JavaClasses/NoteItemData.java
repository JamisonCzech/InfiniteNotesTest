package JavaClasses;


import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteItemData
{
   private String key;
   private String text;

   // public getters and setters
   public String getKey()
   {
      return key;
   }

   public void setKey(String key)
   {
      this.key = key;
   }

   public String getText()
   {
      return text;
   }

   public void setText( String text )
   {
      this.text = text;
   }


   // Get a US Datatime stamp that also helps with sorting
   @SuppressLint("SimpleDateFormat")

    public static NoteItemData getNew()
   {
      Locale locale = new Locale("en_US");
      Locale.setDefault(locale);

      // use SimpleDate class to create data
      String pattern = " yyyy-MM-dd HH:mm:ss Z";
      SimpleDateFormat formatter = new SimpleDateFormat(pattern);
      String key = formatter.format(new Date());

      NoteItemData note = new NoteItemData();
      note.setKey(key);
      note.setText("");
      return note;
   }

   @Override
   public String toString()
   {
      return this.getText();
   }
}//END class NoteItemData