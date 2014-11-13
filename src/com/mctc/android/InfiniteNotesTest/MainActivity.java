package com.mctc.android.InfiniteNotesTest;

import JavaClasses.NoteItemData;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity
{

   private static final String TAG = "MainActivity";
   /**
    * Called when the activity is first created.
    */
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      FragmentNote fragmentNote = new FragmentNote();
      Log.d(TAG, "Fragment FragmentNavigation Created");

      getFragmentManager().beginTransaction()
            .replace(R.id.container,fragmentNote)
            .commit();
   }


   //methods for options menu
   @Override
   public boolean onCreateOptionsMenu(Menu menu)
   {
      MenuInflater inflater = getMenuInflater() ;
      inflater.inflate(R.menu.main, menu) ;
      return true;
   }//End method onCreateOptionsMenu

   @Override
   public boolean onOptionsItemSelected(MenuItem item)
   {
      // toggle nav drawer on selecting action bar app icon/title
      if (item.getItemId() == R.id.action_settings)
      {
         CreateNote();
      }
      // Handle action bar actions click
       return super.onOptionsItemSelected(item);
   } //END method

  // method to create a new note with an instance
   // Passes data into NoteItemData Object
   private void CreateNote()
   {
      NoteItemData note = NoteItemData.getNew();
      Intent intent = new Intent(this, FragmentNote.class);
      intent.putExtra("key", note.getKey());
      intent.putExtra("text", note.getText());
      startActivityForResult(intent, 1001);// integer value
   }// END CreateNote

   @Override
   public void onListItemClick(ListView l, View v , int position, long id)
   {
      NoteItemData note = noteList.get(position);
      Intent intent = new Intent(this, FragmentNote.class);
      intent.putExtra("key", note.getKey());
      intent.putExtra("text", note.getText());
      startActivityForResult(intent, 1001);// integer value
   }

}// END main activity
